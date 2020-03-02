#include "Colour.h"

std::string getStringValue(Colour colour)
{
	switch (colour) {
	case Colour::RED:
		return "Red";
	case Colour::YELLOW:
		return "Yellow";
	case Colour::BLUE:
		return "Blue";
	case Colour::GREEN:
		return "Green";
	case Colour::WHITE:
		return "White";
	}

	return "An error has occured with the colours.";
}
