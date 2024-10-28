
public class Pokemon extends Card
{
    private int hp;
    
    public void Pokemon(int userInputHp) {
        hp = userInputHp;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int userInputHp) {
        hp = userInputHp;
    }
}
