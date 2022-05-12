import javax.swing.*;                 
import java.awt.Image;

public class Health
{
  private int health;
  private int maxHealth;
  private String path;
  private XYCoordinates position;
  private JLabel healthJL;
  
  private final int sizeX = 45;
  private final int sizeY = 45;

  /**
  * Default Constructor
  * @param position Position of the health bar
  */
  public Health( XYCoordinates position )
  {
    this.health = 100;
    this.maxHealth = 100;
	  this.position = position;
    this.path = "MCAs\\Health\\ZHealth\\ZHealth0.png";
	SetHealth( this.path );
  }
  
  /**
  * Default Constructor
  * @param health Set a specific amount of health
  * @param position Position of the Health Bar
  */
  public Health( int health, XYCoordinates position )
  {
    this.health = health;
    this.maxHealth = health;
	  this.position = position;
    this.path = "MCAs\\Health\\MCHealth\\Health0.png";
	  SetHealth( this.path );
  }

	/**
	 * Sets the Image of the addon on the game
	 * @param path The path of the item
	*/
	public void SetHealth( String path )
	{	 
		JLabel temp = new JLabel( ); 
		temp.setSize( sizeX, sizeY );
		temp.setLocation( position.GetX( ), position.GetY( ) );
			
		ImageIcon icon = new ImageIcon( path );
		Image image = icon.getImage( );
		Image scaledImage = image.getScaledInstance( temp.getWidth( ), temp.getHeight( ), Image.SCALE_SMOOTH );

		this.healthJL = new JLabel( new ImageIcon( scaledImage ) );
		this.healthJL.setSize( sizeX, sizeY );
		this.healthJL.setLocation( position.GetX( ) - 10, position.GetY( ) - 30 );
	}

  /**
   * Changes the path of the Health bar
   * @param newPath The new Health Bar
   */
  public void ChangeHealthPath( String newPath )
  {
    this.path = newPath;
  }

  /**
   * Returns the path
   * @return Path
   */
  public String ReturnHealthPath( )
  {
    return( this.path );
  }

  /**
   * Returns the Health integer
   * @return Current Health
   */
  public int ReturnCharacterHealth( )
  {
    return( this.health );
  }
	
  /**
  * Decreases the health of the character
  * @param attack How much damage the character recieves
  * @param character The Character that recieves damage
  * @return the health of the character after taking damage
  */
  public int DecreaseHealth( int attack, Character character )
  {
    if( health - attack < 0 )
    {
      health = 0;
    }
    else
    {
      health -= attack;
      if( character instanceof Zombie)
      {
        switch( health ) 
        {
          case 80:
          {
            ChangeHealthPath( "MCAs\\Health\\ZHealth\\ZHealth1.png" );
            break;
          }
          case 60:  
          {
            ChangeHealthPath( "MCAs\\Health\\ZHealth\\ZHealth2.png" );
            break;
          }
          case 40:
          {
            ChangeHealthPath( "MCAs\\Health\\ZHealth\\ZHealth3.png" );
            break;
          }
          case 20:
          {
            ChangeHealthPath( "MCAs\\Health\\ZHealth\\ZHealth4.png" );
            break;
          }
          case 0:
          {
            ChangeHealthPath( "MCAs\\Health\\ZHealth\\ZHealth5.png" );
            break;
          }
        }
      }
      else
      {
        switch( health ) 
        {
          case 1920:
          {
            ChangeHealthPath( "MCAs\\Health\\MCHealth\\Health1.png");
            break;
          }
          case 1440:  
          {
            ChangeHealthPath("MCAs\\Health\\MCHealth\\Health2.png" );
            break;
          }
          case 960:
          {
            ChangeHealthPath( "MCAs\\Health\\MCHealth\\Health3.png" );
            break;
          }
          case 480:
          {
            ChangeHealthPath( "MCAs\\Health\\MCHealth\\Health4.png" );
            break;
          }
          case 0:
          {
            ChangeHealthPath( "MCAs\\Health\\MCHealth\\Health5.png" );
            break;
          }
        }
      }

    }
    return( this.health );
  }
  
  public JLabel ReturnHealthJL( ) { return this.healthJL; } 
}