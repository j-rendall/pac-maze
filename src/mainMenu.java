import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class mainMenu {
    private int clickX = 0;
    private int clickY = 0;
    public boolean play = false;
    public boolean intsruction = false;
    private BufferedImage img = null;

    public mainMenu() {

//        public void mouseClicked(MouseEvent mouseEvent) {
//            clickX = mouseEvent.getX();
//            clickY = mouseEvent.getY();
//        }

        try {
            img = ImageIO.read(new File("res\\pacmanlogo.png"));
        } catch (IOException e) {
            System.out.println("image not found");
        }
    }

    public void move(int maxWidth) {
//        // if the car hits the edge of the screen... reverse the x velocity
//        if ((x + xa < -50) || (x + xa > cs.getWidth() + 50)) {
//            xa *= -1;
//            width *= -1;
//        }
//        //update x
//        x = x + xa;
    }

    public void paint(Graphics2D g2d) {
        String title = "Pa     Maze";
        Font stringFont1 = new Font( "Arial", Font.ITALIC, 80 );
        String play = "PLAY";
        Font stringFont2 = new Font( "Arial", Font.PLAIN, 70 );
        String settings = "SETTINGS";
        Font stringFont3 = new Font( "Arial", Font.PLAIN, 36 );

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.drawImage(img, 250, 200, 100, 60, null);
        g2d.setFont(stringFont1);
        g2d.setColor(Color.black);
        g2d.drawString(title, 150, 250);
        g2d.setColor(Color.white);
        g2d.drawString(title, 155, 255);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(255, 405, 200, 75);
        g2d.fillRect(255, 505, 200, 50);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(250, 400, 200, 75);
        g2d.fillRect(250, 500, 200, 50);

        g2d.setFont(stringFont2);
        g2d.setColor(Color.decode("#ffda4f"));
        g2d.drawString(play, 260, 465);
        g2d.setFont(stringFont3);
        g2d.drawString(settings, 260, 540);
    }
}