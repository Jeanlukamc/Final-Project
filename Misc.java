//Miscallenous Objects Class
import javax.swing.*;                 
import java.awt.Image;
import java.util.ArrayList;

public abstract class Misc 
{
    protected XYCoordinates position;
    private ArrayList<Character> listofCharacters;
    private JLabel object;
    private int base, height;
	private Collision status;

    /**
     * Create the object and place it on the GUI
     * @param x X-Coordinate
     * @param y Y-Coordinate
     * @param size Size of the Object
     * @param list The List of characters
     * @param imgPath Path to the image corresponding to the object
     */
    public Misc( int x, int y, int base, int height, ArrayList<Character> list, String imgPath )
    {
        this.position = new XYCoordinates( x, y );
        this.base = base;
        this.height = height;
        this.listofCharacters = list;
        this.status = new Collision( );

        SetImage( imgPath );
    }

    /**
	* Add the corresponding Image
	* @param path The New Image of the character
	*/
	public void SetImage( String path )
	{ 
        JLabel temp = new JLabel( ); 
		temp.setSize( base, height );
		temp.setLocation( position.GetX( ), position.GetY( ) );
			
		ImageIcon icon = new ImageIcon( path );
		Image image = icon.getImage( );
		Image scaledImage = image.getScaledInstance( temp.getWidth( ), temp.getHeight( ), Image.SCALE_SMOOTH );

        object = new JLabel( new ImageIcon( scaledImage ) );
        object.setSize( base, height );
		
		object.setLocation( position.GetX( ), position.GetY( ) );
    }

    /**
	* Return the Position you are at
	* @return The Position
	*/
	public XYCoordinates ReturnPosition( ) { return this.position; }

    /**
	 * Returns its Collision 
	 * @return Collision
	 */
	public Collision ReturnCollision( ) { return( status.ReturnCollision( ) ); }

    /**
	 * Returns the list of characters
	 * @return Array List
	 */
	public ArrayList<Character> ReturnListofCharacters(){ return( this.listofCharacters ); }
	
    /**
	* Return the JPanel Corresponding to the Object
	* @return JLabel
	*/
	public JLabel ReturnMiscJLabel( ) { return this.object; }
	
	/**
	* Return the base corresponding to the object
	* @return Int
	*/
	public int ReturnBase( ) { return this.base; }
	
	/**
	* Return the height corresponding to the object
	* @return Int
	*/
	public int ReturnHeight( ) { return this.height; }
}
