import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;


public class Constants {
    public static final double CEILING=80;
    public static final double RIGHT_BORDER=30;
    public static final double LEFT_BORDER=5;
    public static final int FRAME_HEIGHT=450;
    public static final int FRAME_WIDTH=500;
    public static final int GROUND=390;
    public static final Dimension FRAME_SIZE=new Dimension(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
    public static BufferedImage[][] AlienSprites={{getSprites(22,0,16,16),getSprites(22,16,16,16)},
                                                    {getSprites(38,0,24,16),getSprites(38,16,24,16)},
                                                    {getSprites(0,0,22,16),getSprites(0,16,22,16)}
                                                    };
    public static BufferedImage PlayerSprite=getSprites(62,0,22,16);
    public static BufferedImage BlockerSprite=getSprites(84,8,36,24);
    public static BufferedImage getSprites(int x, int y, int width, int height){
        BufferedImage spriteSheet=null;
        BufferedImage sprite;
        try{
            spriteSheet= ImageIO.read(new File("invaders.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        sprite=spriteSheet.getSubimage(x,y,width,height) ;
        return sprite;
    }
}
