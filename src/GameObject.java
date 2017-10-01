import java.awt.*;

public abstract class GameObject
{
    double x, y;
    double v;
    boolean dead;


    public GameObject(double x, double y, double v ){

        this.x=x;
        this.y=y;
        this.v=v;
    }

    public abstract void update();

    public boolean interSect(int x, int y){
        if(this.x-x<=0 && this.y-y<=0 )return true;
        return false;
    }

    public abstract void draw(Graphics2D g);

    public void setX(double x){this.x=x;}

    public void setY(double y) {this.y=y;}

}
