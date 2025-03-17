//this is updated
import java.util.List;
//import java.util.Random;

public class CombatEngine {

    private final GameData data;
    private final GameView view;
    //private final DiceSet dice;
   // private final Random rnd;

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
    }

    public void initialize () {
        List<Knight> activeKnights = data.getActiveKnights();

        if (activeKnights.isEmpty()) {
            System.err.println("No active knights available.");
            return;
        }

        for (Knight knight: activeKnights) {
            Fortune randomFortune = data.getRandomFortune();

            if(randomFortune == null) {
                System.err.println("No random fortune available");
                continue;
        }
        knight.setActiveFortune(randomFortune);
    }
}
        
    

    //private int doBattle(List <MOB> attackers, List <MOB> defenders) {

    //}

    public void clear() {
        List<Knight> knights = data.getKnights();

        if (knights == null) {
            System.err.println("No knights available to clear.");
            return;
        }

        for(Knight knight: knights) {
            knight.setActiveFortune(null);
        }
    }
}
