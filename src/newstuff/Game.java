package newstuff;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends AppView {
    private final java.util.List<Thing> things = new CopyOnWriteArrayList<>();

    public Game() {
        super();
    }

    public void addThing(Thing t) {
        things.add(t);
    }

    public void removeThing(Thing t) {
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
