import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Controller implements ActionListener
{
    private final int DELAY = 1;
    private GUI gameplayGUI;
    private ArrayList<Character> characters;
	private ArrayList<Misc> objects;
    Timer timer;
	
    /**
     * Controller for the Main Character
     * @param characters List of Characters
     * @param objects List of Objects
     * @param gameplayGUI The GUI itself
     */
    public Controller( ArrayList<Character> characters, ArrayList<Misc> objects, GUI gameplayGUI )
    {
        this.gameplayGUI = gameplayGUI;
        this.characters = characters;
		this.objects = objects;
        
		timer = new Timer( DELAY, this );
		timer.start( );
    }
    

    /**
     * Action taken based on certain events
     * @param e The event
     */
    public void actionPerformed( ActionEvent e ) 
    {
        for ( Character character : characters ) {
			
			character.MoveCharacter( characters );
        }
		
        //List of bullets that will be removed upon any collision
		ArrayList <Misc> gatherCollidedBullets = new ArrayList<Misc>( );
		
		for ( Misc obj : objects )
		{
			if ( obj instanceof Bullet )
			{
				Bullet temp = ( Bullet ) obj;
				Misc bulletReturned = temp.MoveBullet( );
				
				if ( bulletReturned != null )
				{
					gatherCollidedBullets.add( obj );
				}
			}
		}

        //List of characters that have died 
        ArrayList <Character> gatherDeadCharacters = new ArrayList<Character>();

        for ( Character ch : characters )
        {
            if( ch.GetHealth().ReturnCharacterHealth() <= 0 )
            {
                //Remove them from the GUI so they don't show up
                gameplayGUI.removeJLabel( ch.ReturnCharacterJLabel( ) );
                gameplayGUI.removeJLabel( ch.ReturnHealthJL( ) );
                gatherDeadCharacters.add( ch );
            }
        }
		
        //Reomve then
		objects.removeAll( gatherCollidedBullets );
        characters.removeAll(gatherDeadCharacters);
        gameplayGUI.repaint( );


        //If there is only one character, that means it's the player, therefore he wins!
        if( characters.size( ) == 1 )
        {
            timer.stop();
            System.exit(0);
        }

        //If the Main Character is not in the list of characters, he has died, and therefore zombies win
        boolean temp = false;
        for ( Character ch : characters )
        {
            if ( ch instanceof MainCharacter )
            {
                temp = true;
                break;
            }
        }

        if( !temp )
        {
            timer.stop( );
            System.exit(0);
        }
    }
}