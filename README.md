# CIS2430 A2 - Mancala

This program simulates games of Mancala between two players.

## Description

This program provides a text-based interface for 2-player games of Mancala. The functionality is 
broken up across the following classes: Pit, Store, Player, Board, MancalaGame. The program is ran 
using the TextUI class. This program also defines 4 custom exceptions: GameNotOverException, 
InvalidMoveException, NoSuchPlayerException, PitNotFoundException.

## Getting Started

### Dependencies

There are no additional libraries required to run this program.

### Executing program

*1. Build the program
```
gradle build
```
*2. Run the program
```
java -cp build/classes/java/main ui.TextUI
```
*Expected Output
```
Enter Player 1 Name: 
```

## Limitations

All functionality is complete. Based on assignment requirements, no errors are possible.

## Author Information

Thushan Subaskody (1219251)
tsubasko@uoguelph.ca

##Development History

*0.8
    *Final last-minute changes
	*See commit "minor changes"
*0.7
    *Finished exception handling and all other assignment requirements
	*See commit "finished exceptions and rest of assignment"
*0.6
    *Finished main method and all functionality and testing of game
	*See commit "finished main, game works, now need to handle exceptions"
*0.5
    *Finished required methods and started main method
	*See commit "finished methods, started main"
*0.4
    *Worked on required methods
	*See commit "worked on even more methods"
*0.3
    *Worked on required methods
	*See commit "worked on more methods"
*0.2
    *Worked on required methods
	*See commit "worked on methods"
*0.1
    *Created method stubs for all required methods
	*See commit "stubbed all methods"

### Differences between AI Solution and My Solution

The AI solution was greatly oversimplified because it just used an array of 14 integers to represent the 
board and even more integer variables to represent the player information and state of the game. My
solution implement separate classes for the various aspects of the game and board, in which each class
had its own set of methods for completing all of its required tasks while adhering to the Single
Responsibility Principle.

## Acknowledgements

n/a
