//this is updated
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CSVGameData extends GameData{
    int counter = 0;

    //private List<Knight> knights;


    public CSVGameData(String gamedata, String saveData) {
       // this.knights = new ArrayList<>();
        loadSaveData(saveData);
        loadGameData(gamedata);
    }

    private MOB parseMOB(Scanner line) {
        line.useDelimiter(",");

        return new MOB(
            line.next().trim(),
            line.nextInt(),
            line.nextInt(),
            line.nextInt(),
            DiceType.valueOf(line.next().trim())
        );
    }

    private Fortune parseFortune(Scanner line) {
       line.useDelimiter(",");
       String name = line.next().trim();
       int bonus = line.nextInt();
       int armor = line.nextInt();
       int hitModifier = line.nextInt();
       String diceTypestr = line.next().trim();
       DiceType diceType = null;

       if (diceTypestr.equals("-")) {
        return new Fortune(name,bonus, armor, hitModifier);
       }
       else {
        diceType = DiceType.valueOf(diceTypestr);
        return new Fortune(name, bonus, armor, hitModifier, diceType);
    }
}
      
    private Knight parseKnight(Scanner line) {
        line.useDelimiter(",");

        return new Knight(
            ++counter,
            line.next().trim(),
            line.nextInt(),
            line.nextInt(),
            line.nextInt(),
            DiceType.valueOf(line.next()),
            line.nextInt());
    }

    private void parseGameDataLine(Scanner line) {
        line.useDelimiter(",");
        String type = line.next().trim().toUpperCase();
    
        if (type.equals("MOB")) {
            monsters.add(parseMOB(line));
        } else if (type.equals("FORTUNE")) {
            fortunes.add(parseFortune(line));
        } else {
            System.err.println("Unable to parse line");
        }
    }
    
    
        void loadGameData(String gamedata) {
            Scanner file = readFile(gamedata);
            Scanner line;

            while (file.hasNext()) {
                line = new Scanner(file.nextLine());
                line.useDelimiter(",");
                parseGameDataLine(line);
             
            }
        }

        void loadSaveData(String saveData) {
            Scanner file = readFile(saveData);

            while (file.hasNext()) {
                knights.add(parseKnight(new Scanner(file.nextLine())));
            }
        }
      
        private Scanner readFile(String fileName) {
            FileInputStream fileInputStream;
            Scanner scanner;
    
            try {
                fileInputStream = new FileInputStream(fileName);
                scanner = new Scanner(fileInputStream);
                return scanner; 
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + fileName);
            } catch (Exception e) {
                System.err.println("Error opening file: " + e.getMessage());

            }
            return null; 
        }
    

    
        public void save(String filename) {
            try(PrintWriter printWriter = new PrintWriter(filename)){
                for (Knight knight: knights) {
                    printWriter.println(knight.toCSV());
                }
                System.out.println("Knights data saved to " + filename);
            }
            catch (IOException e) {
                System.err.println("Error saving knights data: " + e.getMessage());
            }

            }
            
        }
    
        
    
    
        

        

    
