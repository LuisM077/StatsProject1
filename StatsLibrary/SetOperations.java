import java.util.ArrayList;
public class SetOperations
{
    String days;
    
    public SetOperations() {
        
    }
    
    public ArrayList<String> union(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> arraylist = new ArrayList<String>();

        for(int i = 0; i < a.size(); i++) {
            arraylist.add(a.get(i));
        }
        for(int i = 0; i < b.size(); i++) {
            arraylist.add(b.get(i));
        }
        return arraylist;
    }
    
    public ArrayList<String> intersection(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> arraylist = new ArrayList<String>();
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < b.size(); j++) {
                if(a.get(i) == b.get(j)) {
                    arraylist.add(a.get(i));
                }
            }
        }
        return arraylist;
    }
}
