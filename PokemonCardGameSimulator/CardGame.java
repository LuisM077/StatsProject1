import java.util.ArrayList;
import java.util.Random;

public class CardGame
{
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizes;
    
    public CardGame() {
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
    }
    
    public void fillDeck() {
        for(int i = 0; i < 59; i++) {
            if(i < 15) { 
                deck.add(new Energy()); //adds 15 energy cards
            }
            else if(i < 18) {
                deck.add(new Charmander()); //adds 3 pokemon cards
            }
            else {
                deck.add(new Trainer()); //the rest of the cards added are trainer cards
            }
        }
    }
    
    public void drawHand() {
        Random rand = new Random();
        for(int i = 0; i < 7; i++) {
            int grabCardAtIndex = rand.nextInt(deck.size());
            hand.add(deck.get(grabCardAtIndex));
            deck.remove(grabCardAtIndex);
        }
    }
    
    public void drawPrizeCards() {
        Random rand = new Random();
        for(int i = 0; i < 6; i++) {
            int grabIndex = rand.nextInt(deck.size());
            prizes.add(deck.get(grabIndex));
            deck.remove(grabIndex);
        }
    }
    
    public void clearDeckAndHand() {
        
        while(deck.size() > 0) {
            deck.remove(0);
        }
        while(hand.size() > 0) {
            hand.remove(0);
        }
    }
    
    public void showDeck() {
        for(int i = 0; i < deck.size(); i++) {
            System.out.println(i + ": " + deck.get(i));
        }
    }
    
    public void showHand() {
        for(int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }
    }
    
    public void showPrizes() {
        for(int i = 0; i < prizes.size(); i++) {
            System.out.println(i + ": " + prizes.get(i));
        } 
    }
    
    
    public void run() {
        fillDeck();
        showDeck();
        
        drawHand();
        showHand();
        
        drawPrizeCards();
        showPrizes();
        
        showDeck();
        
        
    }
    
}
