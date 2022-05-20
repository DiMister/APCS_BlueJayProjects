package LevelEditor;

public class Enemy extends Moves
{
    boolean dead = false;
    
    public Enemy(int x,int y)
    {
        super(x,y,1,5);
    }
    
    public Enemy(int x,int y,int speed,int hp)
    {
        super(x,y,speed,hp);
    }
    
    public void dead(){dead = true;}
    
    public boolean getDead() {
        return dead;
    }
}