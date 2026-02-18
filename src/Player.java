import javax.swing.*;
import java.awt.*;
public class Player {
    public static  String name ;
    public static int helth = 3;
    public static boolean pers ;

    public  Image img;
    public  static int x,y;
    public  boolean y_up;
    public  boolean y_down;
    int width;
    int height;
    public Rectangle bord;
    public double vy = 0;
    public double vx = 0;// вертикальная скорость для параболы
    public boolean onGround = true;
    public boolean wer(Rectangle prep){
        System.out.println("zov");
         bord = new Rectangle(x, y,width,height);
        if(bord.intersects(prep)){
            System.out.println("zzzzzzzzz");
            return true;
        }
        return false;
    }
     Player(int coordX, int coordY, int w, int h) {
        if (pers == true) {
            img = Toolkit.getDefaultToolkit().createImage("img/pers1_resized.png");
        } else {
            img = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers2_resized.png");
        }
        x = coordX;
        y = coordY;
        y_up= true;
        y_down = true;
         height=h;
         width=w;
    }



}
