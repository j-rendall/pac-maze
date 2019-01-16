package newstuff;

import javax.swing.*;

public class App {
    public static JFrame frame;
    private static AppView current;
    public static AppView main;
    public static AppView game;
    public static AppView instructions;
    public static final int width = 750;
    public static final int height = 890;
    public static boolean music = true;
    public static boolean sound = true;
    public static int score = 0;
    public static int highscore = 0;

    public static void setCurrent(AppView v) {
        App.current = v;
        App.frame.setContentPane(v);
        App.current.grabFocus();
    }

    public static void main(String[] args) {
        current = main = new MainMenu();
        game = new Game();
        instructions = new InstructionsMenu();

        frame = new JFrame("Pac-Maze");
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setContentPane(current);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Resources.peewee.playLoop();

        current.grabFocus();

        while (true) {
            frame.invalidate();
            frame.revalidate();
            frame.repaint();
            current.tick();
            try {Thread.sleep(20);} catch (InterruptedException ignored) {}
        }
    }
}
