import java.awt.*;
import java.util.*;
import java.util.List;


public class SpaceInvaders {
    Player player;
    Controller ctrl;


    public List<GameObject> gameObj;
    public List<Alien> Aliens;
    public List<Bullet> bullets;
    public List<Bullet> bombs;
    private Random shooter;
    private long time=System.currentTimeMillis();
    private int lives=3;
    private int death=0;

    public SpaceInvaders(){
        ctrl=new Controller();
        player=new Player(Constants.LEFT_BORDER,(double)Constants.GROUND-30,0,20,20,ctrl);


        gameObj=new ArrayList<>();
        Aliens=new ArrayList<>();
        bullets=new ArrayList<>();
        bombs=new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<12;j++) {
                int sprite=(i>2)? 2:i;
                Alien alien = new Alien(Constants.LEFT_BORDER + j * 30, Constants.CEILING + 25 * i, 20, 20,Constants.AlienSprites[sprite]);
                Aliens.add(alien);
            }
        }
        shooter=new Random(Aliens.size());
        gameObj.addAll(Aliens);
        gameObj.add(player);

    }



    private void update(){
        synchronized (SpaceInvaders.class) {
            long currentTime=System.currentTimeMillis();
            long elapsedTime=currentTime-time;
            if(elapsedTime>450&&Aliens.size()>0){
                Alien alien= Aliens.get(shooter.nextInt(Aliens.size()));
                while(alien.bomb!=null)alien=Aliens.get(shooter.nextInt(Aliens.size()));
                alien.dropBomb();
                bombs.add(alien.bomb);
                time=currentTime;
            }
            gameObj.addAll(bombs);

            if (player.bullet != null&&bullets.size()==0) bullets.add(player.bullet);
            gameObj.addAll(bullets);
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

            for(Bullet bomb:bombs){
                if(bomb.bondingBox().intersects(player.bondingBox())&&player.bondingBox().intersects(bomb.bondingBox())){
                    bomb.collisionHandling();
                    player.collisionHandling();
                }
            }

            List<GameObject> liveObjects=new ArrayList<>();

            for(GameObject obj:gameObj){
                if(!obj.dead){
                    liveObjects.add(obj);
                }
                else{
                    if(obj instanceof Alien)Aliens.remove(obj);
                    if (obj instanceof Bullet && obj.v==Bullet.PLAYERBULLETSPEED)bullets.remove(obj);
                    if (obj instanceof Bullet && obj.v==Bullet.ALIENBOMBSPEED)bombs.remove(obj);
                }
            }
            gameObj.clear();
            gameObj.addAll(liveObjects);
            if(player.dead&&lives>0){
                player.dead=false;
                player.setX(Constants.LEFT_BORDER);
                player.setY(Constants.GROUND-30);
                lives-=1;
                gameObj.add(player);
            }
        }

        Alien.AlienComparator comp=new Alien.AlienComparator();
        Alien _max= Collections.max(Aliens,comp);
        Alien _min=Collections.min(Aliens,comp);
        Iterator AliensIt=Aliens.iterator();
        if(_min.x<Constants.LEFT_BORDER || _max.x>Constants.FRAME_WIDTH-30){
            while(AliensIt.hasNext()){
                Alien al=(Alien) AliensIt.next();
                al.direction*=-1;
                al.setY(al.y+15);
            }
        }




    }
    public int getLives(){

        return lives;
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
