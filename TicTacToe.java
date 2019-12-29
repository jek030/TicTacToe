import java.util.ArrayList;
import java.util.Scanner;



public class TicTacToe {
    private String[][] board;
    private String x;
    private String o;
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
    
    private boolean isWinner() {
        //check if board contains a winner, return true, else false
        //aslo check if it is a tie
        return false;
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


    private void play() {
        //MAIN GAME LOOP
        while(!isWinner()){
            printTurn();
            //GET USER INPUT
            Scanner scanner = new Scanner(System.in);
            //check for valid input number, if not throw exception
            try {
                int in = scanner.nextInt();
                if (in >= 1 && in <=9){
                    //maybe not the correct while loop, while (true) ... before all the in checking
                    //
                    while (( board[(in-1)/3][(in-1)%3].equals(x) || board[(in-1)/3][(in-1)%3].equals(o))) {
                        System.out.println("INVALID INPUT: enter a space that has not been taken.");
                        in = scanner.nextInt();

                    }

                    if(is_X_Turn){
                        board[(in-1)/3][(in-1)%3] = x;
                    } else {
                        board[(in-1)/3][(in-1)%3] = o;
                    }
                    


                    // if in is a valid spot, put it in
                        //check for winner
                        //move to next turn
                    //else reprompt
                    changeTurn();
                    printBoard();
                } else {
                    throw new Exception(); 
                }
            } catch (Exception e){
                System.err.println("Please enter a number 1-9.");
            }
            
            

            
            
        }
        
    }


}