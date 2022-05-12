import javax.swing.*;                 
import java.awt.Image;
import java.util.ArrayList;
//import java.io.IOException;

public abstract class Character
{
	protected XYCoordinates position;
	private ArrayList<Character> listOfCharacters;
	private ArrayList<Misc> listOfObjects;
	private JLabel character;
	private JLabel addOn;
	private int speed;
	private Health characterHealth;
	private int size;
	private Collision status;

	/**
	* Default Constructor for a character
	* @param x X-Coordinate
	* @param y Y-Coordinate
	* @param size How big it will be in the map
	* @param speed How fast it will move as the game goes
	* @param health How much health the character has
	* @param imgPath Image related to the character
	*/
	public Character( int x, int y, int size, int speed, int health, ArrayList<Character> list, ArrayList<Misc> objects, String imgPath )  
	{
		this.size = size;
		this.speed = speed;
		this.listOfCharacters = list;
		this.listOfObjects = objects;
		position = new XYCoordinates( x, y );
		this.characterHealth = new Health( health, position );
		status = new Collision( );

		SetImage( imgPath );
	}
	
    /**
	* Constructor with Parameters
	* @param x X-Coordinate
	* @param y Y-Coordinate
	* @param size How big it will be in the map
	* @param speed How fast it will move as the game goes
	* @param imgPath Image related to the character
	* @param String path for character
	*/
	public Character( int x, int y, int size, int speed, ArrayList<Character> list, ArrayList<Misc> objects, String imgPath )  
	{
		this.size = size;
		this.speed = speed;
		this.listOfCharacters = list;
		this.listOfObjects = objects;
		position = new XYCoordinates( x, y );
		this.characterHealth = new Health( position );
		status = new Collision( );

		SetImage( imgPath );
	}

	/**
	* Add the corresponding Image
	* @param path The New Image of the character
	*/
	public void SetImage( String path )
	{ 
		JLabel temp = new JLabel( ); 
		temp.setSize( size, size );
		temp.setLocation( position.GetX( ), position.GetY( ) );
			
		ImageIcon icon = new ImageIcon( path );
		Image image = icon.getImage( );
		Image scaledImage = image.getScaledInstance( temp.getWidth( ), temp.getHeight( ), Image.SCALE_SMOOTH );

		character = new JLabel( new ImageIcon( scaledImage ) );
		character.setSize( size, size );

		character.setLocation( position.GetX( ), position.GetY( ) );
	}

	/**
	* Sets a new Speed for the character
	* @param newSpeed The new Speed
	*/
	public void SetSpeed( int newSpeed ) { speed = newSpeed; }

	/**
	* Returns the Speed of the character
	* @return The Speed
	*/
	public int GetSpeed( ) { return speed; }
	
	public Health GetHealth( ) { return characterHealth; }

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
	public ArrayList<Character> ReturnListofCharacteres( ){ return( this.listOfCharacters ); }

	/**
	 * Returns the list of Objects
	 * @return Array List
	 */
	public ArrayList<Misc> ReturnListofObjects( ){ return( this.listOfObjects ); }
	
	/**
	* Return the JPanel Corresponding to the character
	* @return JLabel
	*/
	public JLabel ReturnCharacterJLabel( ) { return this.character; }

	/**
	 * Return the corresponding addon
	 * @return JLabel
	 */
	public JLabel ReturnAddOnJLabel( ) { return this.addOn; }
	
	/**
	* Return the corresponding size
	* @return Int
	*/
	public int ReturnSize( ) { return this.size; }
	
	public JLabel ReturnHealthJL( ) { return this.characterHealth.ReturnHealthJL( ); } 
	
	/**
	* Abstract Method
	*/
	public abstract void MoveCharacter( ArrayList<Character> listofCharacters );
}