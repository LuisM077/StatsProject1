import java.util.ArrayList;

public class StatsLibrary
{
    private double n;
    private double r;
    private double y;
    private double bigN;
    private double p;
    private double q;
    
    
    Factorial fact = new Factorial();
    //Default constructor
    public StatsLibrary(){
        
    }
    
    //Nonempty constructor
    public StatsLibrary(String input){
        
    }
    public StatsLibrary(Integer partyTime){
        
    }
    
    public double getN() {
        return n;
    }
    public double getR() {
        return r;
    }
    public double getY() {
        return y;
    }
    public double getBigN() {
        return bigN;
    }
    public double getP() {
        return p;
    }
    public double getQ() {
        return q;
    }
    
    public void setN(double inputN) {
        n = inputN;
    }
    public void setR(double inputR) {
        r = inputR;
    }
    public void setY(double inputY) {
        y = inputY;
    }
    public void setBigN(double inputBigN) {
        bigN = inputBigN;
    }
    public void setP(double inputP) {
        p = inputP;
    }
    public void setQ(double inputQ) {
        q = inputQ;
    }
    
    //Mean Method
    public double findMean(ArrayList<Double> userInputNumbers){
        double sum = 0;
        
        for(double singleElement : userInputNumbers) {
            sum = sum + singleElement;
        }
        
        //Storing a value for clarity
        double result = sum / userInputNumbers.size();
        
        return result;
    }
    
    //Median Method
    public double findMedian(ArrayList<Double> userInputNumbers) {
        int middleOdd;
        double middleEven;
        if(userInputNumbers.size() % 2 != 0) {
            middleOdd =  userInputNumbers.size()/2;
            return userInputNumbers.get(middleOdd);
        }
        else {
            middleEven = ((userInputNumbers.size()/2) + ((userInputNumbers.size()/2) +1)) / 2.0; 
            return middleEven;
        }
    }
    
    //Mode method
    public double findMode(ArrayList<Double> userInputNumbers) {
        double value = 0;
        int count;
        int maxCount = 0;
        for(int i = 0; i < userInputNumbers.size(); i++) {
            for(int j = 0; i < userInputNumbers.size(); j++) {
                
            }
        }
        return value;
    }
    
    //Standard Deviation method
    public double findStandardDeviation(ArrayList<Double> userInputNumbers) {
        double std = 0;
        double sum = 0;
        ArrayList<Double> newList = new ArrayList<Double>();
        double mean = findMean(userInputNumbers);
        
        for(int i =0; i < userInputNumbers.size(); i++) {
            double difference = Math.abs(userInputNumbers.get(i) - mean);
            newList.add(Math.pow(difference,2));
        }
        
        for(int i = 0; i < newList.size(); i++) {
            sum = sum + newList.get(i);
        }
        
        std = Math.sqrt(sum / (userInputNumbers.size() - 1));
        
        return std;
    }
    
    public double permutation(double n, double r) {
        double result = fact.factorial(n) / fact.factorial(n-r);
        return result;
    }
    
    public double combination(double n, double r) {
        double result = fact.factorial(n) / (fact.factorial(r) * fact.factorial(n-r));
        return result;
    }
    
    public double binomial(double n, double y, double p, double q) {
        double bDistribution;
        bDistribution = combination(n,y) * Math.pow(p,y) * Math.pow(q, n-y);
        return bDistribution;
    }
    
    public double geometric(double y, double q, double p) {
        double gDistribution;
        gDistribution = Math.pow(q,y-1) * p;
        
        return gDistribution;
    }
    public double hypergeometric(double bigN, double n, double r, double y){
        double hgDistribution;
        hgDistribution = (combination(r,y) * combination (bigN-r, n - y)) / combination(bigN,n);
        return hgDistribution;
    }
    
    public double negativeBinomialP(double y, double r, double p, double q) {
        double nbDistribution;

        nbDistribution = combination(y-1, r-1) * Math.pow(p,r) * Math.pow(q,y-r);
        return nbDistribution;
    }
}
