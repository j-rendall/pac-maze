import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class mainMenu {
    private int x = 0;
    private int y = 0;
    private BufferedImage img = null;

    public mainMenu() {
//        this.x = x;
//        this.y = y;
        try {
            img = ImageIO.read(new File("res\\pacmanlogo.png"));
        } catch (IOException e) {
            System.out.println("image not found");
            // hi
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

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.drawImage(img, 250, 200, 100, 60, null);
        g2d.setFont(stringFont1);
        g2d.setColor(Color.white);
        g2d.drawString(title, 150, 250);
        g2d.setColor(Color.black);
        g2d.drawString(title, 155, 255);

       // g2d.drawRect();
    }
}