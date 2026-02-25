import java.awt.*;
import java.util.Random;

public class Object {
    public Image img;
    public int x,y;
    public boolean visible;
    public int count;
    int width;
    int height;
    boolean move=true;
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
    public void moveobj (int speedpl, platforma[] platformas)

    {
        if ( x + width< 0)
        {
            visible=true;
            move=false;
            x= 2000 + new Random().nextInt(500);
            if (new Random().nextInt(30)<15)
                y = 505-height;
            else
                y = 705-height;
        }

        if (x>=2000)
            x -= speedpl;
        else
            if (move)
                x-=speedpl;

        if (move==false)
        {
            for (int i=0; i< platformas.length; i++)
            {
                Rectangle bord = new Rectangle(x, y, width, height);
                if (y>600 && platformas[i].y ==700)
                    if (bord.intersects(new Rectangle(platformas[i].x, platformas[i].y, platformas[i].width, platformas[i].height)))
                    {
                        move=true;
                    }
                if (y<500 && platformas[i].y ==500)
                    if (bord.intersects(new Rectangle(platformas[i].x, platformas[i].y, platformas[i].width, platformas[i].height)))
                    {
                        move=true;
                    }
            }
        }
    }

}

