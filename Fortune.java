//this is updated
public class Fortune implements Attributes {
    private final int armor;
    private final String name;
    private final int hpBonus;
    private final int hitModifier;
    private final DiceType dtype;


    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.armor = armor;
        this.name = name;
        this.hpBonus = hpBonus;
        this.hitModifier = hitModifier;
        this.dtype = type;

    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName(){
        return name;

    }

    public String toString() {
        String topLine = "+======================+\n";
        String nameLine = "|" + String.format("%-22s", getName()) + "|\n";
        String hpLine = "|HP Bonus:     " + String.format("%+8d", getMaxHP()) + "|\n";
        String acLine = "|AC Bonus:     " + String.format("%+8d", getArmor()) + "|\n";
        String hitLine = "|Hit Bonus:    " + String.format("%+8d", getHitModifier()) + "|\n";
        String damageLine = "|Damage Adj:   " + (getDamageDie() != null ? String.format("%8s", getDamageDie()) : "   -") + "|\n";
        String bottomLine = "+======================+\n";

        return topLine + nameLine + hpLine + acLine + hitLine + damageLine + bottomLine;
    }

    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune " + ftn.getMaxHP());
        System.out.println(ftn.toString());
    }
    
}
