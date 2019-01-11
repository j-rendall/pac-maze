package newstuff;

import javax.imageio.ImageIO;
import java.awt.*;

public class Resources {
    public static final Image logo = loadImage("pacmanlogo.png");
    public static final Image settingsimg = loadImage("settings.jpg");
    public static final Image instructionsimg = loadImage("instructions.jpg");
    public static final Image pac1 = loadImage("pacman1.png");
    public static final Image pac2 = loadImage("pacman2.png");
    public static final Image pac3 = loadImage("pacman3.png");
    public static final Image pac4 = loadImage("pacman4.png");
//    public static final Image blinky = loadImage("Blinky.png");
//    public static final Image clyde = loadImage("Clyde.png");
//    public static final Image inky = loadImage("Inky.png");
//    public static final Image pinky = loadImage("Pinky.png");

    public static Image loadImage(String filename) {
        try {
            return ImageIO.read(Resources.class.getResourceAsStream(filename));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
