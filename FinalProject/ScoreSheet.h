#pragma once
#ifndef ScoreSheet_Class
#define ScoreSheet_Class
#include <iostream>

#include "RollofDice.h"
#include "Colour.h"

class ScoreSheet {
	protected:
	virtual std::ostream& printSheet(std::ostream& stream) const = 0;
	virtual bool validate(RollofDice rollofdice, Colour colour, int position) const = 0;
	virtual int calcTotal() = 0;
	int currentScore = 0;

protected:
	const std::string playerName = "n/a";
	int failedAttempts = 0;

public:
	ScoreSheet(const std::string& name) : playerName(name) {};
	//to call the protected pure virtual function validate internally 
	bool score(RollofDice rollofdice, Colour colour, int position = -1);

	//calls pure virtual function calcTotal - sets and returns the points for the final score
	int setTotal();

	// return true if the scoresheet indicates that the game has ended
	virtual bool operator!();

	//overload the insertion operator for the class scoresheet printing
	friend std::ostream& operator<<(std::ostream& stream, const ScoreSheet& sheet);
};


#endif // !ScoreSheet_Class
