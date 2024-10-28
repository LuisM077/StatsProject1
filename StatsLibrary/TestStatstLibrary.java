import java.util.ArrayList;
public class TestStatstLibrary
{
    public static void main(String[] args) { 
        
        StatsLibrary test = new StatsLibrary();
        
        ArrayList<Double> testNumbers = new ArrayList<Double>();
        testNumbers.add(1.0);
        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);
        //testNumbers.add(8.0);
        //testNumbers.add(9.0);
        //testNumbers.add(10.0);
        //testNumbers.add(11.0);
        testNumbers.add(7.0);
        
        double testerResults = test.findMean(testNumbers);
        
        System.out.println("This is the average of testNumbers: " + testerResults);
        
        double testMedium = test.findMedian(testNumbers);
        System.out.println("The medium is: " + testMedium);
        System.out.println();
        
//        double testMode = test.findMode(testNumbers);
//        System.out.println("The mode is: " + testMode);
//        System.out.println();
        
        double testSTD = test.findStandardDeviation(testNumbers);
        System.out.printf("The standard deviation is: %.4f\n",testSTD);
        System.out.println();
        
        StatsLibrary sl = new StatsLibrary();
        
        System.out.println("Permutations");
        sl.setN(30);
        sl.setR(3);
        System.out.println(sl.getN() + " P " + sl.getR() + " = " + sl.permutation(sl.getN(), sl.getR()));
        
        System.out.println("Combinations");
        sl.setN(5);
        sl.setR(1);
        System.out.println(sl.getN() + " C " + sl.getR() + " = " + sl.combination(sl.getN(), sl.getR()));
        System.out.println();
        
        System.out.println("Binomial Probability Distribution");
        sl.setN(10);
        sl.setY(9);
        sl.setP(.3);
        sl.setQ(.7);
        System.out.printf("Binomial distribution is: %.6f \n\n", sl.binomial(sl.getN(), sl.getY(), sl.getP(), sl.getQ()));
        
        System.out.println("Geometric Probability Distribution");
        sl.setY(6);
        sl.setQ(.96);
        sl.setP(.04);
        System.out.printf("Geometric distribution is: %.6f \n\n", sl.geometric(sl.getY(), sl.getQ(), sl.getP()));
        
        System.out.println("Hypergeometric Probability Distribution");
        sl.setN(10);
        sl.setR(5);
        sl.setY(5);
        sl.setBigN(20);
        System.out.printf("Hypergeometric distribution is: %.5f \n\n", sl.hypergeometric(sl.getBigN(), sl.getN(), sl.getR(), sl.getY()));
        
        System.out.println("Negative Binomial Probability Distribution");
        sl.setY(5);
        sl.setR(3);
        sl.setP(.2);
        sl.setQ(.8);
        System.out.printf("Negative Binomial Probability Distribution is: %.5f \n\n", sl.negativeBinomialP(sl.getY(), sl.getR(), sl.getP(), sl.getQ()));
        
        System.out.println("Poisson Probability Distribution");
        
    }
}
