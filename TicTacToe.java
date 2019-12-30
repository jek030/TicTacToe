import java.util.ArrayList;
import java.util.Scanner;



public class TicTacToe {
    private String[][] board;
    private final String x;
    private final String o;
    private boolean is_X_Turn;

    //init
    public TicTacToe() {
        board =  new String[3][3];
        x = "X";
        o = "O"; //O not 0, o not zero
        is_X_Turn = true;
    }
    

    public static void main(String[] args) {
        //main function for gameplay
        TicTacToe game = new TicTacToe();
        game.showInstructions();
        game.initializeBoard();
        game.printBoard();
        //TODO: add loop for y/n play again?
        game.play();
    }

    /**
     * Shows the simple game instructions.
     */
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
     * Change the current player's turn.
     */
    private void changeTurn() {
        if (is_X_Turn) {
            is_X_Turn = false;
        } else {
            is_X_Turn = true;
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
    
    /**
     * Checks if the board contains a winner.
     */
    private boolean isWinner() {
        if(checkHorizontal())
            return true;
        else if (checkVertical())
            return true;
        else if (checkDiagonal())
            return true;
        else
            return false;
    }

    /**
     * Checks the diagonals for winners.
     */
    private boolean checkDiagonal() {
        if ((board[0][0] + board[1][1] + board[2][2]).equals("XXX") ||             
            (board[0][2] + board[1][1] + board[2][0]).equals("XXX")) 
        {
            System.out.println("GAME OVER!... X WINS!");
            return true;
        } else if ((board[0][0] + board[1][1] + board[2][2]).equals("OOO") ||             
                    (board[0][2] + board[1][1] + board[2][0]).equals("OOO")) 
        {
            System.out.println("GAME OVER!... O WINS!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the verticals for winners.
     */
    private boolean checkVertical() {
        if ((board[0][0] + board[1][0] + board[2][0]).equals("XXX") ||             
            (board[0][1] + board[1][1] + board[2][1]).equals("XXX") || 
            (board[0][2] + board[1][2] + board[2][2]).equals("XXX"))  
        {
            System.out.println("GAME OVER!... X WINS!");
            return true;
        } else if ((board[0][0] + board[1][0] + board[2][0]).equals("OOO") ||             
                    (board[0][1] + board[1][1] + board[2][1]).equals("OOO") || 
                    (board[0][2] + board[1][2] + board[2][2]).equals("OOO"))
        {
            System.out.println("GAME OVER!... O WINS!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the horizontals for winners.
     * @return true - if winner
     */
    private boolean checkHorizontal() {
        if ((board[0][0] + board[0][1] + board[0][2]).equals("XXX") ||             
            (board[1][0] + board[1][1] + board[1][2]).equals("XXX") || 
            (board[2][0] + board[2][1] + board[2][2]).equals("XXX"))  
        {
            System.out.println("GAME OVER!... X WINS!");
            return true;
        } else if ((board[0][0] + board[0][1] + board[0][2]).equals("OOO") ||
                    (board[1][0] + board[1][1] + board[1][2]).equals("OOO") ||
                    (board[2][0] + board[2][1] + board[2][2]).equals("OOO"))
        {
            System.out.println("GAME OVER!... O WINS!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print who's turn it is.
     */
    private void printTurn() {
        if(is_X_Turn) {
                System.out.println(x + "'s turn. Enter a valid number.");
            } else {
                System.out.println(o + "'s turn. Enter a valid number.");
            }
    }

    /**
     * Main gameplay method. Runs until the board contains a winner. Places either X or O in correct spot and checks for legal move.
     */
    private void play() {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //MAIN GAME LOOP
        int i =0;
        while((!isWinner()) && i < 9){
            try { //check for valid input number, if not throw exception
                    printTurn();
                    int in = scanner.nextInt();

                    if (in >= 1 && in <=9)
                    {
                        if (( board[(in-1)/3][(in-1)%3].equals(x) || board[(in-1)/3][(in-1)%3].equals(o))) 
                        { // spot is taken, print msg and do nothing, while loop runs again.
                            System.out.println("INVALID INPUT: enter a space that has not been taken."); //throw new space taken exception
                        } 
                        else 
                        { //spot is not taken, put move in board, change turn, print board.
                            
                            if(is_X_Turn)
                            {
                                board[(in-1)/3][(in-1)%3] = x;
                            } else 
                            {
                                board[(in-1)/3][(in-1)%3] = o;
                            }
                            changeTurn();
                        }
                    }//1-9 if
                    else 
                    {
                        throw new Exception(); //not 1-9 number exception
                    }
            } catch (Exception e){
                System.err.println("INVALID INPUT: enter a number 1-9."); //not an integer exception 
            }  
            printBoard();  
             
            i++;    
            if(i ==9) {
                System.out.println("Its a tie!");
            }         
        }   
    }
}