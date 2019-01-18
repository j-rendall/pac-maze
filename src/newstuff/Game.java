package newstuff;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static newstuff.App.highscore;

public class Game extends AppView {
    private final java.util.List<Thing> things = new CopyOnWriteArrayList<>();
    public Level level;
    private int currentLevel = 1;

    public void setCurrentLevel(int currentLevel ) {
        this.currentLevel = currentLevel;
        this.reset();
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    public Game() {
        super();
        this.reset();
    }

    private void reset() {
        try {
            this.level = new Level(Game.class.getResourceAsStream("/level " + currentLevel +".txt"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        things.clear();
        Level.Point pacSpawn = this.level.getPacPoint();
        this.addThing(new Pacman(Resources.pac4, 0+50*pacSpawn.col + 10,110 + 50*pacSpawn.row + 10));
        Level.Point ghostSpawn = this.level.getGhostPoint();
        this.addThing(new Ghost(Resources.blinky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.clyde, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.inky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));
        this.addThing(new Ghost(Resources.pinky, 0 + 50*ghostSpawn.col + 5, 110 + 50*ghostSpawn.row + 5));

//        //draw exit sign
//        Level.Point exitSpawn = this.level.getExitPoint();
//        Font stringFont1 = new Font( "Arial", Font.PLAIN, 20 );
//        g2d.setFont(stringFont1);
//        g2d.setColor(Color.WHITE);
//        String nextlvl = " Next";
//        String nextlvl2 = " level";
//        String nextlvl3 = "<";
//        g2d.drawString(nextlvl,0+50*exitSpawn.col + 10,110 + 50*exitSpawn.row -100);
//        g2d.drawString(nextlvl2,0+50*exitSpawn.col + 10,110 + 50*exitSpawn.row - 80);
//        g2d.drawString(nextlvl3,0+50*exitSpawn.col + 10,110 + 50*exitSpawn.row - 60);
//        g2d.drawLine(10, 432, 40,432);
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
        if (App.highscore > 0) {
            try {
                FileWriter fw = new FileWriter("res\\scorekeep");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(App.highscore);
                pw.close();
            } catch (IOException e) {
                System.out.println("No Highscore File Found");
            }
        }
        try
        {
            FileReader fr = new FileReader("res\\scorekeep");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine()) != null)
            {
                int highscore = Integer.parseInt(line.trim());
                App.highscore = highscore;
            }
            br.close();
        }
        catch(IOException e)
        { System.out.println("No Highscore File Found"); }
        if (highscore < App.score) {
            highscore = App.score;}
        try
        {
            FileWriter fw = new FileWriter("res\\scorekeep");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(App.highscore);
            pw.close();
        }
        catch(IOException e)
        { System.out.println("No Highscore File Found"); }
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

    public int getCurrentLevel() {
        return currentLevel;
    }
}
