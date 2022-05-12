//import java.awt.Image;
import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//import java.lang.InterruptedException;

public class Zombie extends Character
{	
	private GUI game;
	
	private final int folderItems = 10;

	private int upAnimationCounter = 0; 
	private int downAnimationCounter = 0; 
	private int leftAnimationCounter = 0; 
	private int rightAnimationCounter = 0; 
	
	/**
	* Default constructor for the zombie class
	* @param x X-Coordinate
	* @param y Y-Coordinate
	* @param speed The Speed of the character
	* @param health The Health of the character
	* @param path The image associated to the zombie
	*/
	public Zombie( int x, int y, int size, int speed, ArrayList<Character> list, ArrayList<Misc> objects, GUI game )
	{
		super( x, y, size, speed, list, objects, ( "MCAs\\MZT\\Up\\Zombie00.png" ) ); 
		this.game = game;
	}

	/**
	* See which direction to go, in either X or Y direction
	* @param coordinate The coordinate of the main character
	* @param zombieCoordinate The coordinate of the zombie
	* @return How much we need to move certain coordinate
	*/
	private int Direction( int coordinate, int zombieCoordinate )
	{
        if ( coordinate == zombieCoordinate )
		{
			return( 0 );
		}
		
		//If the coordinate is larger than the zombie, increase
		else if ( coordinate > zombieCoordinate )
		{
			return( GetSpeed( ) );
		}
		
		//Else, decrease
		else
		{
			return( -GetSpeed( ) );
		}
	}
			
	/**
	* Moves the zombie to the position of the main character
	* @param listofCharacters All the characters in the list
	*/
	public void MoveCharacter( ArrayList<Character> listofCharacters )
	{
		String path;
		MainCharacter hostile = null;
		
		int hostileX = 0, hostileY = 0;
		int newX, newY;
		
		// We always know that the main character is the first array element, so we do not need the for loop 
		hostile = ( MainCharacter )listofCharacters.get( 0 );
		hostileX = hostile.ReturnPosition( ).GetX( );
		hostileY = hostile.ReturnPosition( ).GetY( );

		//Move the zombie to an optimal position, or stay still 
		newX = ReturnPosition( ).GetX( ) + Direction( hostileX, ReturnPosition( ).GetX( ) );
		newY = ReturnPosition( ).GetY( ) + Direction( hostileY, ReturnPosition( ).GetY( ) );
	
		//Change the position
		if ( !ReturnCollision( ).CheckObjStatus( ReturnListofObjects( ), this.ReturnCharacterJLabel( ).getBounds( ), newX, newY ) && 
			 !ReturnCollision( ).CheckCharStatus( ReturnListofCharacteres( ), this, newX, newY ) )
		{
			ReturnPosition( ).setCoordinates( newX, newY );
		}
		
		if ( hostileX > newX )
		{
			path = "MCAs\\MZT\\Right\\Zombie0" + String.valueOf( rightAnimationCounter % folderItems ) + ".png";
			rightAnimationCounter++;
		}
		else if ( hostileX < newX )
		{
			path = "MCAs\\MZT\\Left\\Zombie0" + String.valueOf( leftAnimationCounter % folderItems ) + ".png";
			leftAnimationCounter++;
		}
		else if ( hostileY < newY )
		{
			path = "MCAs\\MZT\\Up\\Zombie0" + String.valueOf( downAnimationCounter % folderItems ) + ".png";
			downAnimationCounter++;
		}	
		else
		{
			path = "MCAs\\MZT\\Down\\Zombie0" + String.valueOf( upAnimationCounter % folderItems ) + ".png";
			upAnimationCounter++;
		}
		
		game.removeJLabel( ReturnCharacterJLabel( ) );
		game.removeJLabel( ReturnHealthJL( ) );
		
		GetHealth( ).SetHealth( GetHealth().ReturnHealthPath() );
		game.addAboveAll( ReturnHealthJL( ) );
		
		SetImage( path );
		game.addFrontLabel( ReturnCharacterJLabel( ) );	
	}
}  