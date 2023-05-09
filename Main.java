/*
Main uses random stuff, from all over, this is where I tried to mash in everything from the course that wasn't used in the other sections.  If you're reading this and the project doesn't have recursion, that's because I tried and I failed...
*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Board board = new Board();

    Player[] players = new Player[2];

    int current;
    current = 1;

    Scanner input = new Scanner(System.in);

    board.printBoard();

    System.out.print("Welcome to Mancala. What is the name of the first player?");

    // first player enters
    players[0] = new Player(input.nextLine(), 1);

    System.out.print("Who is the second player?");

    // second player enters
    players[1] = new Player(input.nextLine(), 2);

    System.out.println(
        "Welcome " + players[0].getName() + " and " + players[current].getName() + ". Please enjoy your game.");

    current = 0;

    boolean loop = true;

    int playerIndex = 0;


    //making sure that the correct numbers are returned for players credit stack overflow
    do {
      System.out.println("It is now the time for " + players[current].getName() + " to make a move.");
      playerIndex = board.playerMove(players[playerIndex]);
      if (playerIndex == 0){
        loop = false;
      }
      else{
        playerIndex--;
      }
      current = playerIndex;
    }
    while (loop);

  }
}