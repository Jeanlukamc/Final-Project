//import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.JPanel;

public class Map 
{    
    private GUI gameplayGUI;
	private final String myPath = "sand.png";
    
    /**
     * Creates the map of the game
     * @param xMapSize Base
     * @param yMapSize Height
     * @param tileSize Size of each tile
     * @param gameplayGUI The GUI itself
     */
    public Map( int xMapSize, int yMapSize, int tileSize, GUI gameplayGUI )
    {
        this.gameplayGUI = gameplayGUI;
        
        for ( int locY = 0; locY < yMapSize; locY += tileSize  )
        {
            for ( int locX = 0; locX < xMapSize; locX += tileSize )
            {
                try
                {
                    drawFloor( tileSize, tileSize, locX, locY, myPath );
                }
                catch ( IOException ioe )
                {
                    System.out.println("Could not load floor image");
                    System.exit( 0 );
                }
            }
        }
    }
    
    /**
     * Draws the floor on the background of the GUI
     * @param xSize Base
     * @param ySize Height
     * @param locX X-Coordinate
     * @param locY Y-Coordinate
     * @param path Image associated with the floor tile
     * @throws IOException Failed to execute
     */
    private void drawFloor( int xSize, int ySize, int locX, int locY, String path ) throws IOException
    {
		
        //Make a new tile for the background
        JLabel temp = new JLabel( );
        temp.setSize(xSize, ySize);
        temp.setLocation( locX, locY );
        
		//Set the image related to the tile
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(temp.getWidth(), temp.getHeight(), Image.SCALE_SMOOTH);
        
		//Make the appropiate JLabel to add to the background 
		JLabel floor = new JLabel( new ImageIcon( scaledImage ) );
		
		//Set its size and location on the GUI
		floor.setSize(xSize, ySize);
        floor.setLocation( locX, locY );
		
		//Add to the background
        gameplayGUI.addBackgroundLabel(floor);      
    }  
}
