import java.awt.Polygon;
import java.awt.GradientPaint;
import java.awt.Color;
public class Wall{
    private int[] x;
    private int[] y;
    private char dir;
    private int k;
    private String type;
    public Wall(int[] x, int[] y, char dir,int k, String type){ // instance var to designate individual gradient
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.k = k;
        this.type = type;
    }

    public Polygon getPoly(){
        return new Polygon(x,y,y.length);
    }

    public int[] getStartCoord(){
        int[] result = new int[2];
        switch(dir)
        {
            case 'U':
                result[0] = x[3];
                result[1] = y[0];
                break;

            case 'D':
                result[0] = x[3];
                result[1] = y[0];

            case 'L':
                result[0] = x[0];
                result[1] = y[3];

            case 'R':
                result[0] = x[0];
                result[1] = y[3];

            case 'F':
                result[0] = x[0];
                result[1] = y[0];
                break;
        }
        return result;
    }

    public int[] getEndCoord(){
        return new int[]{x[3], y[3]};
    }

    public int[] getX(){
        return this.x;
    }

    public int[] getY(){
        return this.y;
    }

    public String getType(){
        return type;
    }

    public GradientPaint getPaint()
    {
        int eR = k-50;
        int eG = k-50;
        int eB = k-50;

        if(k<0)
            k=0;
        if(eR<0)
            eR = 0;
        if(eG<0)
            eG = 0;
        if(eB<0)
            eB = 0;

        switch(type)
        {
            case "left":
            case "right":
                return new GradientPaint(x[0], y[1], new Color(k, k, k), x[1], y[1], new Color(eR, eG, eB));

        }
        return new GradientPaint(x[0], y[3], new Color(k, k, k), x[0], y[0], new Color(eR, eG, eB));

    }



    // make an instance of the start and end coordinates

}