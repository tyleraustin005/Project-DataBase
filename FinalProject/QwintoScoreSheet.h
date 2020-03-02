#pragma once
#ifndef Qwinto_ScoreSheet
#define Qwinto_ScoreSheet

#include "ScoreSheet.h"
#include "Colour.h"
#include "QwintoRow.h"

class QwintoScoreSheet : public ScoreSheet {
	const int totalCharLength = 37;

	QwintoRow<Colour::RED> redRow;
	QwintoRow<Colour::YELLOW> yellowRow;
	QwintoRow<Colour::BLUE> blueRow;

	// Print dividing lines betwen the QwintoRows for the scoresheet
	std::string printLine(const int& start, const int& end) const;
	// Get the extra values from the bonus columns if there is any
	int getBonusColumnValue(int redIndex, int yellowIndex, int blueIndex, Colour col);
	
public:
	QwintoScoreSheet(const std::string& name) : ScoreSheet(name) {};
	
protected:
	// Set the total score in the base class and return that score
	int calcTotal() override;

	// Print the Qwinto ScoreSheet
	std::ostream& printSheet(std::ostream& stream) const override;


	bool validate(RollofDice rollofdice, Colour colour, int position) const override;
	
	bool operator!() override; 
};

#endif // !Qwinto_ScoreSheet
