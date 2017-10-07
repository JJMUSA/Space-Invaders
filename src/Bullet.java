import java.awt.*;

/**
 * Created by cc on 9/6/2017.
 */
public class Bullet extends GameObject{

    public static final double SPEED=-0.5;
    public static final double WIDTH=3;
    public static final double HEIGTH=3;
    public Bullet(double x, double y, double v,double width,double heigth){

        super(x,y,v,width,heigth);
    }

    public void update(){
        y+=v;
        if(y<=0)dead=true;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.RED);
        g.drawOval((int)x,(int)y,(int)width,(int) height);
    }

    public void collisionHandling(){
        dead=true;
    }
}
