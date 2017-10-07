import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter{
    public Action action;
    public Controller(){
        action=new Action();
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        switch(key){
            case KeyEvent.VK_RIGHT:
                action.move=1;
                break;
            case KeyEvent.VK_LEFT:
                action.move=-1;
                break;
            case KeyEvent.VK_SPACE:
                action.shoot=true;
                break;

        }


    }



    @Override
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:
                action.move=0;
                break;
            case KeyEvent.VK_RIGHT:
                action.move=0;
                break;
            case KeyEvent.VK_SPACE:
                action.shoot=false;
                break;

        }
    }
}
