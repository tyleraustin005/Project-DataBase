#pragma once
#ifndef PlayerClass
#define PlayerClass
#include <iostream>

#include "RollofDice.h"

class Player {
	bool activePlayer = false; 

public: 
	// virtual functions to be overwirtten in the child classes, they need to accept 'RollofDice' by reference
	// they will act differently depending on whether the player is active or not
	virtual void inputBeforeRoll(RollofDice& rollOfDice) = 0;
	virtual void inputAfterRoll(RollofDice& rollOfDice) = 0;
};
#endif // !PlayerClass
