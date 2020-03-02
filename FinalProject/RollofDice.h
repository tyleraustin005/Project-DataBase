#pragma once
#ifndef Roll_of_Dice
#define Roll_of_Dice
#include <iostream>
#include <vector>
#include <iterator>

#include "Dice.h"

//** ensure that a ranged for loop could be used in this class

struct RollofDice
{
	// Vector used to grow and shrink depending on the # of dice
	std::vector<Dice> currentDice;
	// Iterator for the current Dice in the roll
	std::vector<Dice>::iterator i;

	//2 potention constructors that could be used to implement this class
	RollofDice(std::vector<Colour>& diceColours);
	RollofDice(std::vector<Dice>& diceVector);

	// implement the ++ operators
	std::vector<Dice>::iterator& operator ++() { ++i; return i; }
	std::vector<Dice>::iterator& operator ++(int) { ++i; return i; }
	Dice operator* (std::vector<Dice>::iterator dice) { return *dice;  }

	void roll();
	RollofDice pair(Colour firstDie, Colour secondDie); //could be implemented with a vector as well

	// overload to print the Roll of Dice to an output stream
	friend std::ostream& operator<<(std::ostream& stream, const RollofDice& rollOfDice);

	// since exlicit is not used, implicit casting will be allowed for this struct 
	operator int();
};

#endif // !Roll_of_Dice

/*
// return an iterator to the beginning and end of the vector
std::vector<Dice>::iterator begin() { return i; }
std::vector<Dice>::iterator& end(std::vector<Dice>::iterator thing) { return --currentDice.end(); }


// compare to ensure the current element is not at the end of the vector
bool operator !=(std::vector<Dice>::iterator const & iter) {
if (iter == currentDice.end() )
// If iter is equal to the end of the iterator, reset i back to the beginning
// In case it must be used again later
i = currentDice.begin();
return iter != currentDice.end(); }  */
