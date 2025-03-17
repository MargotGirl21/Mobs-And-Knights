//this is updated
public class MOB implements Attributes {
    protected int armor;
    protected int damage; 
    protected DiceType damageDie;
    protected int hitModifier; 
    protected int maxHP;
    protected int hp;
    private final String name;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.maxHP = hp;
        this.hp = hp;
        this.name = name; 
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
        this.armor = armor;
        this.damageDie = damageDie;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public void resetDamage() {
        damage = 0;
    }

    public int getHP () {
        return maxHP - damage;
    }
public String toString() {
    return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";

}



public MOB copy () {
    return new MOB(name, maxHP, armor, hitModifier, damageDie);
}
    
    public static void main(String[] args) {
        MOB mob = new MOB("Orc Warrior", 30, 15, 3, DiceType.D8);

        // Print the string representation using toString()
        System.out.println(mob.toString());

        
    }
}
