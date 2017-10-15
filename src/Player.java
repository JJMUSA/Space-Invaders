import javafx.embed.swing.SwingFXUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by cc on 8/16/2017.
 */
public class Player extends GameObject{
    Controller ctrl;
    Bullet bullet;
    Image image=Constants.PlayerSprite;

    double accleration=0.5;
    double decleartion=1;

    public Player(double x,double y, double v,double width, double heigth, Controller ctrl) {
        super(x,y,v,width,heigth);
        this.ctrl=ctrl;

    }

    public void update(){
        if(ctrl.action.move!=0) {
            v += ctrl.action.move * accleration;
            if (v < -2) v = -2;
            if (v > 2) v = 2;
        }
        else {
            if(v>0)v-=decleartion;
            if(v<0)v+=decleartion;
        }
        x+=v;
        x=Math.max(Math.min(x,Constants.FRAME_WIDTH-30),Constants.LEFT_BORDER);
        if(ctrl.action.shoot)mkBullet();
        else bullet=null;

    }

    public void draw(Graphics2D g){
        g.drawImage(image,(int)x,(int)y,null);
    }

    public void mkBullet(){
        bullet=new Bullet(x+10,y);
    }

    public void collisionHandling(){
        dead=true;
    }


}
