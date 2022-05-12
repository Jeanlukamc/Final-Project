import javax.swing.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.io.File;

public class GUI extends JFrame
{	
	private JFrame frame;
    private JLayeredPane layeredPane;	
	private KeyStroke keyboardEvents;
    
    /**
     * Creates the GUI
     * @param xBoardSize Base
     * @param yBoardSize Height
     */
	public GUI( int xBoardSize, int yBoardSize ) 
	{	
        keyboardEvents = new KeyStroke( );
        frame = new JFrame( "Game" );
        frame.addKeyListener( keyboardEvents );
        
		layeredPane = new JLayeredPane( );
        layeredPane.setBounds( 0,0,xBoardSize,yBoardSize );
        frame.add( layeredPane );
        
        frame.setLayout( null );
        
        frame.setSize( xBoardSize, yBoardSize );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        frame.setResizable( false );
        
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
        music( );
	}  

    /**
     * Plays the music
     * Credit to John Smith (Stack Overflow: https://stackoverflow.com/questions/54505995/how-to-get-mediaplayer-to-repeatedly-play-sound)
     */
    private static void music( )
    {
        com.sun.javafx.application.PlatformImpl.startup( ( ) -> { } );
        MediaPlayer audio = new MediaPlayer( new Media( new File( "nightEgypt.wav" ).toURI( ).toString( ) ) );
        
        audio.play( );
    }
    

    /**
     * Returns the Keystroke that has been pressed
     * @return The Keystroke
     */
	public KeyStroke GetKeyStroke( ) { return this.keyboardEvents; } 
    
    /**
     * Repaint the canvas
     */
	public void repaint( )
	{
        layeredPane.revalidate( );
        layeredPane.repaint( );
    }
	
    /**
     * Reomves the JLabel from the Canvas
     * @param JL The JLabel
     */
	public void removeJLabel( JLabel JL )
	{
        layeredPane.remove( JL );
    }
	
    /**
     * Adds a new Label on the top layer of the Game
     * @param JL The New JLabel
     */
	public void addFrontLabel( JLabel JL )
	{
        layeredPane.add( JL, Integer.valueOf( 1 ) );
        frame.setVisible( true );
    }
	
    /**
     * Adds to the background of the game
     * @param JL The New JLabel
     */
	public void addBackgroundLabel( JLabel JL )
	{
        layeredPane.add( JL, Integer.valueOf( 0 ) );
        frame.setVisible( true );
    }
	
	public void addAboveAll( JLabel JL ) 
	{
		layeredPane.add( JL, Integer.valueOf( 2 ) );
		frame.setVisible( true );
	}
}