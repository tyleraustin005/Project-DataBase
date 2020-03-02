#pragma once
#ifndef Qwinto_Player
#define Qwinto_Player 

#include "Player.h"
#include "QwintoScoreSheet.h"

class QwintoPlayer : public Player {
	QwintoScoreSheet scoreSheet;

public:
	//Implement the virtual functions from the parent
	void inputBeforeRoll(RollofDice& rollOfDice) override;
	void inputAfterRoll(RollofDice& rollOfDice) override;
};

#endif // !Qwinto_Player
