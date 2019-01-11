package newstuff;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MainMenu extends AppView {
    public MainMenu() {
        super();
    }

    public void paint(Graphics g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, App.width, App.height);

        String title = "Pa     Maze";
        Font stringFont1 = new Font( "Arial", Font.ITALIC, 80 );
        String play = "PLAY";
        Font stringFont2 = new Font( "Arial", Font.PLAIN, 70 );
        String settings = "SETTINGS";
        Font stringFont3 = new Font( "Arial", Font.PLAIN, 36 );
        String instructions = "INSTRUCTIONS";
        Font stringFont4 = new Font( "Arial", Font.PLAIN, 30 );
        String exit = "EXIT";

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.drawImage(Resources.logo, 250, 200, 100, 60, null);
        g2d.setFont(stringFont1);
        g2d.setColor(Color.black);
        g2d.drawString(title, 150, 250);
        g2d.setColor(Color.white);
        g2d.drawString(title, 155, 255);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(265, 405, 200, 75);
        g2d.fillRect(265, 505, 200, 50);
        g2d.fillRect(45, 775, 240, 40);
        g2d.fillRect(620, 775, 90, 40);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(260, 400, 200, 75);
        g2d.fillRect(260, 500, 200, 50);
        g2d.fillRect(40, 770, 240, 40);
        g2d.fillRect(615, 770, 90, 40);

        g2d.setFont(stringFont2);
        g2d.setColor(Color.decode("#0000ff"));
        g2d.drawString(play, 270, 465);
        g2d.setFont(stringFont3);
        g2d.drawString(settings, 270, 540);
        g2d.setFont(stringFont4);
        g2d.drawString(instructions, 50, 800);
        g2d.drawString(exit, 625, 800);
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        if (mouseEvent.getX() > 260 && mouseEvent.getX() < 460 && mouseEvent.getY() > 300 && mouseEvent.getY() < 475) {
            App.setCurrent(App.game);
        }
        else if (mouseEvent.getX() > 260 && mouseEvent.getX() < 460 && mouseEvent.getY() > 500 && mouseEvent.getY() < 550) {
            App.setCurrent(App.settings);
        }
        else if (mouseEvent.getX() > 40 && mouseEvent.getX() < 280 && mouseEvent.getY() > 770 && mouseEvent.getY() < 810) {
            App.setCurrent(App.instructions);
        }
        else if (mouseEvent.getX() > 615 && mouseEvent.getX() < 705 && mouseEvent.getY() > 770 && mouseEvent.getY() < 810) {
            System.exit(10);
        }
    }
}
