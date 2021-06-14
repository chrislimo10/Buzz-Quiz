/**
 *This class contains  methods representing the 2 available game modes at the moment.
 */
public class Rounds
{

    boolean isCorrect=false;
    Questions questions = new Questions();

    /**
     * This method represents the Correct Answer game mode.
     * @param player is used to handle player's points.
     * @param round is used to check if this is the first round in the game.
     * If this is the first round, method addQuestion adds all the questions to the game.
     * There is also a for loop for the number of questions per round.
     * questions.choseQuestion() helps chose a question and with some other methods containing,  returns if the answer is correct
     * Finally if the answer is correct ,player wins 1000 points (addPoints(1000)).
     */
    public void roundCorrectAnswer(Player player,int round) {

        if (round==1)
        {
            questions.addQuestion();
        }

        for (int i = 0; i < 5; i++) {


            isCorrect=questions.choseQuestion();

            if (isCorrect) {
                player.addPoints(1000);
            }

        }
    }

    /**
     *
     * This method represents the Correct Answer game mode.
     * @param player is used to handle player's points
     * @param round is used to check if this is the first round in the game
     * If this is the first round, method addQuestion adds all the questions to the game.
     * There is also a for loop for the number of questions per round.
     * interaction.selectBet() is used to select the amount of points that player wants to bet and returns it
     *  player.removePoints(bet) is used to remove the amount of points that player wanted to bet
     * questions.choseQuestion() helps chose a question and with some other methods containing,  returns if the answer is correct
     * if the answer is correct ,player is getting back 2 times the bet he did using   player.addPoints(2*bet)
     */

    public void roundBetting(Player player,int round)
    {
        Interaction interaction=new Interaction();
        if (round==1)
        {
            questions.addQuestion();
        }
        int bet;

        for (int i = 0; i < 5; i++) {
            bet=interaction.selectBet();
            player.removePoints(bet);
            isCorrect=questions.choseQuestion();

            if (isCorrect) {
                player.addPoints(2*bet);
            }

        }
    }




}