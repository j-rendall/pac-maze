package newstuff;

import java.awt.*;
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

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, App.width, App.height);
        for (Thing t: things) t.paint(this, g2);
    }

    public void tick() {
        for (Thing t: things) for (Thing t2: things) t.check(this, t2);
        for (Thing t: things) t.tick(this);
    }
}
