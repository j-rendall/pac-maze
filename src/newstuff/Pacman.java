package newstuff;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Pacman extends Thing {
    public int x = 705;
    public int y = 665;
    public int direction = 2;
    public boolean activity = false;

    public Pacman() {
    }

    @Override
    public void tick(Game gd) {
        //W Up
        if ((direction == 1) && activity) y -= 5;
        //S DOWN
        if ((direction == 3) && activity) y += 5;
        //A LEFT
        if ((direction == 4) && activity) x += 5;
        // Right
        if ((direction == 2) && activity) x -= 5;
    }

    @Override
    public void paint(Game gd, Graphics2D g2d) {
        if (direction == 1) {
            g2d.drawImage(Resources.pac1, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(Resources.pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 40, 40, null);
        } else if (direction == 4) {
            g2d.drawImage(Resources.pac2, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 40, 40, null);
        } else if (direction == 3) {
            g2d.drawImage(Resources.pac3, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 40, 40, null);
        } else if (direction == 2) {
            g2d.drawImage(Resources.pac4, x, y, 40, 40, null);

            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac2, 10000, 10000, 40, 40, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 40, 40, null);
        }
    }


    @Override
    public void check(Game gd, Thing other) {
        //gd.level
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);
        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_UP:
                activity = true;
                direction = 1;
                break;
            case VK_A:
            case VK_LEFT:
                activity = true;
                direction = 2;
                break;
            case VK_S:
            case VK_DOWN:
                activity = true;
                direction = 3;
                break;
            case VK_D:
            case VK_RIGHT:
                activity = true;
                direction = 4;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        switch (keyEvent.getKeyCode()) {
            case VK_W:
                activity = false;
                break;
            case VK_A:
                activity = false;
                break;
            case VK_S:
                activity = false;
                break;
            case VK_D:
                activity = false;
                break;
        }
    }
}
