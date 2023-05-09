/*
This class uses a lot of things from the middle of the year, lots of arrays, booleans, for loops, and etc.
*/

public class Board{

  //using a 2d array as a board, this is only setting up the framework though
  private int[] board = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};

  private char[] labels = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};

  //creating an expression to print the baord based on the array value
  private void printSolidLine(int dots, boolean newLine){
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
  
  //player player player?  yes we do
  private void printTopPlayer(){
    for (int i = 13; i > 6; i--){
      System.out.printf("*  %c ", labels[i]);
    }
    printDottedLine(1, true);
    for (int i = 13; i > 6; i--){
      System.out.printf("* %2d ", board[i]);
    }
    printDottedLine(1, true);
  }

  private void printBottomPlayer(){
    printDottedLine(1, false);
    for (int i = 0; i <= 6; i++){
      System.out.printf("* %2d ", board[i]);
    }
    printSolidLine(1, true);
    printDottedLine(1, false);
    for (int i = 0; i <= 6; i++){
      System.out.printf("*  %c ", labels[i]);
    }
    printSolidLine(1, true);
  }


  //hoo ahhhhhhh
  public void printBoard(){

    //top section of game board
    printSolidLine(41, true);
    printDottedLine(8, true);

    //enter the first player's mancala
    printTopPlayer();

    //middle section of board
    printDottedLine(8, true);
    printSolidLine(41, true);
    printDottedLine(8, true);

    //enter the second player's mancala
    printBottomPlayer();

    //bottom section of the board
    printDottedLine(8, true);
    printSolidLine(41, true);
    
  }


  int findIndex(char letter){
    int retVal = -1;
    int index = -1;
    while (index < labels.length - 1){
      index++;
      if (letter == labels[index]){
        retVal = index;
        break;
      }
    }
    return retVal;
  }


//credits to chat gpt-4 premium (this is a joke btw - I forgot where I got help for this from
  public int checkSideEmpty(){
    int retVal = 0;
    int p1 = 0;
    int p2 = 0;

    for (int i = 0; i < 7; i++){
      if (board[i] != 0){
        p1 = 0;
        break;
      }
      else p1 = 1;
    }
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
  public int playerMove(Player player){
    int retVal = 0;
    int index = -1;
    boolean loop = true;
    boolean again = false;
    char letter = 'Z';
    printBoard();

    do {
      System.out.print("Hello " + player.getName() + ", choose a pit between "+ labels[player.getEndPit()] + ": ");
      loop = true;
      try{
        letter = input.nextLine().toUpperCase().charAt(0);
      }
      catch (StringIndexOutOfBoundsException e){
        System.out.println("Please enter a letter.");
        letter = 'Z';
      }
      index = findIndex(letter);
      if (index != -1 && index >= player.getStartPit() && index <= player.getEndPit() && board[index] > 0)
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
    board[index] = 0;
    while (stones > 0){
      index++;
      if ((player.getPlayerNumber() == 1 && index == 13) || (player.getPlayerNumber() == 2 && index == 6)){
        index++;
      }
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
    
    System.out.print(p.getName() + " choose from pits " + labels[p.getStart()] + " and " + labels[p.getEnd()] + ": ");

    //credits to stack overflow post by Janet - making it so any letter format is valid
    chose = input.next().toUpperCase().charAt(0);

    retVal = random.nextInt(3);
    System.out.println("The random number being returned is: " + retVal);
    return retVal;
  }
  
*/

}
