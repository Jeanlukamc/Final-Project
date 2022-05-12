public class XYCoordinates
{
    private int x;
    private int y;

    /**
     * Construct the default XY Coordinates
     */
    public XYCoordinates( )
    {
        this.x = 0;
        this.y = 0;
    }

    public XYCoordinates( int x, int y )
    {
		this.x = x;
		this.y = y;
    }

    /**
     * Set the coordinates of XY manually
     * @param xPoint The X-Axis Point
     * @param yPoint The Y-Axis Point
     * @return The Coordinates
     */
    public XYCoordinates setCoordinates( int xPoint, int yPoint )
    {
        this.x = xPoint;
        this.y = yPoint;

        return( this );
    }

    /**
    * Return the Coordinates
    */
    public XYCoordinates GetCoordinates( )
    {
		return(this);
    }
    /**
     * @return the X Point
     */
    public int GetX()
    {
        return(this.x);
    }

    /**
     * @return the Y Point
     */
    public int GetY()
    {
        return(this.y);
    }

    /**
     * Convert the Coordinates into a string
     */
    public String toString()
    {
        return("(" + this.x + ", " + this.y + ")");
    }
}    
