import java.awt.*;

/**
 * Created by cc on 9/6/2017.
 */
public class Bullet extends GameObject{

    public static final double PLAYERBULLETSPEED=-0.5;
    public static final double ALIENBOMBSPEED=0.3;
    public static final double WIDTH=5;
    public static final double HEIGHT=3;
    Color color;
    public Bullet(double x, double y){

        super(x,y,PLAYERBULLETSPEED,WIDTH,HEIGHT);
        color=Color.red;

    }
    public Bullet(double x,double y,Color c){
        super(x,y,ALIENBOMBSPEED,WIDTH,HEIGHT);
        color=c;
    }

    public void update(){
        y+=v;
        if(y<=0)dead=true;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,(int)width,(int) height);
    }

    public void collisionHandling(){
        dead=true;
    }
}
