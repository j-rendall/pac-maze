package newstuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Pacman extends Thing {
    public int x;
    public int y;
    public int direction = 4;
    public boolean activity = false;
    public int lives = 5;

    private final Image img;

    public Pacman(Image img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick(Game gd) {
        //W Up
        if ((direction == 1) && activity && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y - 5)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 30, y - 5)) != Level.Cell.WALL && y-5 >155){
            if (gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y - 5)) == Level.Cell.DOT) {
                gd.level.setCell(gd.level.getCellIndex(0, 110, 50, 50, x, y - 5), Level.Cell.SPACE);
                App.score += 1;
            }
            y -= 5;
        }
        //S DOWN
        if ((direction == 3) && activity && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y+35 )) != Level.Cell.WALL  && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x+30, y+35 )) != Level.Cell.WALL)
        {
            if (gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y+30 )) == Level.Cell.DOT) {
                gd.level.setCell(gd.level.getCellIndex(0, 110, 50, 50, x, y + 30), Level.Cell.SPACE);
                App.score += 1;
            }
            y += 5;
        }
        //D Right
        if ((direction == 2) && activity && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 35, y)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 35, y + 30)) != Level.Cell.WALL && x + 35< 705) {
            if (gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 35, y)) == Level.Cell.DOT) {
                gd.level.setCell(gd.level.getCellIndex(0, 110, 50, 50, x + 35, y), Level.Cell.SPACE);
                App.score += 1;
            }
            x += 5;
        }

        //A left
        if ((direction == 4) && activity && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x - 5, y)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x - 5, y + 30)) != Level.Cell.WALL) {
            if (gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x - 5, y)) == Level.Cell.DOT) {
                gd.level.setCell(gd.level.getCellIndex(0, 110, 50, 50, x - 5, y), Level.Cell.SPACE);
                App.score += 1;
            }
            x -= 5;
        }

        if (gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y)) == Level.Cell.EXIT)
        {
            int a = JOptionPane.showConfirmDialog(gd, "Would you like to continue to the next level or play on", "Question", YES_NO_OPTION);
            if (a == YES_OPTION) {
                System.out.println("yes option");
                if (gd.getCurrentLevel() < 10) {
                    gd.setCurrentLevel(gd.getCurrentLevel()+1);
                }
                else {
                    JOptionPane.showMessageDialog(gd, "Congratulation! You completed all 10 levels!", "You Did It!", JOptionPane.INFORMATION_MESSAGE);
                    App.score = 0;
                    gd.setCurrentLevel(1);
                    App.setCurrent(App.main);
                }
            }
            else {
                System.out.println("no option");
                x=55;
                direction =2;
            }
        }
    }

    @Override
    public void paint(Game gd, Graphics2D g2d) {
        if (direction == 1) {
            g2d.drawImage(Resources.pac1, x, y, 30, 30, null);

            //move other images off screen
            g2d.drawImage(Resources.pac2, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 30, 30, null);
        } else if (direction == 2) {
            g2d.drawImage(Resources.pac2, x, y, 30, 30, null);

            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 30, 30, null);
        } else if (direction == 3) {
            g2d.drawImage(Resources.pac3, x, y, 30, 30, null);
            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac2, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac4, 10000, 10000, 30, 30, null);
        } else if (direction == 4) {
            g2d.drawImage(Resources.pac4, x, y, 30, 30, null);

            //move other images off screen
            g2d.drawImage(Resources.pac1, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac2, 10000, 10000, 30, 30, null);
            g2d.drawImage(Resources.pac3, 10000, 10000, 30, 30, null);
        }
        for (int i=0;i<lives; i++) {
            g2d.drawImage(Resources.heart, (700-i*50), 70, 40, 40, null);
        }
    }


    @Override
    public void check(Game gd, Thing other) {

        //if (gd.level.getCell(this.gd.getLevel().getCellIndex(0, 124, 766, 890, this.x , this.y )) = Level.Cell.WALL)

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
                direction = 4;
                break;
            case VK_S:
            case VK_DOWN:
                activity = true;
                direction = 3;
                break;
            case VK_D:
            case VK_RIGHT:
                activity = true;
                direction = 2;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_UP:
                activity = false;
                break;
            case VK_A:
            case VK_LEFT:
                activity = false;
                break;
            case VK_S:
            case VK_DOWN:
                activity = false;
                break;
            case VK_D:
            case VK_RIGHT:
                activity = false;
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);

        Level.Point p = ((Game) App.game).level.getCellIndex(0, 110, 50, 50, mouseEvent.getX(), mouseEvent.getY());
        System.out.println(p);
        System.out.println(((Game) App.game).level.getCell(p));
    }
}
