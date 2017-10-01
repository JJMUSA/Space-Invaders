import java.awt.*;

public class Alien extends GameObject{
    private boolean bomb;
    public final static double STARTING_POS=0;
    public final static double SPEED=0.4;
    public int direction=1;

    public Alien(double x, double y){
        super(x,y,SPEED);
    }

    public void update(){
        x+=direction*v;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.red);
        g.fillOval((int)x+10,(int) y+10,20,20);
    }

    public void setDirection(int direction){this.direction=direction;}


}
