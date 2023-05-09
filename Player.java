/*
Everything in this class is essentially what we learned at the very beginning, when we did the mock barbarian thing.
Constructors, mutators, & accessors.
*/

public class Player{

  //player name string
  private String name;
  private int player;
  private int startingPit;
  private int endingPit;
  private int mancalaPit;
  private int playerNumber;

  //yo yo yo it's a player
  public Player(){
    name = "none";
    playerNumber = 0;
  }

  //player constructor - the pits are for identifying player starting points
  public Player(String n, int p){
    name = n;
    playerNumber = player;
    
    //
    if (player == 1){
      startingPit = 0;
      endingPit = 5;
      mancalaPit = 6;
    }
    else {
      startingPit = 7;
      endingPit = 12;
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

  public int getStartingPit(){
    return startingPit;
  }

  public int getEndingPit(){
    return endingPit;
  }

  public int getMancalaPit(){
    return mancalaPit;
  }

  public int getPlayerNumber(){
    return playerNumber;
  }

}

