#pragma once
#ifndef Colour_Class
#define Colour_Class

#include <iostream>

enum class Colour { //C++11 scoped enum
	RED,
	YELLOW,
	GREEN,
	BLUE,
	WHITE
};		// Must be accessed with 'Colour::______'
		//Enumerators of a scoped enum require a qualified name such as enumname::enumerator when you refer to them from an enclosing scope

// function to return the string equivalent of the enum
std::string getStringValue(Colour colour);

#endif // !Colour_Class
