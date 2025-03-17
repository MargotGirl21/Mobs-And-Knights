//this is updated
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView {

    private final Scanner scanner;

    public ConsoleView(){
        this.scanner = new Scanner(System.in);

    }

    public void splashScreen () {
        System.out.print("Loading your game! ");
    }

    public void endGame(){ 
        System.out.print("Thanks for playing, brave knight!");
    }

    public String displayMainMenu() {
        System.out.print("What would you like to do? ");
        return scanner.nextLine().trim();
    }

    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:\n" +
            "   ls or list all  - listing the knights\n" +
            "   list active  - list the active knights knights only\n" +
            "   show name or id - show the knight details card\n" +
            "   set active name or id - set knight as active (note: only 4 knights can be active)\n" + 
            "   remove active name or id - remove a knight from active status (heals knight)\n" +
            "   explore or adventure or quest - find random monsters to fight\n" +
            "   save filename - save the game to the file name (default: saveData.csv)\n" +
            "   exit or goodbye - to leave the game\n" +
            "\n" +
            "Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.\n" + 
            "When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?\n"
           );

    }

    public void listKnights(List<Knight> knights) {
        if (knights.isEmpty()) {
            System.out.println("No knights to list ");
        }
        else {
            knights.forEach(knight -> System.out.println(knight.getId() + ": " + knight.getName()));

            }
        }

    public void knightNotFound() {
        System.out.print("Knight not found! ");
    }

    public void showKnight(Knight knight) {
        System.out.println(knight.toString());

    }
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time. ");
    }

    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights){
        System.out.println("Our heroes come across the following monsters. Prepare for battle! ");
        if (monsters.size() < 5 && activeKnights.size() < 5) {
            System.out.print(String.format("%-27s%n", monsters));
            
        }

        }

    public void printBattleText(MOB dead) {
        System.out.print(dead + " was defeated!" );
    }

    public void printFortunes(List<Knight> activeKnights) {
        System.out.println("For this quest, our knights drew the following fortunes!");
        for (Knight knight: activeKnights) {
            Fortune fortune = knight.getActiveFortune();
            if (fortune != null) {
                System.out.println(knight.getName() + " drew");
                System.out.println(fortune.toString());
            }
        }
    }

    public boolean checkContinue() {
        System.out.println("Would you like to continue on your quest (y/n)?");
        String answer = scanner.nextLine();
        answer.equalsIgnoreCase(answer);

        if (answer == "y" | answer == "yes") {
            return true;
        }

        else { 
            return false;
        }

    }

    public void printDefeated() {
        
        System.out.print("All active knights have been defeated!");

        }



    public static void main(String[] args) {
        
        ConsoleView consoleView = new ConsoleView();
        consoleView.printHelp();
        // Call the method to be tested

        //List<Knight> activeKnights = new ArrayList<>();
        //activeKnights.add(null);

        consoleView.checkContinue();

}
}
