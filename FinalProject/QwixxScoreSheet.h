#pragma once
#ifndef Qwixx_ScoreSheet
#define Qwixx_ScoreSheet
#include <vector>
#include <list>
#include <map>

#include "ScoreSheet.h"
#include "QwixxRow.h"
#include "Colour.h"

class QwixxScoreSheet : public ScoreSheet {
	std::string printLine() const;
	std::map<int, int> scoringTable;
	void setScoringTable();

public:
	QwixxScoreSheet(const std::string& playerName) : ScoreSheet(playerName) {
		setScoringTable();
	};

	//Red & Yellow use vector
	QwixxRow<std::vector<int>, Colour::RED> redRow = QwixxRow<std::vector<int>, Colour::RED>(std::vector<int>(11));
	QwixxRow<std::vector<int>, Colour::YELLOW> yellowRow = QwixxRow<std::vector<int>, Colour::YELLOW>(std::vector<int>(11));
	//Blue & Yellow use list
	QwixxRow<std::list<int>, Colour::BLUE> blueRow = QwixxRow<std::list<int>, Colour::BLUE>(std::list<int>(11));
	QwixxRow<std::list<int>, Colour::GREEN> greenRow = QwixxRow<std::list<int>, Colour::GREEN>(std::list<int>(11));

protected:
	//Override all pure virtual functions of the parent
	std::ostream& printSheet(std::ostream& stream) const override;
	bool validate(RollofDice rollofdice, Colour colour, int position) const override;
	int calcTotal() override;

	//void operator!() override; 
};

#endif // !Qwixx_ScoreSheet
