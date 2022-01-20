import java.lang.Math;
import java.util.Scanner;

/**
 * This is the Player Class, it is the superclass of the Computer Player
 * and the Human Player Classes.
 */
public class Player {
    String name;
    Game game;

    public Player(String name, Game game){
        this.name = name;
        this.game = game;
    }

    public void getMove() {}
}

/**
 * This is the Computer Player Class, it generates a random move.
 */
class ComputerPlayer extends Player{
    public ComputerPlayer(String name, Game game) {
        super(name, game);
    }

    @Override
    public void getMove(){
        int move;
        do{
            move = (int)(Math.random()*9);
        }
        while(!game.playMove(name, move));
    }
}

/**
 * This is the Super Computer Player Class, it generates a random move.
 */
class SuperComputerPlayer extends Player{
    public SuperComputerPlayer(String name, Game game) {
        super(name, game);
    }

    @Override
    public void getMove(){
        int move;
        do{
            move = (int)(Math.random()*9);
        }
        while(!game.playMove(name, move));
    }
}

/**
 * This is the Human Player Class, it accepts input from the Keyboard
 */
class HumanPlayer extends Player{
    public HumanPlayer(String name, Game game) {
        super(name, game);
    }

    @Override
    public void getMove(){
        Scanner input = new Scanner(System.in);
        while(!game.playMove(name, input.nextInt()-1)){}
    }
}