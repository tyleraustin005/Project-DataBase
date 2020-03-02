#pragma once
#ifndef Qwinto_Row
#define Qwinto_Row

#include "Colour.h"
#include <iostream>

template <Colour col>
class QwintoRow {
	//holds a fixed sized array, where numbers could be kept
	int row[10];
	// Number of places on the score sheet with Bonuses
	
	// Places where the bonus spots are 
	int numberBonusColumns;
	int *bonusPositions;
	int *pointerRow;

	const Colour colour;

	void setUpEmptyRow();
	std::string printRowContents() const;

public:
	QwintoRow<col>() : colour(col) { setUpEmptyRow(); };
	~QwintoRow() {
		delete[] bonusPositions;
	}

	int& operator[](const int index) const {
		// assuming the user will input 1-10 as options.. Could change this
		return row[index-1];
	};
	//function to perform error checking, return true if an addition is valid
	bool validate(const int rollValue, const int position) const;
	

	// *** No idea why this can't be in the .cpp file...... 
	int getRowScore() {
		int numberEntries = 0;
		for (int i = 0; i < 10; i++)
			if (row[i] >= 0)
				numberEntries += 1;
		//if the column is full return the last element in the array
		if (numberEntries == 10)
			return row[9];
		//otherwise return the number in that row
		return numberEntries;
	};
	
	//print the row
	friend std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::YELLOW>& row);
	friend std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::RED>& row);
	friend std::ostream& operator<<(std::ostream& stream, const QwintoRow<Colour::BLUE>& row);
	// Once again this should work but it doesn't
	//friend std::ostream& operator<<(std::ostream& stream, const QwintoRow<col>& row);
};

#endif // !Qwinto_Row
