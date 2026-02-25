import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.File;
import java.io.IOException;

public class Player {
    public static boolean pers;

    private BufferedImage imgRight;   // оригинал (смотрит влево)
    private BufferedImage imgLeft;    // зеркальное
    private boolean facingRight = true; // направление взгляда

    public static int x, y;
    public boolean y_up;
    public boolean y_down;
    int width;
    int height;
    public Rectangle bord;
    public double vy = 0;
    public double vx = 0; // горизонтальная скорость
    public boolean onGround = true;

    public boolean wer(Rectangle prep) {
        System.out.println("zov");
        bord = new Rectangle(x, y, width, height);
        if (bord.intersects(prep)) {
            System.out.println("zzzzzzzzz");
            return true;
        }
        return false;
    }

    Player(int coordX, int coordY, int w, int h) {
        x = coordX;
        y = coordY;
        width = w;
        height = h;
        y_up = true;
        y_down = true;

        String path = pers ?
                "C:/Users/Пользователь/Downloads/игра/pers1_resized.png" :
                "C:/Users/Пользователь/Downloads/игра/pers2_resized.png";

        try {
            imgRight = ImageIO.read(new File(path));
            imgLeft = flip(imgRight);
        } catch (IOException e) {
          }
    }

    // Возвращает текущее изображение (с учётом направления)
    public Image getCurrentImage() {
        return facingRight ? imgRight : imgLeft;
    }

    // Меняет направление взгляда
    public void setFacingRight(boolean right) {
        this.facingRight = right;
    }

    // Вспомогательный метод: зеркальное отражение
    private BufferedImage flip(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1); // отразить по горизонтали х (умножить все x-координаты на -1). у такие же остались (1)
        tx.translate(-image.getWidth(), 0); // так как до этого мы уже отразили изображение (оно "упало" в отрицательную область), то этот сдвиг возвращает его обратно в видимую область ( сдвигая всё изображение на dx по X и dy по Y)
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR); // использует наше преобразование tx, задаёт метод интерполяции: TYPE_NEAREST_NEIGHBOR (самый простой и быстрый способ — без сглаживания, пиксели не размываются)
        return op.filter(image, null); // создай новое изображение автоматически (возвращает новое изображение без изменения оригинала)
    }
}