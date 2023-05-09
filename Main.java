/*
Main uses random stuff, from all over, this is where I tried to mash in everything from the course that wasn't used in the other sections.  If you're reading this and the project doesn't have recursion, that's because I tried and I failed...
*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Board board = new Board();

    //mini player array
    Player[] players = new Player[2];

    int current;

    //player move scanner
    Scanner playerChoice = new Scanner(System.in);

    
    //printing entire board
    board.printBoard();

    System.out.print("Welcome to Java Mancala!! What is the name of the first player?");

    // first player enters
    players[0] = new Player(playerChoice.nextLine(), 1);

    System.out.print("Wonderful, who is the second player?");

    // second player enters
    players[1] = new Player(playerChoice.nextLine(), 2);

    System.out.println(
        "Welcome " + players[0].getName() + " and " + players[1].getName() + ". Please enjoy your game.");

    current = 0;


    //making sure the loop is returned corectly
    boolean loop = true;

    int playerIndex = 0;


    //making sure that the correct numbers are returned for players credit stack overflow
    do {
      System.out.println("It is now the time for " + players[current].getName() + " to make a move.");
      playerIndex = board.playerMove(players[playerIndex]);
      System.out.println(playerIndex);
      if (playerIndex == 0){
        loop = false;
      }
      else if (playerIndex == -1){
        playerIndex = 0;
      }
      else {
        playerIndex--;
      }
      current = playerIndex;
    }
    while (loop);

  }
}