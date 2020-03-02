#include "RollofDice.h"
#include "Dice.h"
#include "Colour.h"

RollofDice::RollofDice(std::vector<Dice>& diceVector)
{
	// Value of dice is reference from an item of diceVector
	// We can not change decVector's items by changing dice since it is const, but can assign that value
	for (auto const & dice : diceVector) {
		// Create a copy of the  reference variable and store it in the vector
		currentDice.push_back(dice);
	}
	i = currentDice.begin();
}

RollofDice::RollofDice(std::vector<Colour>& diceColours)
{
	// Value of colour is reference from an item of diceColours
	// We can not change diceColours's items by changing colour since it is const, but can assign that value
	for (auto const & colour : diceColours) {
		// Create a copy of the  reference variable and store it in the vector
		currentDice.push_back(Dice(colour));
	}
	i = currentDice.begin();
}

void RollofDice::roll() // needs to roll only the dice in that particular roll!!
{
	// Value of dice is reference from the items in currentDice
	for (auto &dice : currentDice) {
		// Roll and change the value of the dice faces, cause their roll function
		dice.roll();
	}
}

RollofDice RollofDice::pair(Colour firstDice, Colour secondDice)
{
	// return a Pair of dice based on the 2 colours inputted by the user

	/// ****** May want it to take current dice values for that colour

	return RollofDice(std::vector<Colour> { firstDice, secondDice });
}

std::ostream & operator<<(std::ostream& stream, const RollofDice& rollOfDice)
{
	stream << "After your roll the dice values were: " << std::endl;
	for (auto const & dice: rollOfDice.currentDice) {
		// Print the Value and Colour of each dice
		stream << dice;
	}
	return stream;
}

RollofDice::operator int()
{
	auto sum = 0;
	for (auto const & dice : currentDice) {
		sum += dice.faceValue;
	}
	return sum;
}
