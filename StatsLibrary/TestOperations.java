import java.util.ArrayList;

public class TestOperations
{
    public static void main(String[] args) {
        SetOperations test = new SetOperations();
        ArrayList<String> week1 = new ArrayList<String>();
        ArrayList<String> week2 = new ArrayList<String>();
        
        week1.add("Monday");
        week1.add("Tuesday");
        week1.add("Wednesday");
        week1.add("Thursday");
        week1.add("Friday");
        
        week2.add("Saturday");
        week2.add("Sunday");
        week2.add("Monday");
        week2.add("Tuesday");
        
        System.out.println("Union: " + test.union(week1, week2));
        System.out.println("Intersection: " + test.intersection(week1, week2));
    }
}
