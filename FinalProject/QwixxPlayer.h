#pragma once
#ifndef Qwixx_Player
#define Qwixx_Player

#include "Player.h"
#include "QwixxScoreSheet.h"

class QwixxPlayer : Player {
	QwixxScoreSheet scoreSheet;

	//Implement the virtual functions from the parent
	void inputBeforeRoll(RollofDice& rollOfDice) override;
	void inputAfterRoll(RollofDice& rollOfDice) override;
};
#endif // !Qwixx_Player
