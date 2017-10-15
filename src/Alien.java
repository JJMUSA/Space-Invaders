import java.awt.*;
import java.util.Comparator;

public class Alien extends GameObject {
    public Bullet bomb;
    public final static double STARTING_POS=0;
    public final static double SPEED=0.3;
    public int direction=1;
    Image[] img;
    int currentImg=0;
    long time=System.currentTimeMillis();

    public Alien(double x, double y,double width, double height,Image[] img){
        super(x,y,SPEED,width,height);
        this.img=img;
    }

    public void update(){

        x+=direction*v;
        if(bomb!=null)if(bomb.dead)bomb=null;
        long currentTime=System.currentTimeMillis();
        long eplasedTime=currentTime-time;
        if(eplasedTime>500) {
            currentImg = (currentImg == 0) ? 1 : 0;
            time=currentTime;
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(img[currentImg],(int)x,(int)y,null);
    }


    public void dropBomb(){
        bomb=new Bullet(x+10,y+height,Color.white);
    }





    public void collisionHandling(){
        dead=true;
    }

    public static class AlienComparator implements Comparator<Alien>{

        @Override
        public int compare(Alien a, Alien b){
            if(a.x>b.x)return 1;
            if(a.x==b.x) return 0;
            return -1;
        }
    }


}
