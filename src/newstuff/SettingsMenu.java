package newstuff;

import java.awt.*;
import java.awt.event.MouseEvent;

import static newstuff.App.game;

public class SettingsMenu extends AppView {
    public SettingsMenu() {
        super();
    }

    public void paint(Graphics g2d) {
        String errormessage = "ERROR 404";
        Font stringFont1 = new Font( "Arial", Font.BOLD, 100 );
        String errormessage2 = "This Page Does Not Exist!";
        Font stringFont2 = new Font("Arial", Font.PLAIN, 40);

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.setFont(stringFont1);
        g2d.setColor(Color.black);
        g2d.drawString(errormessage, 100, 250);
        g2d.setFont(stringFont2);
        g2d.drawString(errormessage2, 100, 400);

        g2d.drawImage(Resources.settingsimg, 0, 0, 766, 860, null);

        g2d.drawLine(100,0,100, 10);
        g2d.drawLine(200,0,200, 10);
        g2d.drawLine(300,0,300, 10);
        g2d.drawLine(400,0,400, 10);
        g2d.drawLine(500,0,500, 10);
        g2d.drawLine(600,0,600, 10);
        g2d.drawLine(0,100,10, 100);
        g2d.drawLine(0,200,10, 200);
        g2d.drawLine(0,300,10, 300);
        g2d.drawLine(0,400,10, 400);
        g2d.drawLine(0,500,10, 500);
        g2d.drawLine(0,600,10, 600);
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        if (mouseEvent.getX() > 0 && mouseEvent.getX() < 60 && mouseEvent.getY() > 0 && mouseEvent.getY() < 60) {
            App.setCurrent(App.main);
        }
        else if (mouseEvent.getX() > 275 && mouseEvent.getX() < 300 && mouseEvent.getY() > 205 && mouseEvent.getY() < 230) {
            if (App.music) {App.music = false;}
            else if (!App.music) {App.music = true;}
            System.out.println("Music:" + App.music);
        }
        else if (mouseEvent.getX() > 275 && mouseEvent.getX() < 300 && mouseEvent.getY() > 350 && mouseEvent.getY() < 375) {
            if (App.sound) {App.sound = false;}
            else if (!App.sound) {App.sound = true;}
            System.out.println("Sound:" + App.sound);
        }
        else if (mouseEvent.getX() > 375 && mouseEvent.getX() < 750 && mouseEvent.getY() > 840 && mouseEvent.getY() < 890) {
            App.highscore = 0;
        }
    }
}
