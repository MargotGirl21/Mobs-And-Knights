//this is updated
public class GameController {
    private final GameData data;
    private final GameView view;
    private final CombatEngine engine;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    public void start(){
        view.splashScreen();

        boolean running = true;

        while (running) {
            String command = view.displayMainMenu();
            running = processCommand(command);

            if (!running) {
                view.endGame();
                break;
            }
        }
             

    }

    protected boolean processCommand(String command) {
        if (command.contains("exit") || command.contains("bye")) {
            return false;
        }
        else if (command.startsWith("ls") || command.startsWith("list all")) {
            view.listKnights(data.getKnights());
        }
        else if (command.startsWith("show")) {
            String toShow = command.substring(5);
            processShowKnight(toShow);
            }
            else if (command.startsWith("set active")) {
                String toSet = command.substring(11);
                processSetActive(toSet);
            }
            else if (command.startsWith("remove")) {
                String toRemove = command.substring(7);
                processRemoveActive(toRemove);
            }
            else if (command.startsWith("list active")) {
                view.listKnights(data.getActiveKnights());
            }
            else if (command.matches("explore") || command.matches("adventure") || command.matches("quest")) {
                engine.initialize();
                engine.clear();
            }
            else {
                view.printHelp();
            }
        return true;
        }

        private void processShowKnight(String nameOrId) {
            Knight knightToShow = data.getKnight(nameOrId);

            if (knightToShow != null) {
                view.showKnight(knightToShow);
            }

            else {
                view.knightNotFound();
            }
        }

        private void processSetActive(String active) {
            Knight knightToSet = data.getKnight(active);
        
            if (knightToSet != null) {
                boolean setActiveSuccess = data.setActive(knightToSet);
                
                if (!setActiveSuccess) {
                    view.setActiveFailed();
                }
            } else {
                view.knightNotFound();
            }
        }

        private void processRemoveActive(String remove) {
            Knight knightToRemove = data.getKnight(remove);

            if (knightToRemove != null) {
                data.removeActive(knightToRemove);
            }
            else {
                view.knightNotFound();
            }
        }

        }
    
    



