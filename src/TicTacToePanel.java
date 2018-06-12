public class TicTacToePanel {
    // empty constructor
    public TicTacToePanel () {}

    // method to show the border and calculate the remaining slots
    public int showTheBorder (int[][] panel) {

        int remainingSlots = 9;
        char[] rowSymbol = new char[3];

        System.out.println("\t 1\t 2\t 3\n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (panel[i][j] == -1) {
                    rowSymbol[j] = 'X';
                    remainingSlots--;
                }
                else if ( panel[i][j] == 1) {
                    rowSymbol[j] = 'O';
                    remainingSlots--;
                }
                else {
                    rowSymbol[j] = ' ';
                }
            }
            System.out.println((i+1) + "\t " + rowSymbol[0] + " | " + rowSymbol[1] + " | " + rowSymbol[2]);
            if (i < 2)
                System.out.println("\t---+---+---");
        }
        return remainingSlots;
    }

    public boolean isThereAWinner(int [][] panelArray) {
        // 8 ways to win.

        // first row same symbols
        if (panelArray[0][0] == panelArray[0][1] && panelArray[0][1] == panelArray[0][2] && panelArray[0][0] != 0)
            return true;

        // second row same symbols
        if (panelArray[1][0] == panelArray[1][1] && panelArray[1][1] == panelArray[1][2] && panelArray[1][0] != 0)
            return true;

        // third row same symbols
        if (panelArray[2][0] == panelArray[2][1] && panelArray[2][1] == panelArray[2][2] && panelArray[2][0] != 0)
            return true;

        // first column same symbols
        if (panelArray[0][0] == panelArray[1][0] && panelArray[1][0] == panelArray[2][0] && panelArray[0][0] != 0)
            return true;

        // second column same symbols
        if (panelArray[0][1] == panelArray[1][1] && panelArray[1][1] == panelArray[2][1] && panelArray[0][1] != 0)
            return true;

        // third column same symbols
        if (panelArray[0][2] == panelArray[1][2] && panelArray[1][2] == panelArray[2][2] && panelArray[0][2] != 0)
            return true;

        // 1st diagonal
        if (panelArray[0][0] == panelArray[1][1] && panelArray[1][1] == panelArray[2][2] && panelArray[0][0] != 0)
            return true;

        // 2nd diagonal
        if (panelArray[0][2] == panelArray[1][1] && panelArray[1][1] == panelArray[2][0] && panelArray[0][2] != 0)
            return true;

        return false;
    }
}
