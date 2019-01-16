package newstuff;

import java.awt.*;

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
        //W UP
        if ((direction==1) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y-ya )) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x+40, y-5 )) != Level.Cell.WALL)
        { y -= ya; }
        else direction = (int) (Math.random()*4)+1;
        //S DOWN
        if ((direction==3) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x, y+ya )) != Level.Cell.WALL  && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x+40, y+45 )) != Level.Cell.WALL)
        { y += ya; }
        else direction = (int) (Math.random()*5)+1;
        //D Right
        if ((direction==2) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x+xa, y )) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x+45, y+40 )) != Level.Cell.WALL)
        { x += xa; }
        else direction = (int) (Math.random()*4)+1;
        //A left
        if ((direction==1) && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x-xa, y )) != Level.Cell.WALL && gd.level.getCell(gd.level.getCellIndex(0, 110, 50, 50, x-5, y+40 )) != Level.Cell.WALL)
        { x -= xa; }
        else direction = (int) (Math.random()*4)+1;
    }

    @Override
    public void paint(Game gd, Graphics2D g2d) {
        g2d.drawImage(this.img, x, y, 40, 40, null);
    }

    @Override
    public void check(Game gd, Thing other) { }
}
