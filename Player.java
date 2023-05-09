/*
Everything in this class is essentially what we learned at the very beginning, when we did the mock barbarian thing.
Constructors, mutators, & accessors.
*/

public class Player{

    //player name string
    private String name;
  
    //yo yo yo it's a player
    public Player(){
      
    }
  
    //player constructor
    public Player(String n){
      name = n;
    }
  
    //player mutator
    public void setName(String n){
      name = n;
    }
  
    //player accessor
    public String getName(){
      return name;
    }
  
    
  }
  
  
  