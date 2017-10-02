import javax.swing.*;
import java.awt.*;

/**
 * Created by cc on 8/25/2017.
 */
public class View extends JPanel {
    SpaceInvaders game;
    public View(SpaceInvaders si){
        game=si;
    }

    @Override
    public void paintComponent(Graphics g0){
        Graphics2D g=(Graphics2D) g0;
        g.setBackground(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.green);
        g.drawLine(0,Constants.GROUND,Constants.FRAME_WIDTH,Constants.GROUND);
        synchronized (SpaceInvaders.class) {
            for (GameObject obj : game.gameObj) {
                obj.draw(g);
            }
        }

    }

    @Override
    public Dimension getPreferredSize(){
        return Constants.FRAME_SIZE;
    }

}
