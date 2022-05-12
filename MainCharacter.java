import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.awt.event.KeyListener;

public class MainCharacter extends Character
{
	private GUI game;
	private KeyStroke keyboardEvents;
	private String collisionDirection;
	private ArrayList<Misc> objects;
		
	private final String AnimationsFolder = "MCAs";
	private final int folderItems = 13;
		
	private int upAnimationCounter = 0; 
	private int downAnimationCounter = 0; 
	private int leftAnimationCounter = 0; 
	private int rightAnimationCounter = 0; 
	private int upRightAnimationCounter = 0;
	private int downRightAnimationCounter = 0;
	private int upLeftAnimationCounter = 0;
	private int downLeftAnimationCounter = 0;
	
	private String lastKeysPressed = "";
        
	/**
	 * Creates the Main Character
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param speed How Fast it moves
	 * @param health How much health it will have
	 * @param game The GUI itself
	 * @param keyboardEvents Making use of the KeyBoard
	 */
	
	public MainCharacter( int x, int y, int size, int speed, int health, ArrayList<Character> list, ArrayList<Misc> objects, GUI game, KeyStroke keyboardEvents ) 
	{
		super( x, y, size, speed, health, list, objects, ( "MCAs\\MCTS\\up\\1.png" ) );
		           
		this.keyboardEvents = keyboardEvents;
		this.game = game;
		this.collisionDirection = "";
		this.objects = objects;
	}
	
