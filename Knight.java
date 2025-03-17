//this is updated
public class Knight extends MOB {
    private Fortune activeFortune;
    protected int xp;
    protected final int id;

    public Knight (int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;
   

    }
@Override
    public int getArmor() {
        if (activeFortune != null && activeFortune.getArmor() != 0) {
            return super.getArmor() + activeFortune.getArmor();
        }
        return super.getArmor();

    }

    @Override

    public int getMaxHP () {
        if (activeFortune != null && activeFortune.getMaxHP() != 0) {
            return super.getMaxHP() + activeFortune.getMaxHP();
        }
        return super.getMaxHP();
    }

@Override
    public DiceType getDamageDie() {
        if (activeFortune != null && activeFortune.getDamageDie() != null){
            return activeFortune.getDamageDie();
        }
        return super.getDamageDie();
    }

    @Override

    public int getHitModifier() {
        if (activeFortune != null && activeFortune.getHitModifier() != 0) {
            return super.getHitModifier() + activeFortune.getHitModifier();
        }
        return super.getHitModifier();
    }

    public int getXP() {
        return xp;
    }

    public Fortune getActiveFortune (){ 
        return activeFortune;
    }

    public void setActiveFortune (Fortune activFortune) {
        this.activeFortune = activFortune;
    }

    public void addXP(int xp) {
        xp += xp;
    }
    
    public Integer getId() {
        return id;
    }

    //@Override
   // public String getName() {
     //   return super.getName();
    //}

    @Override

        public String toString() {
            return  "                             \n" +
            "+============================+\n" +
                    String.format("| %-27s|%n", super.getName()) +
                    String.format("| id: %-22d |%n", getId()) +
                    "|                            |\n" +
                    String.format("| Health: %-7d XP: %-7d|%n", getHP(), getXP()) +
                    String.format("|  Power: %-7s Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                    "|                            |\n" +
                    "+============================+";
        }


    public String toCSV() {
        String csvLine = super.getName() +","+ maxHP+ ","+ armor +","+ hitModifier +","+ damageDie +","+xp;

        return csvLine;

    }


    public static void main(String[] args) {

       Knight knight = new Knight(1, "Sir Galahad", 50, 20, 5, DiceType.D10, 100);
        //knight.setActiveFortune(new Fortune("Blessed Armor", 10, 0, 0)); // Example active fortune
       System.out.println(knight.toString());
        //System.out.println("CSV Data: " + knight.toCSV());
        
    }
    
}
