import java.awt.*;

/**
 * Created by cc on 10/4/2017.
 */
public class Bomb extends GameObject{
    private static final double WIDTH=3;
    private static final double HEIGHT=3;
    private static final double SPEED=0.2;
    public Bomb(double x,double y){
        super(x,y,SPEED,WIDTH,HEIGHT);

    }

    public void update(){

        y+=v;
        if(y>Constants.GROUND)dead=true;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,(int)width,(int)height);
    }

    public void collisionHandling(){
        dead=true;
    }


}
