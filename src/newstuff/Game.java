package newstuff;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends AppView {
    private final java.util.List<Thing> things = new CopyOnWriteArrayList<>();
    public Level level;

    public Game() {
        super();
        try {
            this.level = new Level(Game.class.getResourceAsStream("/level 1.txt"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        this.addThing(new Pacman());
    }

    public void addThing(Thing t) {
        this.addKeyListener(t);
        this.addMouseListener(t);
        this.addMouseMotionListener(t);
        things.add(t);
    }

    public void removeThing(Thing t) {
        this.removeKeyListener(t);
        this.removeMouseListener(t);
        this.removeMouseMotionListener(t);
        things.remove(t);
    }

    public void paint(Graphics g2d) {
        Graphics2D g2 = (Graphics2D) g2d;
        Font stringFont = new Font( "Arial", Font.PLAIN, 20 );
        String menu = "MENU";
        String exit = "EXIT";

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,App.width, App.height);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(28, 25, 67, 25);
        g2d.fillRect(28, 65, 67, 25);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(23, 20, 67, 25);
        g2d.fillRect(23, 60, 67, 25);
        g2d.setColor(Color.BLACK);
        g2d.setFont(stringFont);
        g2d.drawString(menu, 29, 40);
        g2d.drawString(exit, 34, 80);       //Paints buttons and background
        level.drawOn(g2,0,0,App.width,App.height);
        for (Thing t: things) t.paint(this, g2);
    }

    public void tick() {
        for (Thing t: things) for (Thing t2: things) t.check(this, t2);
        for (Thing t: things) t.tick(this);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        if (mouseEvent.getX() > 23 && mouseEvent.getX() < 90 && mouseEvent.getY() > 20 && mouseEvent.getY() < 45) {
            App.setCurrent(App.main);
        }
        else if (mouseEvent.getX() > 23 && mouseEvent.getX() < 90 && mouseEvent.getY() > 60 && mouseEvent.getY() < 85) {
            System.exit(20);
        }
    }
}
