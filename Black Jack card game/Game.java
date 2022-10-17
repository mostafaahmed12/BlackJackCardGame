package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Player[] players = new Player[4];
    Card[] deck = new Card[52];
    int[] highscores = new int[4];
    int gameHighscore = 0;
    
    
    public void generate (){
        
        int deckcount;
        deckcount = 0;
       for(int i=0 ; i<4 ; i++){
           for(int j=0 ; j<13 ; j++){
               if (j <= 9){
               Card card = new Card(i , j ,j+1);
               deck[deckcount] = card;
               deckcount++;
                       }
               
               if (j > 9){
               Card card = new Card(i , j ,10);
               deck[deckcount] = card;
               deckcount++;
               }
           }
       } 
    }
    
    public Card draw(){
        
        Random rand = new Random();
        Card card = null;
        
       do { int randomchoice = rand.nextInt(51);
               card = deck[randomchoice];
               deck[randomchoice]=null;
       } while (card == null);
       
        return card;
        
    }
    
    public void Setinformation(){
      Scanner scanner = new Scanner(System.in);
      for(int i = 0; i<3; i++){
      System.out.println("Type Player " + (i+1) + " name : ");
      players[i] = new Player();
      players[i].name = scanner.next();
      players[i].addcard(this.draw());
      players[i].addcard(this.draw());
        }
      players[3] = new Player();
      players[3].name = "DEALER";
      players[3].addcard(this.draw());
      players[3].addcard(this.draw());
    }
    
    public void updateMaxscore(){   
     
      
      for (int i = 0 ; i < 4 ; i++){
      highscores[i]= players[i].score;
      }
      
      int m;
      m = Math.max(Math.max(highscores[0],highscores[1] ), Math.max(highscores[2], highscores[3]));
      
      if (m <= 21){
      gameHighscore = m ;}
        
        
    }
    
}
