import java.util.ArrayList;

public class Wall extends Misc
{
	private ArrayList<Misc> objectArr;
	private ArrayList<Character> characters;
	private String path;
	
    /**
     * Create the Wall and place it on the GUI
     * @param x X-Coordinate
     * @param y Y-Coordinate
     * @param size Size of the Wall
     * @param list The List of characters
     * @param imgPath Path to the image corresponding to the Wall
     */
    public Wall( int xPos, int yPos, int base, int height, ArrayList<Character> list, String path )
    {
        super( xPos, yPos, base, height, list, path );
    }
	

	/**
	 * Places the walls on specific positions
	 * @param xPos X-Coordinate
	 * @param yPos Y-Coordinate
	 * @param objectArr List of Objects
	 * @param characters List of Characters
	 * @return
	 */
	public ArrayList<Misc> placeWalls( int xPos, int yPos, ArrayList<Misc> objectArr, ArrayList<Character> characters ) 
	{
		this.objectArr = objectArr;
		this.characters = characters;
		
		Up( xPos, yPos );
		Down( xPos - 150, yPos - 900 );
		
		Up( xPos - 810, yPos + 100 );
		Down( xPos - 660, yPos - 800 );
		
		Right( xPos - 800, yPos );
		Right ( xPos - 800, yPos - 700 );
				
		return objectArr;
	}
	
	/**
	 * Build walls upwards
	 * @param xPos X-Coordinate start
	 * @param yPos Y-Coordinate start
	 */
	private void Up( int xPos, int yPos ) 
	{
		for ( int i = 0; i < 14; i++ ) 
		{
			yPos -= 80;
			objectArr.add( new Wall( xPos, yPos, 20, 80, characters, "MCAs\\Walls\\WallVertical.png" ) );
		}
	}
	
	/**
	 * Build walls downwards
	 * @param xPos X-Coordinate start
	 * @param yPos Y-Coordinate start
	 */
	private void Down( int xPos, int yPos )
	{
		for ( int i = 0; i < 12; i++ )
		{		
			if ( i == 6 ) {
				yPos += 100;
				continue;
			}
			objectArr.add( new Wall( xPos, yPos, 20, 80, characters, "MCAs\\Walls\\BWire.png" ) );
			yPos += 80;
		}
	}
	
	/**
	 * Build walls to the left
	 * @param xPos X-Coordinate start
	 * @param yPos Y-Coordinate start
	 */
	private void Left( int xPos, int yPos ) 
	{
		for ( int i = 0; i < 10; i++ )
		{	
			objectArr.add( new Wall( xPos, yPos, 80, 20, characters, "MCAs\\Walls\\BWire.png" ) );
			xPos += 80;

		}
	}
	
	/**
	 * Build walls to the left
	 * @param xPos X-Coordinate start
	 * @param yPos Y-Coordinate start
	 */
	private void Right( int xPos, int yPos ) 
	{
		for ( int i = 0; i < 10; i++ )
		{	
			objectArr.add( new Wall( xPos, yPos, 80, 20, characters, "MCAs\\Walls\\BWireH.png" ) );
			xPos += 80;

		}
	}
}
