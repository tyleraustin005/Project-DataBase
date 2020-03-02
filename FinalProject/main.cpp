#include "RandomDice.h"
#include "Dice.h"
#include "RollofDice.h"
#include "Colour.h"
#include "QwintoRow.h"
#include "ScoreSheet.h"
#include "QwintoScoreSheet.h"
#include "QwixxRow.h"
#include "QwixxScoreSheet.h"

#include <string>
#include <iostream>
#include <vector>

int main() {

	// Random testing methods.. 

	Dice randomdie = Dice(Colour::RED);
	Dice randomdie1 = Dice(Colour::BLUE);

	std::vector<Dice> diceVect;
	diceVect.push_back(randomdie);
	diceVect.push_back(randomdie1);

	auto rollOfDice = RollofDice(diceVect);

	//for (auto dice : rollOfDice)
	//	std::cout << ("Ay it printed");

	//for (auto iv = rollOfDice.begin(); iv != rollOfDice.end(); ++iv){

	//	std::cout << ("Ay it printed");
	//	std::cout << *iv << std::endl;
	//}

// Test the rows
	/*auto redRow = QwintoRow<Colour::RED>();
	auto yellowRow = QwintoRow <Colour::YELLOW>();
	auto blueRow = QwintoRow<Colour::BLUE>();

	std::cout << redRow << std::endl;
	std::cout << yellowRow << std::endl;
	std::cout << blueRow << std::endl;
	std::cout << std::endl;
	redRow[1] = 2;
	redRow[2] = 5; */

	//yellowRow[1] = 11;
	//blueRow[2] = 17;
	//std::cout << redRow << std::endl;
	//std::cout << yellowRow << std::endl;
	//std::cout << blueRow << std::endl;

	// ******* Need to test validate at some point soon ***** 

// Lets do scoresheet
	//const std::string myName = "Nathan";
	//ScoreSheet *sheet = new QwintoScoreSheet(myName);
	//std::cout << *sheet;
	//delete sheet;

// If you want to test out the full thing, make the rows in the QwintoScoreSheet public
	/*QwintoScoreSheet sheet1 = QwintoScoreSheet();
	std::cout << sheet1;
	sheet1.redRow[1] = 2;
	sheet1.redRow[2] = 3;
	sheet1.redRow[3] = 6;
	sheet1.redRow[5] = 9;
	sheet1.redRow[6] = 11;
	sheet1.redRow[7] = 12;
	sheet1.redRow[8] = 13;
	sheet1.redRow[9] = 15;
	sheet1.redRow[10] = 16;

	sheet1.yellowRow[1] = 1;
	sheet1.yellowRow[2] = 3;
	sheet1.yellowRow[3] = 4;
	sheet1.yellowRow[4] = 5;
	sheet1.yellowRow[7] = 12;
	sheet1.yellowRow[8] = 13;

	sheet1.blueRow[1] = 1;
	sheet1.blueRow[2] = 3;
	sheet1.blueRow[4] = 6;
	sheet1.blueRow[6] = 7;
	sheet1.blueRow[9] = 10;
	std::cout << sheet1;
	std::cout << "The total score was " <<sheet1.calcTotal() - 15; */ // Everything public test
	
	
	// Qwixx ScoreSheet Creation and Printing
	//std::cout << std::endl;
	//std::cout << "Print the Qwixx Sheet";
	//ScoreSheet *sheetQ = new QwixxScoreSheet(myName);
	//std::cout << * sheetQ;
	//delete sheet;

	return 0;
}