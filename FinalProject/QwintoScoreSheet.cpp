#include "QwintoScoreSheet.h"
#include "ScoreSheet.h"
#include "Colour.h"
#include <string>

std::string QwintoScoreSheet::printLine(const int & start, const int & end) const
{
	std::string line = "";
	line += "\n";
	for (int i = 0; i < end; ++i) {
		if (i < start)
			line += " ";
		else
			line += "-";
	}
	line += "\n";
	
	return line;
}

int QwintoScoreSheet::getBonusColumnValue(int redIndex, int yellowIndex, int blueIndex, Colour col)
{
	// If they are all set, return the appropriate bonus value
	if (redRow[redIndex] > 0 && yellowRow[yellowIndex] && blueRow[blueIndex]) {
		switch (col) {
		case Colour::RED:
			return redRow[redIndex];
		case Colour::YELLOW:
			return yellowRow[yellowIndex];
		case Colour::BLUE:
			return blueRow[blueIndex];
		}
		// If they are all not set return 0, no bonus is given 
	}
	return 0;
}

 	int QwintoScoreSheet::calcTotal()
{
	// Add up the points from each of the rows
	currentScore += redRow.getRowScore();
	currentScore += yellowRow.getRowScore();
	currentScore += blueRow.getRowScore();

	// Check the bonus sections of the things
	currentScore += getBonusColumnValue(1, 2, 3, Colour::BLUE);
	currentScore += getBonusColumnValue(2, 3, 4, Colour::RED);
	currentScore += getBonusColumnValue(6, 7, 8, Colour::RED);
	currentScore += getBonusColumnValue(7, 8, 9, Colour::YELLOW);
	currentScore += getBonusColumnValue(8, 9, 10, Colour::BLUE);

	return currentScore;
} 

std::ostream & QwintoScoreSheet::printSheet(std::ostream & stream) const
{
	// 8 is added because of the displacement of the colour names

	stream << printLine(6+8, 37+8);
	stream << "RED     " << "      |" << redRow;
	stream << printLine(3+8, 37+8);
	stream << "Yellow  " << "   |" << yellowRow;
	stream << printLine(0+8, 34+8);
	stream << "Blue    |" << blueRow;
	stream << printLine(0+8, 31+8);
	return stream;
} 

bool QwintoScoreSheet::validate(RollofDice rollofdice, Colour colour, const int position) const
{
	bool validate = true;
	auto yellowNum = 0;
	auto blueNum = 0;
	auto redNum = 0;

	switch (colour) {
	case(Colour::RED):
		validate = redRow.validate(rollofdice, position);
		if (!validate) return false;
		redNum = static_cast<int>(rollofdice);
		if (position <= 9)
			// check to see if the yellow number matches the red number
			yellowNum = yellowRow[position + 1];
			if (redNum == yellowNum) return false;
		if (position <= 8)
			// check to see if the blue number matches the red number
			blueNum = blueRow[position + 2];
			if (redNum == blueNum) return false;

	case(Colour::YELLOW):
		validate = yellowRow.validate(rollofdice, position);
		yellowNum = static_cast<int>(rollofdice);
		
		if (position >= 1 && position <= 9)
			// check to see if the blue number matches the yellow number
			blueNum = blueRow[position + 1];
			if (yellowNum == blueNum) return false;

		if (position >= 2 && position <= 10)
			// check to see if the red number matches the yellow number
			redNum = redRow[position - 1];
			if (yellowNum == redNum) return false;


	case(Colour::BLUE):
		validate = blueRow.validate(rollofdice, position);

		if (!validate) return false;
		blueNum = static_cast<int>(rollofdice);
		if (position >= 2)
			// check to see if the yellow number matches the blue number
			yellowNum = yellowRow[position-1];
			if (blueNum == yellowNum) return false;

		if (position >= 3)
			// check to see if the red number matches the blue number
			redNum = redRow[position -2];
			if (blueNum == redNum) return false;
	}
	return validate;
}

bool QwintoScoreSheet::operator!()
{
	if (failedAttempts == 4)
		return true;
	// Other conditions for Qwinto 

	return false;
}
