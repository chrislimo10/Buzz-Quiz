import java.io.*;
import java.util.Random;
import java.util.Scanner;


/**
 * This class is used to interact with the user.Contains all methods needed to handle input and output of the programme.
 */
public class Interaction {
    Scanner inp = new Scanner(System.in);

    /**
     * This method is used to print all messages needed to user at the start of the game.
     * User also has to decide if he want's to play using num 1 or num 2 keys.
     * If he presses something else ,it keep's asking him until he presses one of the correct keys
     * @return 1 if he want's to play or  2 and print's a message if he doesn't want.
     */
    public int StartGame() {
        System.out.println("Welcome to the Quizfy !");
        System.out.println("Are you ready to begin?");
        System.out.println("1. Yes           2.No");

        String answer = inp.next();

        while ((!answer.equals("1")) && (!answer.equals("2"))) {
            System.out.println("Press 1 to play or 2 to quit.");
            answer = inp.next();
        }
        int ans = Integer.parseInt(answer);
        if (ans == 2) {
            System.out.println("We hope you see you soon!");
            return 2;
        } else {
            return 1;
        }

    }

    /**
     * A really simple method that prints rules
     * @param players contains the number of players.
     * By the time first part contains only single player mode ,there is no point to create 2 players rules.
     *But it could be helpful at the second part of the assignment
     */
    public void Rules(int players) {
        System.out.println("Game Rules");
        if (players == 1) {
            System.out.println("There are 6 rounds of 5 questions");
            System.out.println("Our game features 4 categories: Sports  Geography Movies and History");
            System.out.println("There are 2 game modes available at the moment:");
            System.out.println("Correct Answer: You gain 1000 points for each correct answer.");
            System.out.println("Betting: You can bet 250,500,750 or 1000.If your answer is correct, you win twice the points you have betted.");
            System.out.println("You start the game with 0 points." + "\n");
        }

    }


    /**
     * This method chooses randomly a type of round and prints some messages to user.
     * First of all a random number between 0 and 1 is being chosen.
     * 0 represents gamemode Correct number and 1 represents Betting.
     * @param round is used only to print a message to user
     * @param x is used to call viewPoints(x) ,a method that prints player's points
     * @return 0 or 1 based on the type of round
     */
    public int chooseRound(int round, Player x)
    {
        Random rand = new Random();
        System.out.println("You are in round number " + round + " .");
        int pickround = rand.nextInt(2);
        if (pickround == 0) {
            System.out.println("You are playing Correct Answer gamemode. ");
        } else {
            System.out.println("You are playing Betting gamemode. ");
        }
        viewPoints(x);

        return pickround;
    }


    /**
     * This method is used to print a message based on the answer of the player
     * @param result is true if the answer is correct and false if not
     */
    public void printResult(boolean result) {
            if (result)
            {
                System.out.println("You are correct!"+'\n');
            }
            else
            {
                System.out.println("Wrong answer!");
            }
    }

    /**
     * A really simple method that just print a message to user when he finishes his game ,and the points he has collected.
     * @param player is used to print player's points
     */
    public void endGame(Player player) {
        System.out.println("You have completed all rounds");
        System.out.println("After all these questions you have collected "+player.getPoints()+" points!");
    }


    /**
     * This method asks player the amount of points he want's to bet and returns it.
     * key 1 for 250 points, key 2 for 500,key 3 for 750,4 for 1000
     * Programme keeps asking answer until one of those keys is pressed
     * @return the amount of points player would like  to bet
     */
    public int selectBet() {
            System.out.println("How many points would you like to bet?" );
            System.out.println("1. 250   2. 500  3. 750  4. 1000" );

            String answer=inp.next();

            while((!answer.equals("1"))&&(!answer.equals("2"))&&(!answer.equals("3"))&&(!answer.equals("4")))
            {
                System.out.println("Chose an answer!");
                answer=inp.next();
            }
            int ans=Integer.parseInt(answer);
            if (ans==1)
            {
                return 250;
            }
            else if (ans==2)
            {
                return 500;
            }
            else if (ans==3)
            {
                return 750;
            }
            else
            {
                return 1000;
            }
        }
    /**
     * This method is used to print the question to user and get his answer
     * @param category contains the category of the question
     * @param question contains the question
     * @param answers is an array containing all possible answers
     * There is also a part of code that keeps running until player presses one of the correct keys
     * @return player's answer
     */

