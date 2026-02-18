import java.awt.*;

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

}
