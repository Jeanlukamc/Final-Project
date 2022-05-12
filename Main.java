import java.util.ArrayList;

public class Main 
{
	private GUI displayGame;
	private ArrayList<Character> characters;
	private ArrayList<Misc> objects;
	private MainCharacter mainCharacter;

	/**
	 * Work Method : Creates the flow of the game
	 */
	public Main( )
	{
		displayGame = new GUI( 900, 900 );
		characters = new ArrayList< Character >( );
		objects = new ArrayList< Misc >( );
		
		Map map = new Map( 900, 900, 50, displayGame );

		// Change size parameter to xsize and ysize 
		mainCharacter = new MainCharacter( 800, 680, 30, 6, 2400, characters, objects, displayGame, displayGame.GetKeyStroke());
		Zombie zombie = new Zombie( 250, 100, 30, 2, characters, objects, displayGame );
		Zombie zombie2 = new Zombie( 400, 100, 30, 2, characters, objects, displayGame );
		Zombie zombie3 = new Zombie( 250, 500, 30, 2, characters, objects, displayGame );
		Zombie zombie4 = new Zombie( 400, 300, 30, 2, characters, objects, displayGame );
		Zombie zombie5 = new Zombie( 600, 600, 30, 2, characters, objects, displayGame );
		Zombie zombie6 = new Zombie( 560, 400, 30, 2, characters, objects, displayGame );
		Zombie zombie7 = new Zombie( 360, 400, 30, 2, characters, objects, displayGame );
		Zombie zombie8 = new Zombie( 300, 560, 30, 2, characters, objects, displayGame );
		Zombie zombie9 = new Zombie( 250, 700, 30, 2, characters, objects, displayGame );
		Zombie zombie10 = new Zombie( 450,700, 30, 2, characters, objects, displayGame );
		
		characters.add( mainCharacter );
		characters.add( zombie );
		characters.add( zombie2 );
		characters.add( zombie3 );
		characters.add( zombie4 );
		characters.add( zombie5 );
		characters.add( zombie6 );
		characters.add( zombie7 );
		characters.add( zombie8 );
		characters.add( zombie9 );
		characters.add( zombie10 );


		for ( Character ch : characters )
			displayGame.addAboveAll( ch.ReturnHealthJL( ) );

		displayGame.addFrontLabel( mainCharacter.ReturnCharacterJLabel( ) );
		
		Wall wall = new Wall( 850, 747, 20, 80, characters, "MCAs\\Walls\\WallVertical.png" );
		objects.add( wall );
				
		objects = wall.placeWalls( 850, 747, objects, characters );
		for ( Misc obj : objects )
		{	
			displayGame.addFrontLabel( obj.ReturnMiscJLabel( ) );			
		}
		
		Controller CON = new Controller( characters, objects, displayGame );
	}
}


