package editor;
import editor.Level;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LevelTest {
    public static void main(String[] args ) {


        try {
            System.out.println(new Level("C:\\Users\\s201109649\\IdeaProjects\\pac-maze\\res\\level 1.txt").toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
