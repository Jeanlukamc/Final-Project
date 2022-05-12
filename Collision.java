import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.geom.Area;
import javax.swing.JLabel;

public class Collision
{
    private boolean collided;

    /**
     * Main Constructor
     */
    public Collision( )
    {
        this.collided = false;
    }

    /**
     * Changes the status back to false
     * @return Status
     */
    public boolean ChangeStatus( )
    {
        collided = false;

        return(this.collided);
    }

    /**
     * Returns the Object
     * @return Object
     */
    public Collision ReturnCollision( )
    {
        return(this);
    }

    /**
     * Returns the Boolean contained within the class
     * @return Boolean
     */
    public boolean ReturnStatus( )
    {
        return(this.collided);
    }

    /**
     * Checks the status of characters that are touching each other, has special case for zombie interactions with main character
     * @param listOfCharacters The List of Characters
     * @param character The Character that may be touching another
     * @param newX The New X-Coordinate
     * @param newY The New Y-Coordinte
     * @return True or False
     */
    public boolean CheckCharStatus( ArrayList<Character> listOfCharacters, Character character, int newX, int newY )
    {
        JLabel temp = new JLabel( );
        temp.setSize( character.ReturnSize( ), character.ReturnSize( ) );
        temp.setLocation( newX, newY );

        if( newX <= 0 || newY <= 0 || newX >= 900 || newY >= 900 )
        {
            return true;
        }

		for( Character obj : listOfCharacters )
        {   	
			if( obj == character )
			{
				continue;
			}

            if( obj instanceof MainCharacter )
            {
                collided = intersects( temp , obj.ReturnCharacterJLabel( ) );
            
                if( collided )
                {
                    obj.GetHealth( ).DecreaseHealth( 20, obj );
                    return true;
                }
            }
			
            collided = intersects( temp , obj.ReturnCharacterJLabel( ) );
            
            if( collided )
            {
                return true;
            }
        }
        return false;
    }
	
    /**
     * Checks which bullets touch a Zombie or a Wall
     * @param listOfCharacters List of Characters
     * @param listOfObjects List of Objects
     * @param bullet Bullet that may touch another object
     * @param newX New X-Coordinate
     * @param newY New Y-Coordinate
     * @return True or False
     */
	public boolean CheckBulletCharacterCollison( ArrayList<Character> listOfCharacters, ArrayList<Misc> listOfObjects, Bullet bullet, int newX, int newY, GUI game )
	{
		JLabel temp = new JLabel( );
        temp.setSize( bullet.ReturnBase( ), bullet.ReturnHeight( ) );
        temp.setLocation( newX, newY );	

        if( newX <= 0 || newY <= 0 || newX >= 900 || newY >= 900 )
        {
            return true;
        }
			
		for( Character ch : listOfCharacters )
        {
            if(ch instanceof MainCharacter)
            {
                continue;
            }   
            				
            collided = intersects( temp , ch.ReturnCharacterJLabel( ) );
            
            if( collided )
            {
                ch.GetHealth( ).DecreaseHealth( 20, ch );
                
                return true;
            }
        }

        for( Misc obj : listOfObjects )
        {   				
            collided = intersects( temp , obj.ReturnMiscJLabel( ) );
            
            if( collided )
            {
                return true;
            }
        }
        return false;
	}

    /**
     * Checks the Object status for Walls
     * @param listOfObjects The list of walls
     * @param character Character in question
     * @param newX New X-Coordinate
     * @param newY New Y-Coordinate
     * @return True or False
     */
    public boolean CheckObjStatus(ArrayList<Misc> listOfObjects, Rectangle character, int newX, int newY )
    {
        JLabel temp = new JLabel( );
        temp.setBounds( character );
        temp.setLocation( newX, newY );

        if( newX <= 0 || newY <= 0 || newX >= 900 || newY >= 900 )
        {
            return true;
        }

        for( Misc obj : listOfObjects )
        {       
            collided = intersects( temp , obj.ReturnMiscJLabel( ) );
            
            if( collided )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether one JLabel Character collides with another JLable
     * @param character1 First JLabel
     * @param character2 Second JLabel
     * @return True or False
     */
    private boolean intersects( JLabel character1, JLabel character2 )
    {
        if( character1 == null || character2 == null)
        {
            return(false);
        }
        Area area1 = new Area( character1.getBounds(  ) );
        Area area2 = new Area( character2.getBounds( ) );
    
        return ( area1.intersects( area2.getBounds2D( ) ) );
    }
}