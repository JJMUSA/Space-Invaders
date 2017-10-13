import java.awt.*;

public class Alien extends GameObject{
    public Bomb bomb;
    public final static double STARTING_POS=0;
    public final static double SPEED=0.3;
    public int direction=1;

    public Alien(double x, double y,double width, double heigth){
        super(x,y,SPEED,width,heigth);
    }

    public void update(){

        x+=direction*v;
        if(bomb!=null)if(bomb.dead)bomb=null;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.red);
        g.fillOval((int)x,(int) y,(int)width,(int) height);
    }

    public void dropBomb(){
        bomb=new Bomb(x+width/2,y+height);
    }

    public Bomb getBomb(){return bomb;}

    public void setDirection(int direction){this.direction=direction;}

    public void collisionHandling(){
        dead=true;
    }


}
