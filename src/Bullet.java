import java.awt.*;

/**
 * Created by cc on 9/6/2017.
 */
public class Bullet extends GameObject{
    private final int H_SPACE=0;
    private final int V_SPACE=1;
    public static final double SPEED=-3;
    public static final double HEIGTH=5;
    public Bullet(double x, double y, double v,double width,double heigth){

        super(x,y,v,width,heigth);
    }

    public void update(){
        setX(x+H_SPACE);
        setY(y-V_SPACE);
        y+=v;

    }

    public void draw(Graphics2D g){
        g.setColor(Color.RED);
        g.drawLine((int)x,(int)y,(int)x,(int)(y+heigth));
    }

    public void collisionHandling(){
        dead=true;
    }
}
