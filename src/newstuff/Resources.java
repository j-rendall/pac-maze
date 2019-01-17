package newstuff;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

public class Resources {
    public static final Image logo = loadImage("pacmanlogo.png");
    public static final Image heart = loadImage("heart.png");
    public static final Image settingsimg = loadImage("settings.jpg");
    public static final Image instructionsimg = loadImage("instructions.jpg");
    public static final Image pac1 = loadImage("pacman1.png");
    public static final Image pac2 = loadImage("pacman2.png");
    public static final Image pac3 = loadImage("pacman3.png");
    public static final Image pac4 = loadImage("pacman4.png");
    public static final Image blinky = loadImage("Blinky.png");
    public static final Image clyde = loadImage("Clyde.png");
    public static final Image inky = loadImage("Inky.png");
    public static final Image pinky = loadImage("Pinky.png");

    public static final Sound peewee = new Sound("res\\peewee.wav");
    public static final Sound death = new Sound("res\\death.wav");

    public static Image loadImage(String filename) {
        try {
            return ImageIO.read(Resources.class.getResourceAsStream(filename));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static class Sound {
        private String filename;
        private Clip current;
        Sound(String filename) {
            this.filename = filename;
        }
        public Clip play() {
            try {if (this.current != null) this.current.stop();} catch (Exception ignored) {}
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                this.current = clip;
                return clip;
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
                return null;
            }
        }
        public void playLoop() {
            Clip c = this.play();
            if (c != null) c.loop(Clip.LOOP_CONTINUOUSLY);
        }
        public void stop() {
            try {if (this.current != null) this.current.stop();} catch (Exception ignored) {}
        }
    }
}
