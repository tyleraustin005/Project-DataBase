#include "QwintoRow.h"
#include "RollofDice.h"
#include <string>
#include <iostream>

template<Colour col>
bool QwintoRow<col>::validate(const int rollValue, const int position) const {
	
	// pointers to the current element in the array
	int *current = &row[position];

	// Position is blocked, or if the given positions already has that some value
	if ((*current == -1) || (*current > 0))
		return false;

	// Scan through the lower portion of the array, ensuring all numbers are lower
	for (int i = position-1; i > -1; --i) {
		// if not 0 or -1, it has been set, check to ensure it is a lower value
		if (row[i] > 0) {
			if (row[i] >= rollValue)
				// if the number is larger or equal to, return false
				return false;
		}
	}

	// Scan through the higher portion of the array, ensuring all numbers are not set
	for (int i = position; i < 10; ++i) {
		// if not 0, or -1, it has been set already, therefore accessing the current position is 
		// not allowed
		if (row[i] > 0)
			return false;
	}

	return true;
}

template<>
void QwintoRow<Colour::RED>::setUpEmptyRow()
{
	numberBonusColumns = { 2 };
	bonusPositions = new int[2] { 1, 5 };
	//Set blocked positions
	row[3] = -1;
}

template<>
void QwintoRow<Colour::YELLOW>::setUpEmptyRow()
{
	numberBonusColumns = { 1 };
	bonusPositions = new int[1]{ 7 };
	//Set blocked positions
	row[5] = -1;
}

template<>
void QwintoRow<Colour::BLUE>::setUpEmptyRow()
{
	numberBonusColumns = 2;
	bonusPositions = new int[2]{ 2, 9 };
	// Set the blocked positions
	row[4] = -1;
}

template<Colour col>
std::string QwintoRow<col>::printRowContents() const
{
	std::string thing = "";

	// only declared since the method is const, can't increment pointer in the class itself
	int * tempBonusPositions = bonusPositions;  

	for (int i = 0; i < 10; ++i) {
		// Print the numbers
		if (row[i] == -1)
			// if -1, it is an empty column that cannot be accessed
			thing += "XX";
		else if (row[i] >= 10)
			// 10 or more no space needed
			thing += std::to_string(row[i]);
		else if (row[i] == 0)
			thing += "  ";
		else if (row[i] < 10)
			// less than 10 add a space
			thing += " " + std::to_string(row[i]);
		else {
			thing += "There has been an error in the game";
			//throw error
		}

		// Put the needed brackets 
		if (i + 1 == *tempBonusPositions) {
			// if a bonus bracket is needed print it
			thing += "%";
		}
		else if (i == *tempBonusPositions) {
			// if a bonus bracket is needed print it
			thing +="%";
			//last point where bonus bracket it needed, increment the pointer if not that last element
			if (!(*tempBonusPositions == tempBonusPositions[numberBonusColumns-1]))
				++tempBonusPositions;
		}
		else
			//if not a bonus positions print a regular bracket
			thing += "|";
	}
	return thing;
}

/*template<Colour col> // this should work idk why it won't
std::ostream& operator<<(std::ostream& stream, const QwintoRow<col> & row) {

	stream << row.printRowContents();
	return stream;
}
*/
std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::RED> & row) {
	
	stream << row.printRowContents();
	return stream;
}

std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::YELLOW>& row) {
	stream << row.printRowContents();
	return stream;
}

std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::BLUE>& row) {
	
	stream << row.printRowContents();
	return stream;
}

// Method to do it with std::ostream&
/*
for (int i = 0; i < 9; ++i) {

	// Print the numbers
	if (row.row[i] == -1)
		// if -1, it is an empty column that cannot be accessed
		stream << "XX";
	else if (row.row[i] >= 10)
		// 10 or more no space needed
		stream << row.row[i];
	else if (row.row[i] == 0)
		stream << "  ";
	else if (row.row[i] < 10)
		// less than 10 add a space
		stream << " " << row.row[i];

	else
		stream << "There has been an error in the game";
	//throw error


	// Put the needed brackets 
	if (i + 1 == *row.bonusPositions)
		// if a bonus bracket is needed print it
		stream << "%";
	else if (i == *row.bonusPositions) {
		// if a bonus bracket is needed print it
		stream << "%";
		//last point where bonus bracket it needed, increment the pointer if not that last element
		if (!*row.bonusPositions == row.bonusPositions[row.numberBonusColumns])
			(*row.bonusPositions)++;
	}
	else
		//if not a bonus positions print a regular bracket
		stream << "|";



		//Initialize and set up the array for the Red row
		char coloumnSeq[] = { '|', '%', '%', '|', '|', '%', '%','|', '|', '|', '|'};

} */