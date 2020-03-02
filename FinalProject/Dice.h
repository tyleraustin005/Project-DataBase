#pragma once
#ifndef Dice_Class
#define Dice_Class
#include <iostream>

#include "Colour.h"

struct Dice {
	const Colour colour;
	int faceValue = -1;
	Dice(Colour diceColour) : colour(diceColour) {};
	
	// call RandomDIce to get a new value for the dice faceValue
	int roll();
	// overload to print the Dice to an output stream
	friend std::ostream& operator<<(std::ostream& stream, const Dice & dice);
};

#endif // !Dice_Class

