#include "ScoreSheet.h"


bool ScoreSheet::score(RollofDice rollofdice, Colour colour, int position)
{
	if (rollofdice <= 1)
		// invalide rollofdice was given - error
		return false;

	if (position <= 0)
		// invalid position on the board was given
		//the acceptable range is 1-10
		return false;

	// ** not implemented 
	validate(rollofdice, colour, position);
	return false;
}

int ScoreSheet::setTotal()
{
	return calcTotal();
}

bool ScoreSheet::operator!()
{
	if (failedAttempts == 4)
		return true;

	return false;
}

std::ostream & operator<<(std::ostream & stream, const ScoreSheet & sheet)
{
	//https://stackoverflow.com/questions/4571611/making-operator-virtual

	// call the virtual methods overwritten by the child classes to print to the ostreams
	sheet.printSheet(stream);
	return stream;
}
