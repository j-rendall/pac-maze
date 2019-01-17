package newstuff;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Ghost extends Thing {
    public int x;
    public int y;
    public int xa = 50;
    public int ya = 50;
    public int direction = 3;
    private final Image img;

    public Ghost(Image img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick(Game gd) {
        if (System.currentTimeMillis() % 3 == 0) {
            //W UP
            if ((direction == 1) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y - 50)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 40, y - 5)) != Level.Cell.WALL && x<700 && y>110) {
                y -= ya;
            } else {
                if (Math.random() > 0.3) {
                    direction = 1;
                } else {
                    direction = (int) (Math.random() * 4) + 1;
                }
            }
            //S DOWN
            if ((direction == 3) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y + 50)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 40, y + 45)) != Level.Cell.WALL && x<700 && y>110) {
                y += ya;
            } else {
                if (Math.random() > 0.3) {
                    direction = 3;
                } else {
                    direction = (int) (Math.random() * 4) + 1;
                }
            }
            //D Right
            if ((direction == 2) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 50, y)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x + 45, y + 40)) != Level.Cell.WALL && x<700 && y>110) {
                x += xa;
            } else {
                if (Math.random() > 0.3) {
                    direction = 2;
                } else {
                    direction = (int) (Math.random() * 4) + 1;
                }
            }
            //A left
            if ((direction == 1) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x - 50, y)) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x - 5, y + 40)) != Level.Cell.WALL && x<700 && y>110) {
                x -= xa;
            } else {
                if (Math.random() > 0.3) {
                    direction = 4;
                } else {
                    direction = (int) (Math.random() * 4) + 1;
                }
            }
        }
    }

    @Override
    public void paint(Game gd, Graphics2D g2d) {
        g2d.drawImage(this.img, x, y, 40, 40, null);
    }

    @Override
    public void check(Game gd, Thing other) {
        if (other instanceof Pacman) {
            Pacman p = (Pacman) other;
            if (p.x >= (this.x - 10) && p.x <= (this.x + 10) && p.y >= (this.y - 10) && p.y <= (this.y + 10)) {
                p.lives--;
                Resources.death.play();
                p.x = 700;
                p.y = 665;
                if (p.lives == 0) {
                    int a = JOptionPane.showConfirmDialog(gd, "You died. Would you like to restart?", "Question", YES_NO_OPTION);
                    if (a == YES_OPTION) {
                        System.out.println("yes option");
                        //App.setCurrent(App.MainMenu);
                        App.score =0;
                    } else {
                        System.out.println("no option");
                        System.exit(10);
                    }
                }
            }
        }
    }
}
