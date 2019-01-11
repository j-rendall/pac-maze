package newstuff;

import java.awt.*;
import java.awt.event.MouseEvent;

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
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        if (mouseEvent.getX() > 0 && mouseEvent.getX() < 60 && mouseEvent.getY() > 0 && mouseEvent.getY() < 60) {
            App.setCurrent(App.main);
        }
    }
}
