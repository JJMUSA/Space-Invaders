import java.awt.*;

/**
 * Created by cc on 8/16/2017.
 */
public class Player extends GameObject{
    Controller ctrl;
    Bullet bullet;
    public Player(double x,double y, double v,double width, double heigth, Controller ctrl) {
        super(x,y,v,width,heigth);
        this.ctrl=ctrl;
    }

    public void update(){
        x+=(double) ctrl.action.move;
        if(x>Constants.FRAME_WIDTH-Constants.RIGHT_BORDER)x=Constants.FRAME_WIDTH-Constants.RIGHT_BORDER;
        if(x<=Constants.LEFT_BORDER)x=Constants.LEFT_BORDER;
        if(ctrl.action.shoot) {
            //if (ctrl.action.move == -1) mkBullet(x-2);
            //if (ctrl.action.move == 1) mkBullet(x+2);
             mkBullet();
        }
    }

    public void draw(Graphics2D g){
        g.setColor(Color.blue);
        g.fillOval((int)x,(int)y,(int)width,(int)heigth);
    }

    public void mkBullet(){
        bullet=new Bullet(x+5,y,Bullet.SPEED,3,Bullet.HEIGTH);
    }

    public void collisionHandling(){
        dead=true;
    }


}
