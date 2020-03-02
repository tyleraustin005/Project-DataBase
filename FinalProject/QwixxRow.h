#pragma once
#ifndef Qwixx_Row
#define Qwixx_Row

#include "RollofDice.h"
#include <list>
#include <vector>

static bool rowLocked;

template <class T, Colour col>
class QwixxRow {

	//Type T list for the row to be held - either vector or list
	T row;

	
	void initRow();
	void addNumbers(bool countUp);

	// private utility methods to print the Rows
	std::string printRow(QwixxRow<T, col> qwixxRow) const;
	//std::string printLock(QwixxRow<T, col> qwixxRow) const;
	std::string printLock(bool rowLock) const;
	
	
public:
	int numberEntries;


	QwixxRow(T& inputRow) : row(inputRow) {	
		rowLocked = false;
		numberEntries = 0;
		initRow();
	};
	// may want this static at some point 
	bool getIfRowLocked() const;
	bool lockRow();
	

	//use the compound assignment to add a row of dice of size 2, to the row
	//the compund assingment should do error checking and throw error on improper execution
	void operator+=(RollofDice & rollOfDice);

	friend std::ostream& operator<<(std::ostream& stream, const QwixxRow<std::vector<int>, Colour::RED> & qwixxRow);
	friend std::ostream& operator<<(std::ostream& stream, const QwixxRow<std::vector<int>, Colour::YELLOW> & qwixxRow);
	friend std::ostream& operator<<(std::ostream& stream, const QwixxRow<std::list<int>, Colour::GREEN> & qwixxRow);
	friend std::ostream& operator<<(std::ostream& stream, const QwixxRow<std::list<int>, Colour::BLUE> & qwixxRow);

	// Should be templated like this, idk why it's not working
	//friend std::ostream& operator<<(std::ostream& stream, const QwixxRow<T, col> & qwixxRow);
};

#endif // !Qwixx_Row