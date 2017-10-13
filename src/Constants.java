import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
;


public class Constants {

    public static final double CEILING=80;
    public static final double RIGHT_BORDER=30;
    public static final double LEFT_BORDER=5;
    public static final int FRAME_HEIGHT=450;
    public static final int FRAME_WIDTH=500;
    public static final int GROUND=390;
    public static final Dimension FRAME_SIZE=new Dimension(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
    public static BufferedImage[][] ALIENS;

    public static void makeSpirites(){
        try

        {
            BufferedImage spiriteSheet = ImageIO.read(new File("invaders.png"));
            ALIENS[0][0]=spiriteSheet.getSubimage(0,0,22,16);
            ALIENS[0][1]=spiriteSheet.getSubimage(0,16,22,16);
            ALIENS[1][0]=spiriteSheet.getSubimage(22,0,16,16);
            ALIENS[1][1]=spiriteSheet.getSubimage(22,16,16,16);
            ALIENS[2][0]=spiriteSheet.getSubimage(30,0,24,16);
            ALIENS[2][1]=spiriteSheet.getSubimage(34,16,24,16);
        }
        catch(IOException e){e.printStackTrace();  }



    }
}
