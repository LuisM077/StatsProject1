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
        prizes = new ArrayList<Card>();
    }
    
    public void fillDeck(int amountOfPokemon) {
        for(int i = 0; i < (60-amountOfPokemon); i++) {
            deck.add(new Energy());
        }
        while(deck.size() < 60) {
            deck.add(new Charmander());
        }
    }
    
    public void fillDeckWithRareCandy(int amountOfPokemon, int amountOfRareCandies) {
        for(int i = 0; i < (60-amountOfPokemon - amountOfRareCandies); i++) {
            deck.add(new Energy());
        }
        if(deck.size() < 60 && amountOfPokemon > 0) {
            for(int i = 0; i < amountOfPokemon; i++) {
                deck.add(new Charmander());
            }
        }
        while(deck.size() < 60) {
            deck.add(new RareCandy());
        }
    }
    
    public void drawHand() {
        Random rng = new Random();
        
        for(int i = 0; i < 7; i++) {
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }
    
    public void drawPrizes() {
        Random rng = new Random();
        
        for(int i = 0 ; i < 6; i++) {
            int cardToSetAsideIndex = rng.nextInt(deck.size());
            prizes.add(deck.get(cardToSetAsideIndex));
            deck.remove(cardToSetAsideIndex);
        }
    }
    
    public boolean checkPokemonInHand() {
        for(Card singleCard : hand) {
            if(singleCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkRareCandyInHand() {
        for(Card singleCard : hand) {
            if(singleCard instanceof Trainer) {
                return true;
            }
        }
        return false;
    }
    
    public int checkRareCandiesInPrizes() {
        int rareCandyCount = 0;
        for(Card singleCard : prizes) {
            if(singleCard instanceof Trainer) {
                rareCandyCount ++;
            }
        }
        return rareCandyCount;
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
    
    public void emptyDeckAndHand() {
        while(deck.size() > 0) {
            deck.remove(0);
        }
        
        while(hand.size() > 0) {
            hand.remove(0);
        }
    }
    
    public void emptyAll() {
        
        while(deck.size() > 0) {
            deck.remove(0);
        }
        
        while(hand.size() > 0) {
            hand.remove(0);
        }
        while(prizes.size()>0) {
            prizes.remove(0);
        }
    }
    
    public double checkProbability(int userInputRuns, int amountOfPokemon) {
        double count = 0;
        
        for(int i = 0; i < userInputRuns; i++) {
            fillDeck(amountOfPokemon);
            //showDeck();
            drawHand();
            //showHand();
            //System.out.println(checkPokemonInHand());
            
            if(checkPokemonInHand() == true) {
                count++;
            }
            emptyDeckAndHand();
            //System.out.println("");
        }
        
        return count / userInputRuns;
    }
    
    
    public double isDeckBricked(int userInputRuns, int amountOfPokemon, int amountOfRareCandies) {
        double count = 0;
        for(int i = 0; i < userInputRuns; i++) {
            fillDeckWithRareCandy(amountOfPokemon, amountOfRareCandies);
            
            drawHand();
            
            if(checkRareCandyInHand() == false) {
                count++;
            }
            
            emptyDeckAndHand();
        }
        return count / userInputRuns;
    }
    
    public double oddsOfRareCandiesPrized(int userInputRuns, int rareCandiesPrized) {
        double count = 0;
        int pokemonInDeck = 10;
        int rareCandiesInDeck = 4;
        for(int i = 0; i < userInputRuns; i++) {
            fillDeckWithRareCandy(pokemonInDeck, rareCandiesInDeck);
            
            drawHand();
            
            drawPrizes();
            
            if(checkRareCandiesInPrizes() == rareCandiesPrized ) {
                count++;
            }
            emptyAll();
        }
        
        return count/userInputRuns;
        
    }
    
    public void run() {
        
        //Probability there is at least one pokemon in hand
        for(int i = 1; i <= 30; i++) {
            System.out.println("Probability of getting playable hand with " + i + " Pokemon in deck: " + checkProbability(10000,i));
        }
        
        System.out.println("");
        
        //Probability hand does not start with at least one Rare Candy
        for(int i = 1; i <= 4; i++) {
            System.out.println("Probability of not drawing " + i + " rare candies in hand: " + isDeckBricked(10000,10,i));
        }
         
        System.out.println("");
        
        //Odds of number of rare candies being prizes
        for(int i = 1; i <= 4; i++) {
            System.out.printf("Odds of prizing %d rare candies: %f",i,oddsOfRareCandiesPrized(10000,i));
            System.out.println("");
        }
        
    }
}
