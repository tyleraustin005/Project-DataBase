#pragma once
#ifndef Random_Dice
#define Random_Dice

struct RandomDice {

	//Use static method to ensure no object is necessary to make the call to the function
	static int getRandomFace();
};
#endif // !Random_Dice