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
    boolean movea=true;


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
            if (new Random().nextInt(2)<2)
                y = 605-height;
            else
                y = 905-height;
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
                if (y>800 && platformas[i].y ==900)
                    if (bord.intersects(new Rectangle(platformas[i].x+150, platformas[i].y, platformas[i].width-150, platformas[i].height)))
                    {
                        move=true;
                    }
                if (y<600 && platformas[i].y ==600)
                    if (bord.intersects(new Rectangle(platformas[i].x+150, platformas[i].y, platformas[i].width-150, platformas[i].height)))
                    {
                        move=true;
                    }
            }
        }
    }
    public void moveakr(platforma[] platformas) {
        // Если объект ушёл за левый край — перезапускаем
        if (x + width < 0) {
            visible = true;
            x = 2000 + new Random().nextInt(500); // появляется справа
            // Выбираем высоту: либо над верхней, либо над нижней платформой
            if (new Random().nextInt(2) == 0) {
                y = 900 - height; // над платформой на 900
            } else {
                y = 600 - height; // над платформой на 600
            }
            movea = true; //  СРАЗУ ДЕЛАЕМ АКТИВНЫМ
            return; // выходим, чтобы не обрабатывать движение дважды
        }

        // Движение
        if (movea) {
            x -= 10;
        }
    }


}

