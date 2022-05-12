import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class KeyStroke implements KeyListener 
{  
    private boolean key_W_Pressed;
    private boolean key_S_Pressed;
    private boolean key_A_Pressed;
    private boolean key_D_Pressed;
    private boolean key_SPACE_Pressed;
    
    @Override
    public void keyTyped( KeyEvent e ) { }

    @Override
    public void keyPressed( KeyEvent e ) 
    {
        switch ( e.getKeyCode( ) )
		{
            case KeyEvent.VK_W:
            {
                key_W_Pressed = true; 
                break;
            }
            case KeyEvent.VK_S:
            {
                key_S_Pressed = true; 
                break;
            }
            case KeyEvent.VK_A:
            {
                key_A_Pressed = true; 
                break;
            }
            case KeyEvent.VK_D:
            {
                key_D_Pressed = true; 
                break;
            }
            case KeyEvent.VK_SPACE:
            {
                key_SPACE_Pressed = true;
                break;
            }   
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) 
    {
        switch ( e.getKeyCode( ) ){
            case KeyEvent.VK_W:
            {
                key_W_Pressed = false;
                break;
            }
            case KeyEvent.VK_S:
            {
                key_S_Pressed = false; 
                break;
            }
            case KeyEvent.VK_A:
            {
                key_A_Pressed = false; 
                break;
            }
            case KeyEvent.VK_D:
            {
                key_D_Pressed = false; 
                break;
            }
            case KeyEvent.VK_SPACE:
            {
                key_SPACE_Pressed = false;
                break;
            }
        }
    }
    
    public boolean getKey_W_Status( ){ return key_W_Pressed; }
    public boolean getKey_S_Status( ){ return key_S_Pressed; }
    public boolean getKey_A_Status( ){ return key_A_Pressed; }
    public boolean getKey_D_Status( ){ return key_D_Pressed; }
    public boolean getKey_SPACE_Status( ){ return key_SPACE_Pressed; }
    
	public boolean isAnyKeyPressed( )
	{
        if ( key_W_Pressed == false )
		{
            if ( key_S_Pressed == false )
			{
                if ( key_D_Pressed == false )
				{
                    if ( key_A_Pressed == false )
					{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isOnlyOneKeyPressed( )
	{
        int pressedKeyCounter = 0;
        if ( key_W_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_S_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_D_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_A_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( pressedKeyCounter == 1 )
		{
            return true;
        }
        return false;
    }
    
    public boolean isOnlyTwoKeysPressed( )
	{
        int pressedKeyCounter = 0;
        if ( key_W_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_S_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_D_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( key_A_Pressed == true )
		{
            pressedKeyCounter++;
        }
        if ( pressedKeyCounter == 2 )
		{
            return true;
        }
        return false;
    }
}