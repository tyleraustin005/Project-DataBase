#include "QwixxScoreSheet.h"
#include <string>

std::string QwixxScoreSheet::printLine() const
{
	std::string line(36, '-');
	line += "\n";
	return line;
}


void QwixxScoreSheet::setScoringTable()
{
	///Set the Scoring values for the number of entries per row
	scoringTable[1] = 1; 
	scoringTable[2] = 3;
	scoringTable[3] = 6;
	scoringTable[4] = 10;
	scoringTable[5] = 15;
	scoringTable[6] = 21;
	scoringTable[7] =28;
	scoringTable[8] = 36;
	scoringTable[9] = 45;
	scoringTable[10] = 55;
	scoringTable[11] = 66;
	scoringTable[12] = 78;
}

std::ostream& QwixxScoreSheet::printSheet(std::ostream & stream) const
{
	stream << std::endl; // might not be needed but who knows
	stream << printLine();
	stream << "RED     |" << redRow;
	stream << printLine();
	stream << "YEllOW  |" << yellowRow;
	stream << printLine();
	stream << "GREEN   |" << greenRow;
	stream << printLine();
	stream << "BLUE    |" << blueRow;
	return stream;
}

bool QwixxScoreSheet::validate(RollofDice rollofdice, Colour colour, int position) const
{
	// do something to validate the function
	return false;
}

int QwixxScoreSheet::calcTotal()
{
	///Sum the score of it! ** Need to include the locks though, only does till 11 now without the lock
	currentScore += scoringTable[redRow.numberEntries];
	currentScore += scoringTable[yellowRow.numberEntries];
	currentScore += scoringTable[blueRow.numberEntries];
	currentScore += scoringTable[greenRow.numberEntries];
	return currentScore;
}
