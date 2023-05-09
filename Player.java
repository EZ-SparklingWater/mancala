/*
Everything in this class is essentially what we learned at the very beginning, when we did the mock barbarian thing.
Constructors, mutators, & accessors.
*/

public class Player{

  //player name string
  private String name;
  private int player;
  private int startPit;
  private int endPit;
  private int mancalaPit;
  private int playerNumber;

  //yo yo yo it's a player
  public Player(){
    name = "none";
    playerNumber = 0;
  }

  //player constructor
  public Player(String n, int p){
    name = n;
    playerNumber = player;
    
    if (player == 1){
      startPit = 0;
      endPit = 5;
      mancalaPit = 6;
    }
    else {
      startPit = 7;
      endPit = 12;
      mancalaPit = 13;
    }
  }

  //player mutator
  public void setName(String n){
    name = n;
  }

  //player accessor
  public String getName(){
    return name;
  }

  public int getStartPit(){
    return startPit;
  }

  public int getEndPit(){
    return endPit;
  }

  public int getMancalaPit(){
    return mancalaPit;
  }

  public int getPlayerNumber(){
    return playerNumber;
  }

}

