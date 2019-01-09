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
    public boolean settings = false;
    public boolean instructions = false;
    public boolean exit = false;
    public boolean menu = true;
    private BufferedImage img = null;
    private BufferedImage instructionsimg = null;
    private BufferedImage settingsimg = null;

    public mainMenu() {
        try {
            img = ImageIO.read(new File("res\\pacmanlogo.png"));
        } catch (IOException e) {
            System.out.println("logo not found");
        }
        try {
            instructionsimg = ImageIO.read(new File("res\\instructions.jpg"));
        } catch (IOException e) {
            System.out.println("instructions page not found");
        }
        try {
            settingsimg = ImageIO.read(new File("res\\settings.jpg"));
        } catch (IOException e) {
            System.out.println("settings page not found");
        }
    }

    public void mouseClicked(MouseEvent e) {
        clickX = e.getX();
        clickY = e.getY();
    }

    public boolean isMenu() {
        if (isPlay()) {
            if (clickX > 23 && clickX < 90 && clickY > 20 && clickY < 45) {
                menu = true;
                play = false;
            }
        }
        else if (isInstructions() || isSettings()) {
            if (clickX > 0 && clickX < 70 && clickY > 0 && clickY < 70) {
                menu = true;
                instructions = false;
                settings = false;
            }
        }
        return menu;
    }

    public boolean isPlay() {
        if (menu) {
            if (clickX > 260 && clickX < 460 && clickY > 300 && clickY < 475) {
                play = true;
                menu = false;
            }
        }
        return play;
    }

    public boolean isSettings() {
        if (menu) {
            if (clickX > 260 && clickX < 460 && clickY > 500 && clickY < 550) {
                settings = true;
                menu = false;
            }
        }
        return settings;
    }
    public boolean isInstructions() {
        if (menu) {
            if (clickX > 40 && clickX < 280 && clickY > 770 && clickY < 810) {
                instructions = true;
                menu = false;
            }
        }
        return instructions;
    }

    public boolean isExit() {
        if (isMenu()) {
            if (clickX > 615 && clickX < 705 && clickY > 770 && clickY < 810) {
                exit = true;
            }
        }
        if (isPlay()) {
            if (clickX>23 && clickX<90 && clickY>60 && clickY<85) {
                exit = true;
            }
        }
        return exit;
    }

    public void paint(Graphics2D g2d) {
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

        g2d.drawImage(img, 250, 200, 100, 60, null);
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

    public void settingsPaint(Graphics2D g2d) {
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

        g2d.drawImage(settingsimg, 0, 0, 766, 860, null);
    }

    public void instructionsPaint(Graphics2D g2d) {
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

        g2d.drawImage(instructionsimg, 0, 0, 766, 890, null);
    }
}