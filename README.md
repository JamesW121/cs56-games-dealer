cs56-games-dealer
=================

project history
===============
```
 W14 | jcneally 4pm | acantor | Application to shuffle a deck of 52 playing cards and deal them to the use

 W16 | ttstarck kellybielaski 5pm | Added GUI and multiple hand functionality
 
 F16 | eric-xiao8 kpoon1 5 pm | Added main menu and Blackjack game
 
 F17 | JamesW121 KiwanSung 5pm | 
 
```

What is this?
=============

This is an interface with classes such as card, deck, and hand that can be used to make card games. 
Dealer itself is an application to shuffle a deck of 52 playing cards and deal them to the user using command lines. 


How To Run
==========

In the directory of where the build.xml is located 


    Type `ant run` - runs terminal
    Type 'ant runGUI' - runs GUI


 Other Ant Targets

 
    compile - compiles code
    linenumbers - creates file containing all source files with line numbers (doesn't work)
    clean - deletes javadoc, .jar, download, temp, and .class files
    javadoc - creates javadoc
    jar - creates a jar file
    download - old JWS target
    publish - old JWS target
    test - runs a JUnitTest
    
    
How does the application work?
==============================
Command Line:
The user is asked many hands the user wants to be dealt, then if the user wants the deck to be shuffled. The user is asked for a number to be dealt for each hand. The inputted numbers of cards are dealt to the player's hands and removed from the deck. The user is asked if they want to draw again until there are no more cards left in the deck. The user must input an integer from 0 to 52. Otherwise, the user will be dealt a default hand and the application will end. In the case of the deck being empty, the application will prompt the user to either reset with an empty hand and new deck or exit. The shuffle is done by using the shuffle function in the Collections class by using a RandomSecure seed.

GUI:
The user is prompted how many hands they want and if they don't want the deck to be shuffled, only shuffled once, or before each player draws. Then a panel is displayed that contains the textfields where the user can input how many cards they want for each hand. Then click the display cards button which replaces that panel with a new panel containing the textarea that displays the cards dealt for each hand and the remaining cards in the deck. The user can choose to continue drawing or reset the deck.

#### Running the Program ####
### If you run it by "ant runGUI" ###
![picture1](https://user-images.githubusercontent.com/25092924/32713886-1e02dfd0-c800-11e7-9c8f-c680334c1c7d.png)

You will be given two buttons, "Blackjack" and "Dealer". Each one will lead to corresponding game.

### Blackjack ###

-A player will be directed to play blackjack upon clicking on "Blackjack" button. Below is the next screen the user will see upon clicking the "Blackjack" button.

![picture2](https://user-images.githubusercontent.com/25092924/32713921-4c22919e-c800-11e7-8b0f-0fa4c2c6344b.png)


-Click on "Play" button to start playing blackjack.

![picture3](https://user-images.githubusercontent.com/25092924/32713940-5e3c05b8-c800-11e7-9a87-cc1cc4c7ec07.png)

-Initially the Player (user) and the Dealer will be each given two cards. Player will have all his/her cards faced up, Dealer's first card is faced down.

-Player will have to choose between the "Hit" button or the "Stand" button. Hit will draw another card to the Player; Stand will indicate that the Player does not wish to draw the card for this round.

![picture4](https://user-images.githubusercontent.com/25092924/32713955-734bba48-c800-11e7-91ad-76e28a5fedfa.png)

-Player will be able to select "Hit" button until the sum of cards reach 17 or above.

-Upon Stand, the Dealer will reveal the card faced down, and draw the additional random card(s) until the sum of its card reaches 17 or above.

-Player will win if the sum of his/her cards are greater than Dealer's (or if it busts), and equal or below to 21. (bust: Sum of the cards is greater than 21)

-The Dealer will win if the Player's card is bust, or the sum of its cards are less than that of Dealer's.

![picture5](https://user-images.githubusercontent.com/25092924/32713975-8a205db4-c800-11e7-9e07-37c3d153b6c1.png)

-Player will be given a result statement on the right of the screen and given a "Continue" button to play a new round. Player can always exit out of the system by clicking the "X" button of the GUI.

#### Dealer ####
-A player will be directed to play dealer upon clicking on "Dealer" button. Below is the next screen the user will see upon clicking the "Dealer" button.

![picture6](https://user-images.githubusercontent.com/25092924/32713992-9845c0f0-c800-11e7-947c-678cfa382b5b.png)

-The system will inqure how many hand(s) the user wants (between 1 and 10). Then the user is given a box to select shuffle frequencies. The user can choose between "don't shuffle", "shuffle once before dealing", and "shuffle after every set of cards is dealt". If "don't shuffle" is chosen, the deck will have the cards ordered from standard Diamond, Club, Heart, Spade in ascending order (2 -> 10 -> JQKA).

-The new line with box will be generated to inquire how many cards the User wants. The box will generate.

-Results of hands and cards will be printed, the system will inquire user to continue playing.


## If you run it by "ant run" ##
#### Blackjack ####
-You can run the program over the terminal (ant run). You can select to play Blackjack by inputting 2 on the first query. The system will then ask for the input of User's name to be featured throughout the rest of the game.

-The system will draw card for the dealer and the user and output accordingly (1st card of Dealer is hidden so denoted as "X of X").

-The system will query whether the User wants to hit or not (input either y for yes, and n for no).

-If yes, the system will draw the card, and the User will be given an option to hit or stand again. Should the sum of the cards exceed 21, the system will automatically announce user's loss without having to look at the Dealer's hand.

-If no, the system will move on to the Dealer's hands and Dealer will either hit or stand. Upon Dealer's stand, the system will compare the card sum of the Dealer and the User to determine the winner.

![picture7](https://user-images.githubusercontent.com/25092924/32714009-a83df4e6-c800-11e7-85b2-5a8c823b5211.png)

-After winner has been announced, the system will query whether to continue playing or not (y/n; y will immediately draw cards again, and n will exit the program).

#### Dealer ####
-You can run the program over the terminal (ant run). You can select to play Dealer by inputting 1 on the first query.

![picture8](https://user-images.githubusercontent.com/25092924/32714018-b86da424-c800-11e7-8626-5a877c895b26.png)

-The system will ask for input of number of hands to be used. (Any number between 1 and 10) The number n entered here will define n queries of cards wanted in each hand.

-The system will ask for whether for the cards to be shuffled. (Else standard sorted deck will be used)

-Each hand query, the deck will follow the shuffle frequencies that was determined in the beginning. 

-Upon the last hand, the system will ask whether if the user wishes to continue drawing hands. Upon yes, the system will start again with the leftover decks. Upon no, the system will print out rest of the cards remaining in the deck(s), print Goodbye.




F16 final remarks:
===================
The dealer interface has been updated to include card images and the game Blackjack has been created. Both console and GUI versions exist which can be run with 'ant run' and 'ant runGUI'. The code for the main menu is located in 'MainGui.java' and here additional games that are created can be added. One thing that can be improved for the Blackjack game is that when the player wins or loses, the continue button pushes the other GUI components to the left. This can be fixed so that they remain stationary instead. Also, the card class can be refactored. At the moment there are methods in the card class that are used specifically for Blackjack such as the rankValue method. These methods can be refactored into the Blackjack game so that Card remains generalized for other games.   

