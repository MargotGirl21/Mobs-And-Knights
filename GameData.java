//this is updated
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData {
       private static final int MAX_ACTIVE = 4; 
       private static final Random random = new Random();
        protected final List <Fortune> fortunes;
        protected final List <MOB> monsters;
        protected final List<Knight> knights;
        protected final List<Knight> activeKnights;

    

    public GameData() {
        this.knights = new ArrayList<>(); 
        this.activeKnights = new ArrayList<>();
        this.fortunes = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    public List<Knight> getKnights() {
        return new ArrayList<> (knights);
    }

    public List<Knight> getActiveKnights() {
        return new ArrayList<> (activeKnights);
    }

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
        }

    protected Knight findKnight(String nameOrId, List <Knight> list){
            for (Knight knight: list) {
                if (String.valueOf(knight.getId()).equals(nameOrId) || knight.getName().toLowerCase().contains(nameOrId.toLowerCase())) {
                    return knight;
                }
            }
        return null;
    }

    public boolean setActive(Knight kt) {
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(kt);
            return true;
        }
        return false;
        }


    public void removeActive(Knight kt) {
        boolean removed = activeKnights.remove(kt);
        if (removed){
            kt.resetDamage();
        }

    }

    public Fortune getRandomFortune(){
        Random random = new Random();
        int index = random.nextInt(fortunes.size());
        return fortunes.get(index);

    }

    public List<MOB> getRandomMonsters() {
        List<MOB> randomMonsters = new ArrayList<>();
    
        int maxMonsters = Math.min(activeKnights.size(), monsters.size());
    
        List<MOB> copyMonsters = new ArrayList<>(monsters);
        
        for (int i = 0; i < maxMonsters; i++) {
            int randomIndex = random.nextInt(copyMonsters.size());
            randomMonsters.add(copyMonsters.remove(randomIndex));
        }
    
        return randomMonsters;
    }
    
    public List<MOB> getRandomMonsters(int number) {
        List<MOB> randomMonsters = new ArrayList<>();
        
        int maxMonsters = Math.min(number, monsters.size());
    
        List<MOB> copyMonsters = new ArrayList<>(monsters);
        
        for (int i = 0; i < maxMonsters; i++) {
            int randomIndex = random.nextInt(copyMonsters.size());
            randomMonsters.add(copyMonsters.remove(randomIndex));
        }
    
        return randomMonsters;
    }

    public abstract void save(String filename);

}
