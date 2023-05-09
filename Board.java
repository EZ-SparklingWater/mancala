/*

Basic Rules:
* Play always moves around the board in a counter-clockwise circle (to the right)
* The store on your right belongs to you. That is where you keep the seeds you win.
* The six pits near you are your pits.
* Only use one hand to pick up and put down seeds.
* Once you touch the seeds in a pit, you must move those seeds.
* Only put seeds in your own store, not your opponent’s store.
Starting the Game:
On a turn, a player picks up all the seeds in one pit and “sows” them to the right, placing one
seed in each of the pits along the way. If you come to your store, then add a seed to your store
and continue. You may end up putting seeds in your opponent’s pits along the way.
Play alternates back and forth, with opponents picking up the seeds in one of their pits and
distributing them one at a time into the pits on the right, beginning in the pit immediately to the
right.
Special Rules:
*When the last seed in your hand lands in your store, take another turn.
*When the last seed in your hand lands in one of your own pits, if that pit had been empty you
get to keep all of the seeds in your opponents pit on the opposite side. Put those captured seeds,
as well as the last seed that you just played on your side, into the store.
Ending the Game:
The game is over when one player’s pits are completely empty. The other player takes the seeds
remaining in her pits and puts those seeds in her store. Count up the seeds. Whoever has the most
seeds wins. 



This class uses a lot of things from the middle of the year, lots of arrays, booleans, for loops, and etc.
*/

import java.util.Scanner;

public class Board extends Player{

  //using a 2d array as a board, this is only setting up the framework though
  private int[] board = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};

  private char[] pits = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};

  //creating an expression to print the baord based on the array value
  private void printLine(int dots, boolean newLine){
    for (int i = 0; i < dots; i++){
      System.out.print('*');
    }
    if (newLine)
      System.out.println();
  }

  private void printDottedLine(int dots, boolean newLine){
    for (int i = 0; i < dots; i++){
      System.out.print("*    ");
    }
    if (newLine)
      System.out.println('*');
  }
  
  //player player player?  yes yes yes - top player's board stuff, super crazy ty Stack Overflow
  private void printTopPlayer(){
    for (int i = 13; i > 6; i--){
      System.out.printf("*  %c ", pits[i]);
    }
    printDottedLine(1, true);
    for (int i = 13; i > 6; i--){
      System.out.printf("* %2d ", board[i]);
    }
    printDottedLine(1, true);
  }

  //BOTTOM PLAYER'S BOARD
  private void printBottomPlayer(){
    printDottedLine(1, false);
    for (int i = 0; i <= 6; i++){
      System.out.printf("* %2d ", board[i]);
    }
    printLine(1, true);
    printDottedLine(1, false);
    for (int i = 0; i <= 6; i++){
      System.out.printf("*  %c ", pits[i]);
    }
    printLine(1, true);
  }


  //hoo ahhhhhhh
  public void printBoard(){

    //top section of game board
    printLine(41, true);
    printDottedLine(8, true);

    //enter the first player's mancala
    printTopPlayer();

    //middle section of board
    printDottedLine(8, true);
    printLine(41, true);
    printDottedLine(8, true);

    //enter the second player's mancala
    printBottomPlayer();

    //bottom section of the board
    printDottedLine(8, true);
    printLine(41, true);
    
  }


  int findIndex(char letter){
    //the base case - or that's what I'm calling it, it's setting it to a value that will tell us there's nothing there
    int retVal = -1;
    //index includes all inputs
    int index = -1;
    while (index < pits.length - 1){
      index++;
      if (letter == pits[index]){
        retVal = index;
        break;
      }
    }
    return retVal;
  }


//credits to chat gpt-4 premium (this is a joke btw - I forgot where I got help for this from
//this is the end game condition, if a side is empty then the game ends.
  public int checkSideEmpty(){
    int retVal = 0;
    int p1 = 0;
    int p2 = 0;

    //player 1
    for (int i = 0; i < 7; i++){
      if (board[i] != 0){
        p1 = 0;
        break;
      }
      else p1 = 1;
    }

    //player 2
    for (int i = 8; i < 12; i++){
      if (board[i] != 0){
        p2 = 0;
        break;
      }
      else p2 = 1;
    }
    retVal = p1 + p2;
    return retVal;
  }


  // credits to previous projects with Abheek Dawan & stack overflow
  // who goes next? yes yes yes
  public int playerMove(Player player){
    int retVal = 0;
    int index = -1;
    boolean loop = true;
    //temporarily not needed - boolean again = false;
    char letter = 'Z';
    printBoard();


    Scanner tryCatch = new Scanner(System.in);

    //I could not explain this to you if I tried, copied a template and replaced with my variables, maybe that's why I'm having an issue with my scanner input
    do {
      System.out.print("Hello " + player.getName() + ", choose a pit between " + pits[player.getStartingPit()] + " and " + pits[player.getEndingPit()] + ": ");
      loop = true;
      try{
        letter = tryCatch.nextLine().toUpperCase().charAt(0);
      }
      catch (StringIndexOutOfBoundsException e){
        System.out.println("Please enter a letter.");
        //apparently I need this letter in order for there to be an error when it's incorrect, char letter is defined above
        letter = 'Z';
      }

      index = findIndex(letter);
      
      if (index != -1 && index >= player.getStartingPit() && index <= player.getEndingPit() && board[index] > 0)
        loop = false;
      else {
        System.out.println("Select a pit on your side that contains stones.");
        if (checkSideEmpty() > 0){
          loop = false;
          System.out.println("At least one side is empty, the game is now over.");
          index = -1;
        }
      }
    }
    while (loop);
  


  //Moving the stones through the mancala board.  Used Chat GPT!!! jk no, but quite frankly this was so annoying that I tried using chat gpt until it kept telling me, "I don't understand what you are trying to ask"
  if (index == -1){
    retVal = 0;
  }
  else{
    int stones = board[index];
    //if all stones are gone...
    board[index] = 0;
    //else...
    while (stones > 0){
      index++;
      if ((player.getPlayerNumber() == 1 && index == 13) || (player.getPlayerNumber() == 2 && index == 6)){
        index++;
      }
      //boundaries of pits, 14 pits total so the boundaries are 0 to 14
      if (index == 14){
        index = 0;
      }
      board[index]++;
      stones--;
    }
    
    //checking to make sure the turns are correct, utilizing mancala pit cuz that's what's wrong :) jk just repeating the same variables
    if (player.getPlayerNumber() == 1 && player.getMancalaPit() == index){
      retVal = 1;
    }
    else if (player.getPlayerNumber() == 2 && player.getMancalaPit() == index){
      retVal = 2;
    }
    //its neither of the first two, so now it's time to switch
    else if (player.getPlayerNumber() == 1){
      retVal = 2;
    }
    else {
      retVal = -1;
    }
  }
  return retVal;
  }


/*
Irrelevant for the time being

  //The move sequence for the player's mancalas
  int makeMove(Player p){
    Random random = new Random();
    int retVal = 0;
    char chose;
    
    System.out.print(p.getName() + " choose from pits " + pits[p.getStartingPit()] + " and " + pits[p.getEndingPit()] + ": ");

    //credits to stack overflow post by Janet - making it so any letter format is valid
    chose = tryCatch.next().toUpperCase().charAt(0);

    retVal = random.nextInt(3);
    System.out.println("The random number being returned is: " + retVal);
    return retVal;
  }
  
*/

}
