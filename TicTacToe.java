import java.util.ArrayList;



public class TicTacToe {

    private String[][] board = new String[3][3];
    private String x = "X";
    private String o = "O";
    

    public static void main(String[] args) {
        //main function for gameplay
        TicTacToe game = new TicTacToe();
        game.showInstructions();
        game.initializeBoard();
        game.printBoard();

        game.play();
    }

    private void showInstructions() {
        System.out.println("Welcome. Normal Tic-Tac-Toe rules. \nX will start first.\nChoose a cell labeled 1-9.\n");
    }

    /**
     * Create board with strings of digits for each slot.
     */
    private void initializeBoard() {
        Integer counter = 1;
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = counter.toString();
                counter++;
            }
        }
    }

    /**
     * Print the board.
     */
    private void printBoard() {
        System.out.println("PRINTING BOARD...");
            System.out.println("\t---------"); 
            System.out.println("\t" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]  );
            System.out.println("\t" + board[1][0] + " | " + board[1][1] + " | " + board[1][2]  );
            System.out.println("\t" + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
            System.out.println("\t---------"); 
            
    }

    private boolean isWinner() {
        //check if board contains a winner, return true, else false
        //aslo check if it is a tie
        return false;
    }
    
    private void play() {
        boolean is_X_Turn = true;

        //MAIN GAME LOOP
        while(!isWinner()){
            if(is_X_Turn) 
            {
                System.out.println(x + "'s turn.");
                is_X_Turn = false;
            } else 
            {
                System.out.println(o + "'s turn.");
                is_X_Turn = true;
            }
            // ask for user input -readline
            // see if spot available, reprompt or put it in
            
            
        }
    }


}