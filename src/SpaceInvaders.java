import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class SpaceInvaders {
    Player player;
    Controller ctrl;


    public List<GameObject> gameObj;
    public List<Alien> Aliens;
    public List<Bullet> bullets;
    public List<Bomb> bombs;
    private int shotingFreq=5;
    private Random numberOfShoters=new Random(7);
    private Random shooter;

    public SpaceInvaders(){
        ctrl=new Controller();
        player=new Player(Constants.LEFT_BORDER,(double)Constants.GROUND-30,0,20,20,ctrl);


        gameObj=new ArrayList<>();
        Aliens=new ArrayList<>();
        bullets=new ArrayList<>();
        bombs=new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<12;j++) {
                Alien alien = new Alien(Constants.LEFT_BORDER + j * 30, Constants.CEILING + 25 * i, 20, 20);
                Aliens.add(alien);
            }
        }

        gameObj.addAll(Aliens);
        gameObj.add(player);

    }

    private void update(){
        System.out.println(Aliens.size());

        shooter=new Random(Aliens.size()-1);
        while(shotingFreq==0){
            for (int i=0;i<numberOfShoters.nextInt();i++){
                int n=shooter.nextInt(50);
                System.out.println(n);
                Alien al=Aliens.get(n);
                al.dropBomb();
                bombs.add(al.getBomb());
            }
            shotingFreq=5;
        }

        shotingFreq-=1;

        synchronized (SpaceInvaders.class) {
            gameObj.addAll(bombs);
            if (player.bullet != null&&bullets.size()==0) bullets.add(player.bullet);
            gameObj.addAll(bullets);
            player.update();
            for (GameObject obj : gameObj) {
                obj.update();
            }




            for (Bullet bullet : bullets) {
                for (Alien al : Aliens) {
                    Rectangle r=al.bondingBox();
                    if (bullet.collisionDetection(r) && al.collisionDetection(bullet.bondingBox())) {
                        bullet.collisionHandling();
                        al.collisionHandling();
                    }
                }
            }

            List<GameObject> liveObjects=new ArrayList<>();

            for(GameObject obj:gameObj){
                if(!obj.dead){
                    liveObjects.add(obj);
                }
                else{
                    if(obj instanceof Alien)Aliens.remove(obj);
                    if (obj instanceof Bullet)bullets.remove(obj);
                }
            }
            gameObj.clear();
            gameObj.addAll(liveObjects);
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
