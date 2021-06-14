import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *This class represents the Questions and contains all the methods needed.
 * All questions are saved in a list so that we can use shuffle method.
 */
public class Questions
{

    List<Questions> list = new ArrayList<>();
    private String question;
    private String category;
    private String correctAnswer;
    String[] answers={"1","2","3","4"};

    public Questions()
    {

    }
    public Questions(String question,String answer1,String answer2,String answer3,String answer4,String correctAnswer,String category)
    {
        this.question=question;
        this.correctAnswer=correctAnswer;
        answers[0]=answer1;
        answers[1]=answer2;
        answers[2]=answer3;
        answers[3]=answer4;
        this.category=category;
    }
    public String getQuestion()
    {
        return  question;
    }
    public String getAnswer1()
    {
        return answers[0];
    }
    public String getAnswer2()
    {
        return answers[1];
    }
    public String getAnswer3()
    {
        return answers[2];
    }
    public String getAnswer4()
    {
        return answers[3];
    }
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public String getCategory()
    {
        return category;
    }


    /**
     * This method is used to add all questions in the game from a txt file
     */
    public void addQuestion()
    {

        try(BufferedReader in = new BufferedReader(new FileReader("file.txt"))){
            String line;
            while((line = in.readLine())!=null){
                String[] pair = line.split("/");

                list.add(new Questions(pair[0],pair[1],pair[2],pair[3],pair[4],pair[5],pair[6]));

            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    /**
     * This method is used to chose randomly a question,shuffle answers and check if the answer is correct
     * First of all a List is created storing the numbers 1 to 4 and then shuffles them
     * We also shuffle the list containing the questions because we always use the first item
     * By the time numbers have been shuffled we use the list in a for loop so that we can shuffle the order of the questions and they are getting saved in a new array
     * Method interaction.printQuestion is also used and returns the answer of the user
     * After this ,the answer of user is checked if it equals to the correct answer
     * A message is printed to user based on  his answer ( correct or false) and the questions is deleted so that it won't appear again
     * @return true if answer is true or false if not
     */
    public boolean choseQuestion()
    {


        List<Integer>  order = new ArrayList<Integer>();
        for(int i = 1; i <= 4; i++) {
            order.add(i);
        }
        Collections.shuffle(order);
        Collections.shuffle(list);

        String[]  answers={"0","0","0","0"};
        int i=1;

        for(Integer index : order) {

            i++;

            if (index==1)
            {

                answers[i-2]=list.get(0).getAnswer1();

            }
            else if(index==2)
            {

                answers[i-2]=list.get(0).getAnswer2();
            }
            else if(index==3)
            {
                answers[i-2]=list.get(0).getAnswer3();

            }
            else if(index==4)
            {
                answers[i-2]=list.get(0).getAnswer4();

            }

        }

        Interaction interaction=new Interaction();
        int answer= interaction.printQuestion(list.get(0).category,list.get(0).getQuestion(),answers);




        if ((answer==1)&&(list.get(0).getCorrectAnswer().equals(answers[0])))
        {
            interaction.printResult(true);
            list.remove(0);
            return  true;
        }
        else if ((answer==2)&&(list.get(0).getCorrectAnswer().equals(answers[1])))
        {
            interaction.printResult(true);
            list.remove(0);
            return  true;
        }
        else if ((answer==3)&&(list.get(0).getCorrectAnswer().equals(answers[2])))
        {
            interaction.printResult(true);
            list.remove(0);
            return  true;
        }
        else if ((answer==4)&&(list.get(0).getCorrectAnswer().equals(answers[3])))
        {
            interaction.printResult(true);
            list.remove(0);
            return  true;
        }
        else
        {
            interaction.printResult(false);
            list.remove(0);
            return  false;

        }




    }
}