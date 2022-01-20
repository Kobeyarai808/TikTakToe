import java.util.Scanner;

public class Game {
    private String[] board = new String[9];

    public static void main(String[] args) {
        Game tikTakToe = new Game();
        System.out.println("How many human players? (1 or 2)");
        Scanner input = new Scanner(System.in);
        int amtHuman = input.nextInt();
        Player play1;
        Player play2;
        if(amtHuman==2){
            play1 = new HumanPlayer("O", tikTakToe);
            play2 = new HumanPlayer("X", tikTakToe);
        }
        else if(amtHuman==1){
            play1 = new HumanPlayer("O", tikTakToe);
            play2 = new ComputerPlayer("X", tikTakToe);
        }
        else{
            play1 = new ComputerPlayer("O", tikTakToe);
            play2 = new ComputerPlayer("X", tikTakToe);
        }
        while(true){
            play1.getMove();
            play2.getMove();
        }
    }

    public Game(){
        //Clear the board
        for(int i=0;i<board.length;i++) board[i] = Integer.toString(i+1);
        generateBoard();
    }

    public void generateBoard(){
        int count = 0;
        for(int i=0;i<3;i++){
            System.out.printf("| %S | %S | %S |\n",board[count],board[count+1],board[count+2]);
            count+=3;
        }
        System.out.println();
    }

    public boolean playMove(String name, int location){
        if (board[location].equals("X") || board[location].equals("O")) {
            System.out.println("ERROR, please try again!");
            return false;
        }
        else {
            board[location] = name;
            generateBoard();
            if(checkWin(name)){
                System.out.println("DING DING DING! '" + name + "' WINS!");
                System.exit(0);
            }
            return true;
        }
    }

    public boolean checkWin(String name){
        if(board[0].equals(name)&&board[1].equals(name)&&board[2].equals(name)){
            return true;
        }
        else if(board[3].equals(name)&&board[4].equals(name)&&board[5].equals(name)){
            return true;
        }
        else if(board[6].equals(name)&&board[7].equals(name)&&board[8].equals(name)){
            return true;
        }
        else if(board[0].equals(name)&&board[3].equals(name)&&board[6].equals(name)){
            return true;
        }
        else if(board[1].equals(name)&&board[4].equals(name)&&board[7].equals(name)){
            return true;
        }
        else if(board[2].equals(name)&&board[5].equals(name)&&board[8].equals(name)){
            return true;
        }
        else if(board[0].equals(name)&&board[4].equals(name)&&board[8].equals(name)){
            return true;
        }
        else if(board[2].equals(name)&&board[4].equals(name)&&board[6].equals(name)){
            return true;
        }
        else{
            return false;
        }
    }
}
