import java.util.Scanner;

public class Main {
    // table to keep the two players
    private static Player[] players = new Player[2];

    // scanner to monitor users input
    private static Scanner userInput = new Scanner( System.in );

    // creation of the TicTacToe class so we can show the border and check for the winner
    private static TicTacToePanel ticTacToePanel = new TicTacToePanel();

    // table 3x3 with the free spots and users plays
    private static int[][] panelArray = new int[3][3];

    public static void main (String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("ΚΑΛΩΣ ΗΡΘΑΤΕ ΣΤΟ ΠΑΙΧΝΙΔΙ ΤΗΣ ΤΡΙΛΙΖΑΣ");
        System.out.println("--------------------------------------\n");

        // method to take the players names
        getPlayerNames();

        // boolean variable to monitor when Player 1 is playing
        boolean playerOneTurn = true;

        // boolean variable to monitor if there is a winner
        boolean win;

        // repetition of max 9 times (the max numbers of plays that can occur in TicTacToe
        for (int i = 0; i < 9; i++) {
            ticTacToePanel.showTheBorder(panelArray);

            // get player's coordinates where to put his symbol
            playerChoice(playerOneTurn);

            // only after 5 plays (i = 4) a win is possible
            if (i >= 4) {

                // check if there is a winner
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
                // else we have draw
                else {
                    if (i == 8) {
                        System.out.println("\nΙΣΟΠΑΛΙΑ");
                    }
                }
            }
            // change playerOneTurn variable so we can check who is playing
            playerOneTurn = !playerOneTurn;
        }
    }

    // private method to get players names
    private static void getPlayerNames() {
        String playerName;

        System.out.println("ΠΑΡΑΚΑΛΩ ΔΩΣΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΠΡΩΤΟΥ ΠΑΙΧΤΗ:");
        playerName = userInput.nextLine();
        // if user gives not a name, then he is assigned his player's name
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

    // method to get player's choice where to put his symbol
    private static void playerChoice(boolean playerOneTurn) {
        // create what player is playing and assign values to variables accordingly
        int player = 0;
        int symbolCode = -1;
        char symbol = 'X';
        if (!playerOneTurn) {
            player = 1;
            symbolCode = 1;
            symbol = 'O';
        }

        // variables for user choice
        int rowNumber, columnNumber;

        // repetition to get and validate the user's input
        do {
            System.out.println("\nO/H " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΓΡΑΜΜΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
            rowNumber = checkUserInput();
            while (rowNumber < 1 || rowNumber > 3) {
                System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ. ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3!");
                rowNumber = checkUserInput();
            }

            System.out.println("O " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΣΤΗΛΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
            columnNumber = checkUserInput();
            while (columnNumber < 1 || columnNumber > 3) {
                System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ. ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3");
                columnNumber = checkUserInput();
            }

            // check if user tried to use an already filled spot at the border
            if (panelArray[rowNumber - 1][columnNumber - 1] != 0) {
                System.out.println("ΔΕΝ ΜΠΟΡΕΊΤΕ ΝΑ ΕΙΣΆΓΕΤΕ ΣΕ ΗΔΗ ΣΥΜΠΛΗΡΩΜΕΝΟ ΚΕΛΙ!");
            }

        } while(panelArray[rowNumber - 1][columnNumber - 1] != 0);

        // if everything is ok then put user's symbol at the border array
        panelArray[rowNumber - 1][columnNumber -1] = symbolCode;
    }

    // method to check that user input is an int
    private static int checkUserInput() {
        while (!userInput.hasNextInt()) {
            System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ. ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3!");
            userInput.next();
        }
        return userInput.nextInt();
    }
}
