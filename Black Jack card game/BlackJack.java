package blackjack;
import java.util.Scanner;

public class BlackJack {

    static Game game = new Game();
    
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        game.generate();
        game.Setinformation();
        
        gui.runGUI( game.deck ,
                game.players[0].getMyCards(),
                game.players[1].getMyCards(),
                game.players[2].getMyCards(),
                game.players[3].getMyCards() );
        
        playersturn(gui);
        game.updateMaxscore();
        dealerturn(gui);
        game.updateMaxscore();
        checkwinner();

    }
    
    public static void playersturn (GUI gui){
    
    Scanner scanner;
        scanner = new Scanner(System.in);
    String input = " ";
    
    for (int i = 0 ; i < 3 ; i++){
    System.out.println("Player no. " + (i+1) + " To Hit please Type 1 , To Stand please Type 2 : ");
    
    do {
    input = scanner.next();
    if (input.equals("1")){ 
        AddCardtoPlayer(i , gui);
        
        }
    }while (!input.equals("2"));
    
    
    }
    
    }
    
    public static void dealerturn (GUI gui){
        boolean dealerwins = true;
        if (game.gameHighscore >= 21) {
        dealerwins = false;
        }
        
        if (!dealerwins){
        AddCardtoDealer(gui , game.gameHighscore);}
        else {}
    }
   
    public static void AddCardtoPlayer(int playernum , GUI gui){
        Card card = game.draw();
        game.players[playernum].addcard(card);
        gui.updatePlayerHand(card, playernum);
        
    }
    
    public static void AddCardtoDealer(GUI gui , int Hs){
    while (game.players[3].score < Hs){
        Card card = game.draw();
        game.players[3].addcard(card);
        gui.updateDealerHand(card, game.deck);
    }}
    
    public static void checkwinner (){
        int hs = 0 ;
        int winner = -1;
        
        for (int i = 0 ; i < 4 ; i++){
        if (game.highscores[i] > hs && game.highscores[i] <= 21){
        hs = game.highscores[i];
        winner = i;}}
        
        if (winner >= 0){
        System.out.println("The winner is player " + game.players[winner].name + " no." + (winner+1));}
        
        if (winner == -1){
        System.out.println("NO ONE WINS");}
    }
    
}
