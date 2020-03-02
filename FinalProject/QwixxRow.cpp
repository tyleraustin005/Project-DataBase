#include "QwixxRow.h"
#include "Colour.h"
#include <vector>
#include <list>
#include <string>

void QwixxRow<std::vector<int>, Colour::RED>::initRow()
{
	addNumbers(true);
}

void QwixxRow<std::vector<int>, Colour::YELLOW>::initRow()
{
	addNumbers(true);
}

void QwixxRow<std::list<int>, Colour::BLUE>::initRow()
{
	addNumbers(false);
}

void QwixxRow<std::list<int>, Colour::GREEN>::initRow()
{
	addNumbers(false);
}

template<class T, Colour col>
void QwixxRow<T, col>::addNumbers(bool countUp)
{
	// Add the numbers needed to the rows
	int counter; 
	if (countUp) counter = 2;
	else counter = 12;

	for (auto & item : row) {
		item = counter;
		// increment or decrement depending wether the row counts up or down
		if (countUp) ++counter;
		else --counter;
	}
}

template<class T, Colour col>
std::string QwixxRow<T, col>::printRow(QwixxRow<T, col> qwixxRow) const
{
	std::string rowString = "";
	// Print the number portions of the row, counting upwards
	for (auto &item : qwixxRow.row) {
		if (item == -1)
			// if the row has been scratched off by the user, show that with XX
			rowString += "XX";
		else 
			// if the column has not been scratch print the number
			rowString += std::to_string(item);

		rowString += "|";
	}
	return rowString;
}

template<class T, Colour col>
std::string QwixxRow<T, col>::printLock(bool rowLock) const
{
	// Return the string indicating if the row is locked or not
	std::string lockString = "";
	if (rowLocked == false)
		lockString += " U";
	else
		lockString += "L";
	return lockString;
}

template<class T, Colour col>
bool QwixxRow<T, col>::getIfRowLocked() const
{
	return rowLocked;
}

template<class T, Colour col>
bool QwixxRow<T, col>::lockRow()
{
	rowLocked = true;
	return rowLocked
}

template<class T, Colour col>
void QwixxRow<T, col>::operator+=(RollofDice & rollOfDice)
{
	// set the roll to -1, so it is known that its been crossed off

	/// ***** Ensure error checking so that rollOfDice is between 2 and 12
	++numberEnteries;
	array[rollOfDice - 2] = -1;
}

// Should all be in one method like this I think
/* std::ostream & operator<<(std::ostream & stream, const QwixxRow<class T, Colour col>& qwixxRow)
{
	// TODO: insert return statement here
	stream << qwixxRow.printRow(qwixxRow);
	stream << qwixxRow.printLock(qwixxRow.getIfRowLocked());
	return stream;
} */

std::ostream & operator<<(std::ostream & stream, const QwixxRow<std::vector<int>, Colour::RED>& qwixxRow)
{
	stream << qwixxRow.printRow(qwixxRow);
	stream << qwixxRow.printLock(qwixxRow.getIfRowLocked()) << std::endl;
	return stream;
}

std::ostream & operator<<(std::ostream & stream, const QwixxRow<std::vector<int>, Colour::YELLOW>& qwixxRow)
{
	stream << qwixxRow.printRow(qwixxRow);
	stream << qwixxRow.printLock(qwixxRow.getIfRowLocked());
	stream << std::endl;
	return stream;
}

std::ostream & operator<<(std::ostream & stream, const QwixxRow<std::list<int>, Colour::GREEN>& qwixxRow)
{
	stream << qwixxRow.printRow(qwixxRow);
	stream << qwixxRow.printLock(qwixxRow.getIfRowLocked()) << std::endl;
	return stream;
}

std::ostream & operator<<(std::ostream & stream, const QwixxRow<std::list<int>, Colour::BLUE>& qwixxRow)
{
	stream << qwixxRow.printRow(qwixxRow);
	stream << qwixxRow.printLock(qwixxRow.getIfRowLocked()) << std::endl;
	return stream;
}


