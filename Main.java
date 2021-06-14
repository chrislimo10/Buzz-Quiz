import java.io.File;
import java.io.IOException;

/**
 *This class is being used to set up the game. The only changes from last version is that questions are scanned from a txt file and leaderboards for 5 best players are stored also in a txt file
 */
public class Main
{
    /**
     * In main method we set up the game up to the number of players and print the rules.
     * In this version of the game,only the single player mode has been made.
     * We also use a for loop to represent number of rounds calling a method that choses randomly the game type.
     * This is made by returning a number (1 for correct answer,2 for betting round) and then chosing the method that creates the game mode.
     */

    public  static void main(String[] args) throws IOException {
        Interaction decision;
        decision=new Interaction();
        int rounds=6;
        Rounds game=new Rounds();
        File f = new File("file.txt");
        if (f.exists())
        {
            int answer= decision.StartGame();
            if (answer==1) {
                Player player;
                String username = decision.Username();
                player = new Player(username);
                decision.Rules(1);


                for (int i = 1; i <= rounds; i++) {
                    answer = decision.chooseRound(i, player);


                    if (answer == 0) {

                        game.roundCorrectAnswer(player, i);

                    }
                    if (answer == 1) {

                        game.roundBetting(player, i);

                    }
                }
                decision.endGame(player);
                decision.Leaderboard(player);

            }

        }
        else
        {
            System.out.println("Questions' file missing. Quiz can't start!");
        }


    }
}