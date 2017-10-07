import java.awt.*;

import static java.lang.Math.abs;

public abstract class GameObject
{
    double x, y;
    double width;
    double height;
    double v;
    boolean dead;


    public GameObject(double x, double y, double v,double width,double height){

        this.x=x;
        this.y=y;
        this.v=v;
        this.width=width;
        this.height = height;
    }

    public abstract void update();

    public boolean collisionDetection(Rectangle r){
        if(this.bondingBox().intersects(r)&&r.intersects(this.bondingBox()))return true;
        return false;
    }

    public abstract void collisionHandling();

    public abstract void draw(Graphics2D g);

    public void setX(double x){this.x=x;}

    public void setY(double y) {this.y=y;}

    public Rectangle bondingBox() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

}
