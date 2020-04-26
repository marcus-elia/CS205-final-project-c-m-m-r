import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StartScreen
{
    // ===============================

    private GameManager manager;
    private int windowWidth;
    private int windowHeight;

    private RectangularButton startButton;

    // ===============================
    // Variables for drawing
    private int lineWidth;
    private int pointRadius;
    /*private int buttonX;
    private int buttonY;
    private int buttonWidth;
    private int buttonHeight;*/

    // ===============================
    RoundRectangle2D buttonVisual;
    private final Color txtColor = new Color(45,58,98);
    private final Color bgColor =  new Color(128,178,245);
    //private final Color buttonColor = new Color(247,183,109);

    String gameName = "Janggi";
    //String buttonText = "Start Game";

    Color paleOrange = new Color(239, 164, 103);
    Color paleBlue = new Color(159, 208, 255);
    Color deepBlue = new Color(45, 58, 98);
    Color faded = new Color(170,170,170);


    public StartScreen(GameManager inputManager)
    {
        manager = inputManager;
        windowWidth = (int)manager.getWidth();
        windowHeight = (int)manager.getHeight();

        startButton = new RectangularButton(manager,
                (int)windowWidth/2 - windowWidth/8,
                (int)(windowHeight/2),
                windowWidth/4, windowHeight/8,
                paleOrange, paleOrange, faded, "Start Game");

        lineWidth = 8;
        pointRadius = 10;
    }


    // ===============================
    //
    //       Drawing the Screen
    //
    // ===============================
    public void render(Graphics2D g2d)
    {

        // ==============BACKGROUND=================
        g2d.setColor(new Color(75,125,191));
        g2d.fillRect(0, 0, windowWidth, windowHeight);

        g2d.setColor(paleBlue);
        int centerWidth = (int)(.98 * windowWidth);
        int centerHeight = (int)(.96 * windowHeight);
        int centerX = windowWidth/2 - centerWidth/2;
        int centerY = windowHeight/2 - centerHeight/2;
        g2d.fillRect(centerX, centerY, centerWidth, centerHeight);

        // ==============FONT=================
        Font font = new Font("Helvetica", Font.PLAIN, 54);
        FontMetrics metrics = g2d.getFontMetrics(font);

        //Font smallerFont = new Font("Helvetica", Font.PLAIN, 40);
        //FontMetrics smallerMetrics = g2d.getFontMetrics(smallerFont);

        // ==================ICONS DECORATION====================

        BufferedImage img = null;

        //Graphics2d object.drawImage(Image object, x coord, y coord, idk but set null)
        try {
            /*
            img = ImageIO.read(new File("./src/Images/ChariotRookRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .9), null);
            img = ImageIO.read(new File("./src/Images/ChariotRookGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .9), null);

             */

            img = ImageIO.read(new File("./src/Images/HorseRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .8), null);
            img = ImageIO.read(new File("./src/Images/HorseGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .8), null);

            img = ImageIO.read(new File("./src/Images/ElephantRed2.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .7), null);
            img = ImageIO.read(new File("./src/Images/ElephantGreen2.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .7), null);

            img = ImageIO.read(new File("./src/Images/GuardRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .6), null);
            img = ImageIO.read(new File("./src/Images/GuardGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .6), null);

            //

            img = ImageIO.read(new File("./src/Images/KingRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .5), null);
            img = ImageIO.read(new File("./src/Images/KingGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .5), null);

            //

            img = ImageIO.read(new File("./src/Images/GuardRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .4), null);
            img = ImageIO.read(new File("./src/Images/GuardGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .4), null);

            img = ImageIO.read(new File("./src/Images/ElephantRed2.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .3), null);
            img = ImageIO.read(new File("./src/Images/ElephantGreen2.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .3), null);

            img = ImageIO.read(new File("./src/Images/HorseRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .2), null);
            img = ImageIO.read(new File("./src/Images/HorseGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .2), null);

            /*
            img = ImageIO.read(new File("./src/Images/ChariotRookRed.png"));
            g2d.drawImage(img,windowWidth/8, (int)(windowHeight * .1), null);
            img = ImageIO.read(new File("./src/Images/ChariotRookGreen.png"));
            g2d.drawImage(img,7 * windowWidth/8 - 40, (int)(windowHeight * .1), null);

             */

        } catch (IOException e) {
            System.out.println("no img found");
        }



        // ==============WINDOW POSITION=================
        int titleX = (int) (windowWidth / 2 - metrics.getStringBounds(gameName,null).getWidth()/2);
        int titleY = windowHeight / 4;

        //buttonWidth = (int) (windowWidth * .25);
        //buttonHeight = (int) (windowHeight * .20);

        // ==============BUTTON POSITION=================
        //buttonX = windowWidth / 2 - buttonWidth/2;
        //buttonY = windowHeight * 6 / 10;

        //
        // ==============DRAW TITLE=================
        g2d.setFont(font);
        g2d.setColor(txtColor);
        g2d.drawString(gameName, titleX, titleY);

        // ==============DRAW BUTTON=================
        /*g2d.setFont(smallerFont);
        g2d.setColor(buttonColor);
        buttonVisual = new RoundRectangle2D.Double(buttonX, buttonY, buttonWidth, buttonHeight, 45, 45);

        g2d.fill( buttonVisual);*/
        startButton.render(g2d);



        // ==============DRAW TEXT IN BUTTON=================
        /*g2d.setFont(smallerFont);
        g2d.setColor(Color.white);

        int stringPosX = (int) (buttonVisual.getMinX() + buttonVisual.getWidth()/2
                - smallerMetrics.getStringBounds(buttonText,null).getWidth()/2);

        int stringPosY = (int) (buttonVisual.getMinY() + buttonVisual.getHeight()/2
                - smallerMetrics.getHeight()/8);

        g2d.drawString(buttonText,stringPosX,stringPosY);*/

        // ==============DRAW CAPTION TEXT=================
        Font captionFont = new Font("Helvetica", Font.PLAIN, 14);
        FontMetrics metrics2 = g2d.getFontMetrics(captionFont);

        String captionTxt1 = "Capture the computer's general to win!";
        String captionTxt2 = "Click on a piece to see available moves.";
        String captionTxt3 = "(It's ok if you don't already know the rules, our system will help you.)";
        int captionX = (int) (windowWidth / 2 - metrics2.getStringBounds(captionTxt1,null).getWidth()/2);
        int captionX2 = (int) (windowWidth / 2 - metrics2.getStringBounds(captionTxt2,null).getWidth()/2);
        int captionX3 = (int) (windowWidth / 2 - metrics2.getStringBounds(captionTxt3,null).getWidth()/2);
        int captionY = windowHeight * 8 / 10;


        g2d.setFont(captionFont);
        g2d.setColor(txtColor);
        g2d.drawString(captionTxt1, captionX, captionY);
        g2d.drawString(captionTxt2, captionX, captionY + 25);
        g2d.drawString(captionTxt3, captionX3, captionY + 50);
    }

    public boolean buttonPress(int mx, int my)
    {
        /*if(mx >= buttonX && mx <= buttonX + buttonWidth && my >= buttonY && my <= buttonY + buttonHeight){
            return true;
        } else {
            return false;
        }*/
        return startButton.containsClick(mx, my);
    }

    public void reactToMouseMotion(int mx, int my)
    {
        startButton.reactToMouseMotion(mx, my);
    }

    // Getters
    public int getWindowWidth()
    {
        return windowWidth;
    }
    public int getWindowHeight()
    {
        return windowHeight;
    }

}
