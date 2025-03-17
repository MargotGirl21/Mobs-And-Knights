//this is updated
import java.util.ArrayList;

public enum DiceType {
    D4, D6, D8, D10, D12, D20;



    

    public static DiceType valueof(String name) {

        if (name == null) {
            throw new NullPointerException("Name is null");
        }

        switch(name) {
            case "D4": return DiceType.D4;
            case "D6": return DiceType.D6;
            case "D8": return DiceType.D8;
            case "D10": return DiceType.D10;
            case "D12": return DiceType.D12;
            case "D20": return DiceType.D20;
            default:
            throw new IllegalArgumentException("No enum constant DiceType." + name);
    }

}
}