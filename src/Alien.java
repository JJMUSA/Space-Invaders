import java.awt.*;

public class Alien extends GameObject{
    public Bomb bomb;
    public final static double STARTING_POS=0;
    public final static double SPEED=0.3;
    public int direction=1;
    Image[] img;
    int currentImg=0;

    public Alien(double x, double y,double width, double height,Image[] img){
        super(x,y,SPEED,width,height);
        this.img=img;
    }

    public void update(){

        x+=direction*v;
        if(bomb!=null)if(bomb.dead)bomb=null;
        currentImg=(currentImg==0)? 1:0;
    }

    public void draw(Graphics2D g){
        g.drawImage(img[currentImg],(int)x,(int)y,null);
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
