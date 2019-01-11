package newstuff;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MainMenu extends AppView {
    public MainMenu() {
        super();
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, App.width, App.height);
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        App.setCurrent(App.game);
    }
}
