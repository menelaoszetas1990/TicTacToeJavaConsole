import java.util.Scanner;

public class Main {
    private static Player[] players = new Player[2];
    private static Scanner userInput = new Scanner( System.in );
    private static TicTacToePanel ticTacToePanel = new TicTacToePanel();
    private static int[][] panelArray = new int[3][3];

    public static void main (String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("ΚΑΛΩΣ ΗΡΘΑΤΕ ΣΤΟ ΠΑΙΧΝΙΔΙ ΤΗΣ ΤΡΙΛΙΖΑΣ");
        System.out.println("--------------------------------------\n");

        getPlayerNames();

        int remainingSlots = ticTacToePanel.showTheBorder(panelArray);
        boolean playerOneTurn = true;
        boolean win = false;

        for (int i = 0; i < 9; i++) {
            playerChoice(playerOneTurn);
            remainingSlots = ticTacToePanel.showTheBorder(panelArray);
            if (i >= 4) {
                win = ticTacToePanel.isThereAWinner(panelArray);
                if (win) {
                    if (playerOneTurn) {
                        System.out.println("\nΝΙΚΗΤΗΣ Ο ΠΑΙΧΤΗΣ: " + players[0]);
                    }
                    else {
                        System.out.println("\nΝΙΚΗΤΗΣ Ο ΠΑΙΧΤΗΣ: " + players[1]);
                    }
                    break;
                }
                else {
                    if (i == 8) {
                        System.out.println("\nΙΣΟΠΑΛΙΑ");
                    }
                }
            }
            playerOneTurn = !playerOneTurn;
        }
    }

    private static void getPlayerNames() {
        String playerName = "";

        System.out.println("ΠΑΡΑΚΑΛΩ ΔΩΣΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΠΡΩΤΟΥ ΠΑΙΧΤΗ:");
        playerName = userInput.nextLine();
        if (playerName.equals("")) {
            playerName = "Player 1";
        }
        players[0] = new Player(playerName);

        System.out.println("ΠΑΡΑΚΑΛΩ ΔΩΣΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΔΕΥΤΕΡΟΥ ΠΑΙΧΤΗ:");
        playerName = userInput.nextLine();
        if (playerName.equals("")) {
            playerName = "Player 2";
        }
        players[1] = new Player(playerName);
    }

    private static void playerChoice(boolean playerOneTurn) {
        int player = 0;
        int symbolCode = -1;
        char symbol = 'X';
        if (!playerOneTurn) {
            player = 1;
            symbolCode = 1;
            symbol = 'O';
        }

        int rowNumber, columnNumber;

        do {
            System.out.println("\nO " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΓΡΑΜΜΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
            rowNumber = checkUserInput();
            while (rowNumber < 1 || rowNumber > 3) {
                System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ. ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3");
                rowNumber = checkUserInput();
            }

            System.out.println("O " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΣΤΗΛΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
            columnNumber = checkUserInput();
            while (columnNumber < 1 || columnNumber > 3) {
                System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ. ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3");
                columnNumber = checkUserInput();
            }

            if (panelArray[rowNumber - 1][columnNumber - 1] != 0) {
                System.out.println("ΔΕΝ ΜΠΟΡΕΊΤΕ ΝΑ ΕΙΣΆΓΕΤΕ ΣΕ ΗΔΗ ΣΥΜΠΛΗΡΩΜΕΝΟ ΚΕΛΙ!");
            }

        } while(panelArray[rowNumber - 1][columnNumber - 1] != 0);

        panelArray[rowNumber - 1][columnNumber -1] = symbolCode;
    }

    private static int checkUserInput() {
        while (!userInput.hasNextInt()) {
            System.out.println("Παρακαλώ εισάγετε αριθμό από το 1 έως το 3!");
            userInput.next();
        }
        return userInput.nextInt();
    }

}
