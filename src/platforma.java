import java.awt.*;
import java.util.Random;

public class platforma {
    public Image img;
    public int x;
    public  int y;
    public  int count;
    int width;
    int height;

    platforma(int xkoord,int ykoord, String way, int w, int h)
    {
        x = xkoord;
        y = ykoord;
        img =  Toolkit.getDefaultToolkit().createImage(way);
        count=3;
        width= w;
        height = h;
    }
    public void move(int dx)
    {
        this.x -= dx;
        if (x + width <0)
        {
            x = 1800 + new Random().nextInt(250);
            if (new Random().nextInt(30)>15)
                y = 700;
            else
                y=500;
        }
    }

}
