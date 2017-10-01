import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class SpaceInvaders {
    Player player;
    Controller ctrl;


    public List<GameObject> gameObj;
    public List<Alien> Aliens;

    public SpaceInvaders(){
        ctrl=new Controller();
        player=new Player(5,450,0,ctrl);


        gameObj=new ArrayList<>();
        Aliens=new ArrayList<>();
        for(int i=0;i<5;i++){
            Alien alien=new Alien(+i*25,80);
            Aliens.add(alien);
        }
        gameObj.addAll(Aliens);
        gameObj.add(player);

    }

    private void update(){
        if(player.bullet!=null)gameObj.add(player.bullet);
        for(GameObject obj:gameObj){
            obj.update();
        }
        int d=Aliens.get(0).direction;
        Iterator alienIt=Aliens.iterator();
        if(d==1) {
            for (Alien a : Aliens) {
                double x = a.x;
                if (x>=Constants.FRAME_WIDTH-Constants.RIGHT_BORDER){
                    while(alienIt.hasNext()){
                        Alien al=(Alien)alienIt.next();
                        al.setY(al.y +1);
                        al.setDirection(-1);
                    }
                }
            }
        }
        else if(d==-1){
            for(Alien a:Aliens){
                double x=a.x;
                if(x<=Constants.LEFT_BORDER){
                    while(alienIt.hasNext()){
                        Alien al=(Alien)alienIt.next();
                        al.setY(al.y+1);
                        al.setDirection(1);
                    }
                }
            }

        }


    }

    public static void main(String[] args){
        SpaceInvaders game=new SpaceInvaders();
        View view=new View(game);
        new Frame(view).addKeyListener(game.ctrl);

        while(true){
            game.update();
            view.repaint();
            try {
                Thread.sleep(10);
            }catch (Exception e){}
        }
    }
}
