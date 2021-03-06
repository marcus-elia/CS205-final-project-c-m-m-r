import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Chariot extends Piece
{

    public Chariot(GameManager inputManager, Point inputCenter, BoardPoint inputLocation, Team inputTeam)
    {
        super(inputManager, inputCenter, inputLocation);
        team = inputTeam;
        if(team == Team.Player)
        {
            symbolColor = new Color(0.1f, 0.4f, 0.8f);
        }
        else
        {
            symbolColor = new Color(0.8f, 0.1f, 0.4f);
        }
        fillColor = Color.WHITE;
        pieceType = PieceType.Chariot;
        this.initializeOctagon();
    }


    @Override
    public void tick()
    {

    }


    // =============================================
    //
    //              Drawing the Chariot
    //
    // =============================================


    @Override
    public void render(Graphics2D g2d)
    {
        // Draw the octagon
        g2d.setColor(fillColor);
        g2d.fill(outline);


        BufferedImage img = null;
        try {
            //Create BufferedImage object by reading from file
            if(this.getTeam()==Team.Computer){
                img = ImageIO.read(new File("./src/Images/ChariotRookRed.png"));
            }
            else {
                img = ImageIO.read(new File("./src/Images/ChariotRookGreen.png"));
            }

        } catch (IOException e) {
            System.out.println("no img found");
        }
        g2d.drawImage(img, (int)this.center.x -20, (int)center.y - 20, null);
    }


    @Override
    public ArrayList<BoardPoint> findTargetingSquares(Piece[][] hypotheticalBoard)
    {
        ArrayList<BoardPoint> output = new ArrayList<BoardPoint>();
        int i = location.getX();
        int j = location.getY();

        // Check for moves to the right
        if(i < 8)
        {
            // Checks all spaces to the right of piece adding empty spaces to targetingSquares until reaches
            // another piece. Adds that space, then stops loop
            for(int index = i+1; index <= 8; index++)
            {
                output.add(new BoardPoint(index, j));
                if(hypotheticalBoard[index][j] != null)
                {
                    index = 8;
                }
            }
        }

        // Check for moves to the left
        if(i > 0)
        {
            // Checks all spaces to the left of piece adding empty spaces to targetingSquares until reaches
            // another piece. Adds that space, then stops loop
            for(int index = i-1; index >= 0; index--)
            {
                output.add(new BoardPoint(index, j));
                if(hypotheticalBoard[index][j] != null)
                {
                    index = -1;
                }
            }
        }

        // Check for moves down
        if(j < 9)
        {
            // Checks all spaces to below the piece adding empty spaces to targetingSquares until reaches
            // another piece. Adds that space, then stops loop
            for(int index = j+1; index <= 9; index++)
            {
                output.add(new BoardPoint(i, index));
                if(hypotheticalBoard[i][index] != null)
                {
                    index = 9;
                }
            }
        }

        // Check for moves up
        if(j > 0)
        {
            // Checks all spaces above the piece adding empty spaces to targetingSquares until reaches
            // another piece. Adds that space, then stops loop
            for(int index = j-1; index >= 0; index--)
            {
                output.add(new BoardPoint(i, index));
                if(hypotheticalBoard[i][index] != null)
                {
                    index = -1;
                }
            }
        }

        // Palace cases for blue side
        // Chariot in bottom left
        if(i == 3 && j == 9)
        {
            output.add(new BoardPoint(4, 8));
            if(hypotheticalBoard[4][8] == null)
            {
                output.add(new BoardPoint(5, 7));
            }
        }
        // Chariot in bottom right
        if(i == 5 && j == 9)
        {
            output.add(new BoardPoint(4, 8));
            if(hypotheticalBoard[4][8] == null)
            {
                output.add(new BoardPoint(3, 7));
            }
        }
        // Chariot in top left
        if(i == 3 && j == 7)
        {
            output.add(new BoardPoint(4, 8));
            if(hypotheticalBoard[4][8] == null)
            {
                output.add(new BoardPoint(5, 9));
            }
        }
        // Chariot in top right
        if(i == 5 && j == 7)
        {
            output.add(new BoardPoint(4, 8));
            if(hypotheticalBoard[4][8] == null)
            {
                output.add(new BoardPoint(3, 9));
            }
        }
        // Chariot in center
        if(i == 4 && j == 8)
        {
            output.add(new BoardPoint(3, 9));
            output.add(new BoardPoint(5, 9));
            output.add(new BoardPoint(3, 7));
            output.add(new BoardPoint(5, 7));
        }

        // Palace cases for red side
        // Chariot in top left
        if(i == 3 && j == 0)
        {
            output.add(new BoardPoint(4, 1));
            if(hypotheticalBoard[4][1] == null)
            {
                output.add(new BoardPoint(5, 2));
            }
        }
        // Chariot in top right
        if(i == 5 && j == 0)
        {
            output.add(new BoardPoint(4, 1));
            if(hypotheticalBoard[4][1] == null)
            {
                output.add(new BoardPoint(3, 2));
            }
        }
        // Chariot in bottom left
        if(i == 3 && j == 2)
        {
            output.add(new BoardPoint(4, 1));
            if(hypotheticalBoard[4][1] == null)
            {
                output.add(new BoardPoint(5, 0));
            }
        }
        // Chariot in bottom right
        if(i == 5 && j == 2)
        {
            output.add(new BoardPoint(4, 1));
            if(hypotheticalBoard[4][1] == null)
            {
                output.add(new BoardPoint(3, 0));
            }
        }
        // Chariot in center
        if(i == 4 && j == 1)
        {
            output.add(new BoardPoint(3, 0));
            output.add(new BoardPoint(3, 2));
            output.add(new BoardPoint(5, 0));
            output.add(new BoardPoint(5, 2));
        }
        return output;
    }
}
