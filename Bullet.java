import java.util.ArrayList;

public class Bullet extends Misc
{
    private GUI game;
    private int bulletSpeed;
    private String direction;
	private ArrayList<Misc> objects;

    /**
     * Constructor for the bullet
     * @param x X-Position
     * @param y Y-Position
     * @param base Base 
     * @param height Height
     * @param list List of characters
     * @param path Image related to the bullet
     * @param direction Direction that bullet needs to move to
     * @param game GUI for movement
     */
    public Bullet( int x, int y, int base, int height, ArrayList<Character> list, ArrayList<Misc> objects, String path, String direction, GUI game )
    {
        super( x, y, base, height, list, path );
     
        this.bulletSpeed = 10;
        this.direction = direction;
        this.game = game;
		this.objects = objects;
    }

    /**
	* Moves the bullet depending on the direction set by the Main Character
	* @return Ourselves
	*/
    public Bullet MoveBullet( )
    {
        switch( direction )
        {
            case "w":
            {
				int newXPos = ReturnPosition( ).GetX( );	
                int newYPos = ReturnPosition( ).GetY( ) - bulletSpeed;

				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) )  
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					//
					return this;
				}
            }
            case "s":
            {
				int newXPos = ReturnPosition( ).GetX( );	
                int newYPos = ReturnPosition( ).GetY( ) + bulletSpeed;
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );					
					return this;
				}
            }
            case "a":
            {
                int newXPos = ReturnPosition( ).GetX( ) - bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( );
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
            }
            case "d":
            {
                int newXPos = ReturnPosition( ).GetX( ) + bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( );
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
            }
            case "aw":
            {
                int newXPos = ReturnPosition( ).GetX( ) - bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( ) - bulletSpeed;
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
            }
            case "dw":
            {
                int newXPos = ReturnPosition( ).GetX( ) + bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( ) - bulletSpeed;
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else 
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
            }
            case "as":
            {
                int newXPos = ReturnPosition( ).GetX( ) - bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( ) + bulletSpeed;
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
            }
            case "ds":
            {
                int newXPos = ReturnPosition( ).GetX( ) + bulletSpeed;	
                int newYPos = ReturnPosition( ).GetY( ) + bulletSpeed;
				
				if( !ReturnCollision( ).CheckBulletCharacterCollison( ReturnListofCharacters( ), objects, this, newXPos, newYPos, game ) ) 				
				{
					ReturnPosition( ).setCoordinates( newXPos, newYPos );
					game.removeJLabel( ReturnMiscJLabel( ) );
					SetImage( "MCAs\\Bullet\\Bullet.png" );
					game.addFrontLabel( ReturnMiscJLabel ( ) );
					return null;
				}
				else
				{
					game.removeJLabel( ReturnMiscJLabel( ) );
					return this;
				}
			}
        }		
		return null;
    }
}
