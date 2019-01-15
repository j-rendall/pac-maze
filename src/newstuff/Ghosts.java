package newstuff;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_RIGHT;

public class Ghosts extends Thing {
    public int x = 705;
    public int y = 665;
    public int direction = 2;
    public boolean activity = false;

    Ghosts[] list = new Ghosts[5];

    public Ghosts() {
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
        g2d.drawImage(Resources.blinky, x, y, 40, 40, null);
        g2d.drawImage(Resources.clyde, x, y, 40, 40, null);
        g2d.drawImage(Resources.inky, x, y, 40, 40, null);
        g2d.drawImage(Resources.pinky, x, y, 40, 40, null);
    }


    @Override
    public void check(Game gd, Thing other) {
        //gd.level
    }
}
