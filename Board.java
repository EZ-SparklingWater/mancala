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
        System.out.println();
    }
    
    //player player player?  yes we do
    private void printTopPlayer(){
      for (int i = 13; i > 6; i--){
        System.out.printf("*  %c ", labels[i]);
      }
      printDottedLine(1, false);
      printSolidLine(1, true);
      for (int i = 13; i > 6; i--){
        System.out.printf("* %2d ", board[i]);
      }
      printDottedLine(1, false);
      printSolidLine(1, true);
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
      printDottedLine(8, false);
      printSolidLine(1, true);
  
      //enter the first player
      printTopPlayer();
  
      //middle section of board
      printDottedLine(8, false);
      printSolidLine(1, true);
      printSolidLine(41, true);
      printDottedLine(8, false);
      printSolidLine(1, true);
  
      //enter the second player
      printBottomPlayer();
  
      //bottom section of the board
      printDottedLine(8, false);
      printSolidLine(1, true);
      printSolidLine(41, true);
      
    }
  
    
  }
  