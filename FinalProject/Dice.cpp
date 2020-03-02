#include "Dice.h"
#include "RandomDice.h"
#include "Colour.h"

// included to allow the string to be pushed into the stream
#include <string>

int Dice::roll()
{
	//Assign the value of the dice face to a new random number between 1,6 and return the faceValue interger
	return RandomDice::getRandomFace();
}

std::ostream & operator<<(std::ostream & stream, const Dice & dice)
{
	// Print out of the dice face value, including a call to the static function 
	// getStringValue to return the string value of the enum
	stream << "The " << getStringValue(dice.colour) << " Dice value is: " << dice.faceValue << std::endl;
	return stream;
}
