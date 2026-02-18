import java.awt.*;

public class Object {
    public Image img;
    public int x,y;
    public boolean visible;
    public int count;
    int width;
    int height;
    public boolean wer(Rectangle prep){
        Rectangle bord = new Rectangle(x, y, width, height);
        if(bord.intersects(prep)){
            System.out.println("zzzzzzzzz");
            return true;
        }
        return false;
    }
    Object(int xcoord, int ycoord, String way, int w, int h)
    {
        x = xcoord;
        y= ycoord;
        img = Toolkit.getDefaultToolkit().getImage(way);
        visible = true;
        count=3;
        width= w;
        height = h;


    }

}

