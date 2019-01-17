package newstuff;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends AppView {
    private final java.util.List<Thing> things = new CopyOnWriteArrayList<>();
    public Level level;
    public int currentLevel = 1;

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    public Game() {
        super();
        try {
            this.level = new Level(Game.class.getResourceAsStream("/level " + currentLevel +".txt"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        this.addThing(new Pacman());
        Level.Point ghostSpawn = this.level.getGhostPoint();
        this.addThing(new Ghost(Resources.blinky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.clyde, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.inky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.pinky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
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

    public void highscore() {
        if (App.highscore < App.score) {App.highscore = App.score;}
    }

    public void paint(Graphics g2d) {
        Graphics2D g2 = (Graphics2D) g2d;
        level.drawOn(g2,0,110,50, 50);
        for (Thing t: things) t.paint(this, g2);
    }

    public void tick() {
        for (Thing t: things) for (Thing t2: things) t.check(this, t2);
        for (Thing t: things) t.tick(this);
        highscore();
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