    public int printQuestion(String category,String question,String[] answers )
    {
        System.out.println("YOUR CATEGORY IS "+category);
        System.out.printf("%n");
        System.out.println(question);
        for (int i=0;i<4;i++)
        {
            System.out.print((i+1)+".  ");
            System.out.println(answers[i]);
        }
        String answer=inp.next();

        while((!answer.equals("1"))&&(!answer.equals("2"))&&(!answer.equals("3"))&&(!answer.equals("4")))
        {
            System.out.println("Chose an answer!");
            answer=inp.next();
        }

        return Integer.parseInt(answer);

    }

    /**
     * This method is used to print player's points.
     * User is asked if he wants to view his points using num 1 or num 2 keys.
     * If he presses something else ,it keep's asking him until he presses one of the correct keys
     * @param x is used to call x.getPoints() method
     */
    public void viewPoints(Player x)
    {
        System.out.println("Would you like to see your point before the beginning  of next round?");
        System.out.println("1.Yes             2.No");

        String answer=inp.next();

        while((!answer.equals("1"))&&(!answer.equals("2")))
        {

            answer=inp.next();
        }
        int ans=Integer.parseInt(answer);
        if (ans==1)
        {
            System.out.println("You have "+x.getPoints()+" points!"+'\n');
        }

    }

    /**
     * This method is used to scan player's username
     * @return username
     */
    public String Username()
    {
        System.out.println("Enter your username:");
        String answer;
        answer=inp.next();
        return answer;
    }

    /**
     * This method is used to handle leaderboards.
     * First of all this method tries to open the file containing top 5 highscores between everyone having played the game.
     * If this file exists,username and points are saved in an array.If the file cointains stats for 5 people the worst performance is getting deleted.
     * Leaderboards are getting printed and then the file is getting deleted and made again with the the new information.
     * @param player is used to handle player's name and points
     * @throws IOException if the file doesn't exist , a new file is created containing the username and points of the current player.
     */
    public void Leaderboard(Player player) throws IOException {
        String[][] leaderboard = new String[5][2];
        int k=0;
        try(BufferedReader in = new BufferedReader(new FileReader("highscore.txt"))){
            String line;
            while((line = in.readLine())!=null){
                String[] pair = line.split("/");
                leaderboard[k][0]=pair[0];
                leaderboard[k][1]=pair[1];

                k++;
            }


            if (k<5)
            {
                leaderboard[k][0]=player.getUsername();
                leaderboard[k][1]=String.valueOf(player.getPoints());
                k++;
            }



            for (int i = 0; i < k; i++) {
                int temp=Integer.parseInt(leaderboard[i][1]);
                if (player.getPoints() >= temp) {
                    for (int j=k-2;j>=i;j--)
                    {

                        leaderboard[j+1][0]=leaderboard[j][0];
                        leaderboard[j+1][1]=String.valueOf(leaderboard[j][1]);
                    }
                    leaderboard[i][0]=player.getUsername();
                    leaderboard[i][1]=String.valueOf(player.getPoints());
                    break;
                }
            }




            for(int i=0;i<k;i++)
            {
                System.out.println((i+1)+" USERNAME : "+leaderboard[i][0]+" POINTS : "+leaderboard[i][1]);
            }
            File myObj = new File("highscore.txt");
            myObj.delete();
            File newObj = new File("highscore.txt");
            FileWriter fileWriter = new FileWriter("highscore.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i=0;i<k;i++)
            {
                printWriter.println(leaderboard[i][0]+"/"+leaderboard[i][1]);
            }
            printWriter.close();


        } catch (IOException e) {

            File newObj = new File("highscore.txt");
            FileWriter fileWriter = new FileWriter("highscore.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(player.getUsername()+"/"+player.getPoints());
            printWriter.close();
            System.out.println("You are the first player playing.");

        }
    }



}

