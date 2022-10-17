package blackjack;


public class Player {
    
    public String name;
    int score;
    Card[] MyCards = new Card[11];
    int MyCardscounter;
    
    public void addcard(Card card){
    if (MyCardscounter < 11){
        MyCards[MyCardscounter] = card;
        MyCardscounter++;
        score += card.getValue();
    }
    }

    public Card[] getMyCards() {
        return this.MyCards;
    }
    
    
}
