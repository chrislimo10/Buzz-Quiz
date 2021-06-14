/**
 * Class Player is made to store player's points and name
 *This class contains a points variable and some really basic methods which help us manage them.
 */
public class Player
{

    int points;

    public Player()
    {
        points = 1000;
    }

    public int getPoints()
    {
        return points;
    }

    public void addPoints(int x)
    {
        points += x;
    }

    public void removePoints(int x)
    {
        points -= x;
    }

    private String username;

    public Player(String username){this.username=username;}

    public String getUsername(){return username;}
}