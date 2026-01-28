/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.util.Random;


public class character {
    String name;
    int health;
    int strong;
    public int x, y;
    BufferedImage image;// добавляем картинку в буфер
    public Rectangle boarder;

    character(String way, int _x, int _y) {
        health = 0;
        strong = 1;
        name = "aaa";
        x = _x;
        y = _y;

        try {// если все хорошо картиночка
            image = ImageIO.read(new File(way));// чтобы часть картнки была загржуена
        } catch (IOException e) {
            // throw new RuntimeException(e);// если не загружена карртинка, делай то то
        }

    }

    public boolean bam (Rectangle temp)
    {
        boarder= new Rectangle(x,y,image.getWidth(), image.getHeight() );
        if (boarder.intersects(temp))
        {
            System.out.println("boom!!!!!");
            return true;
        }
        return false;




    }

}
//созадли персонажа с помщью функции*/