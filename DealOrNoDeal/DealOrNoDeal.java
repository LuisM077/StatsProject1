import java.util.Random;

public class DealOrNoDeal
{
    private int runs;
    private int goodPrize;
    private int goat1;
    private int goat2;
    private double countSwaps = 0; //count # of wins when player swaps
    private double countNoSwaps = 0; //count # of wins when player does not swap
    
    public DealOrNoDeal() {
        runs = 10000;
    }
    public DealOrNoDeal(int userInputRuns) {
        runs = userInputRuns;
    }
    
    public void gameStarts() {
        int choice;
        int swapChoice;
        int i = 0;
        Random generator = new Random();
        
        goodPrize = 1;
        goat1 = 2;
        goat2 = 3;
        
        
        while(i < runs) {
            boolean doorChoice = false;
            while(doorChoice == false) {
                choice = 1 + generator.nextInt(3);
                //remove g1 or g2
                if(choice == goodPrize) {
                    //Swap?
                    swapChoice = generator.nextInt(2); //1=yes, 0=no
                    if(swapChoice == 1) {
                        //System.out.println("You swapped doors and lost.");
                        doorChoice = true;
                    }
                    else {
                        //System.out.println("You did not swap and won!");
                        countNoSwaps++;
                        doorChoice = true;
                    }
                }
                else {
                    //Swap?
                    swapChoice = generator.nextInt(2);
                    if(swapChoice == 1) {
                        //System.out.println("You swapped and won!");
                        countSwaps++;
                        doorChoice = true;
                    }
                    else {
                        //System.out.println("You did not swap and lost.");
                        doorChoice = true;
                    }
                }
            }
            i++;
        }
    }
    
    public double getCountSwaps() {
        return countSwaps/runs;
    }
    
    public double getCountNoSwaps() {
        return countNoSwaps/runs;
    }
    
    public void runShow() {
        gameStarts();
        System.out.println("Swaps: " + getCountSwaps());
        System.out.println("No Swaps:" + getCountNoSwaps());
    }
}