	/**
     * Move Character
     * @param listofCharacters The List of Characters
     */
	public void MoveCharacter( ArrayList<Character> listofCharacters )
    {
        if (keyboardEvents.isOnlyTwoKeysPressed()){
            if ( keyboardEvents.getKey_W_Status() && keyboardEvents.getKey_D_Status() == true ){
                int newXPos = ReturnPosition( ).GetX( ) + GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( ) - GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos )){
                    Move( newXPos, newYPos, "upRight" );
                    lastKeysPressed = "dw";
                }
            }
            if ( keyboardEvents.getKey_W_Status() && keyboardEvents.getKey_A_Status() == true ){
                int newXPos = ReturnPosition( ).GetX( ) - GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( ) - GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos )){
                    Move( newXPos, newYPos, "upLeft" );
                    lastKeysPressed = "aw";
                }
            }
            if ( keyboardEvents.getKey_S_Status() && keyboardEvents.getKey_D_Status() == true ){
                int newXPos = ReturnPosition( ).GetX( ) + GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( ) + GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos )){
                    Move( newXPos, newYPos, "downRight" );
                    lastKeysPressed = "ds";
                }
            }
            if ( keyboardEvents.getKey_S_Status() && keyboardEvents.getKey_A_Status() == true ){
                int newXPos = ReturnPosition( ).GetX( ) - GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( ) + GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos )){
                    Move( newXPos, newYPos, "downLeft" );
                    lastKeysPressed = "as";
                }
            }
        }
        if (keyboardEvents.isOnlyOneKeyPressed()){
            if (keyboardEvents.getKey_W_Status() ){
                int newXPos = ReturnPosition( ).GetX( );	
                int newYPos = ReturnPosition( ).GetY( ) - GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects( ), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos ))
                {
                    Move( newXPos, newYPos, "up" );
                    lastKeysPressed = "w";
                } 
            } 
            if (keyboardEvents.getKey_S_Status() ){	
                int newXPos = ReturnPosition( ).GetX( );	
                int newYPos = ReturnPosition( ).GetY( ) + GetSpeed( );
                if( !ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos ))
                {
                    Move( newXPos, newYPos, "down" );
                    lastKeysPressed = "s";
                } 
            }
            if (keyboardEvents.getKey_A_Status() ){
                int newXPos = ReturnPosition( ).GetX( ) - GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( );	
                if(!ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos ))
                {
                    Move( newXPos, newYPos, "left" );
                    lastKeysPressed = "a";
                } 
            }
            if (keyboardEvents.getKey_D_Status() ){
                int newXPos = ReturnPosition( ).GetX( ) + GetSpeed( );	
                int newYPos = ReturnPosition( ).GetY( );		
                if(!ReturnCollision().CheckObjStatus(ReturnListofObjects(), this.ReturnCharacterJLabel().getBounds(), newXPos, newYPos ))
                {
                    Move( newXPos, newYPos, "right" );
                    lastKeysPressed = "d";
                } 
            }
        }

        if ( keyboardEvents.getKey_SPACE_Status( ) )
        {
            ReturnListofObjects( ).add( new Bullet ( ReturnPosition( ).GetX( ), ReturnPosition( ).GetY( ), 10, 10, ReturnListofCharacteres( ), objects, "MCAs\\Bullet\\Bullet.png", lastKeysPressed, game ) );
        }
        
        if ( ! keyboardEvents.isAnyKeyPressed() ){
            switch ( lastKeysPressed ){
                case "w":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\up\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "s":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\down\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "a":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\left\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "d":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\right\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "dw":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\UpRight\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "aw":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\UpLeft\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "ds":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\DownRight\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
                case "as":{
                    game.removeJLabel( ReturnCharacterJLabel( ) );
                        SetImage( AnimationsFolder + "\\MCTS\\DownLeft\\0.png" );
                    game.addFrontLabel( ReturnCharacterJLabel( ) );
                    break;
                }
            }
        }
	}
	
	/**
	 * Moves the Character to a new position
	 * @param xPos New X-Coordinate
	 * @param yPos New Y-Coordinate
	 * @param path New Image to associate it with
	 */
	private void Move( int xPos, int yPos, String direction )
	{
		position.setCoordinates( xPos, yPos );
		
		game.removeJLabel( ReturnCharacterJLabel( ) );
		game.removeJLabel( ReturnHealthJL( ) );
		
		// Animations
		switch( direction )
		{
			case "up":
			{
				SetImage( AnimationsFolder + "\\MCTS\\up\\" + String.valueOf(upAnimationCounter % folderItems) + ".png" );
				upAnimationCounter++;
				break;
			}
			case "down":
			{
				SetImage( AnimationsFolder + "\\MCTS\\down\\" + String.valueOf(downAnimationCounter % folderItems) + ".png");
				downAnimationCounter++;
				break;
			}
			case "left":
			{
				SetImage( AnimationsFolder + "\\MCTS\\left\\" + String.valueOf(leftAnimationCounter % folderItems) + ".png");
				leftAnimationCounter++;
				break;
			}
			case "right":
			{
				SetImage( AnimationsFolder + "\\MCTS\\right\\" + String.valueOf(rightAnimationCounter % folderItems) + ".png" );
				rightAnimationCounter++;
				break;					
			}
			case "upRight":
			{
				SetImage( AnimationsFolder + "\\MCTS\\UpRight\\" + String.valueOf(upRightAnimationCounter % folderItems) + ".png" );
				upRightAnimationCounter++;
				break;	
			}
			case "upLeft":
			{                    
				SetImage( AnimationsFolder + "\\MCTS\\UpLeft\\" + String.valueOf(upLeftAnimationCounter % folderItems) + ".png" );
				upLeftAnimationCounter++;
				break;
			}
			case "downRight":
			{
				SetImage( AnimationsFolder + "\\MCTS\\DownRight\\" + String.valueOf(downRightAnimationCounter % folderItems) + ".png" );
				downRightAnimationCounter++;
				break;
			}
			case "downLeft":
			{
				SetImage( AnimationsFolder + "\\MCTS\\DownLeft\\" + String.valueOf(downLeftAnimationCounter % folderItems) + ".png" );
				downLeftAnimationCounter++;
				break;
			}      
		}
		GetHealth( ).SetHealth( GetHealth( ).ReturnHealthPath( ) );
		game.addFrontLabel( ReturnCharacterJLabel( ) );
		game.addAboveAll( ReturnHealthJL( ) );
	}
}