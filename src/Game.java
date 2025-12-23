
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame implements ActionListener {
    public Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/fongame1.jpg");
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public Image helth1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth3 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image pauza = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693d9e250003f.png");
    public Image platf = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/photo_5328281967692287705_x-no-bg-preview (carve.photos).png");
    public Image platf2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/photo_5328281967692287705_x-no-bg-preview (carve.photos).png");
    public Image pers1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers1_resized.png");
    public Image pers2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers2_resized.png");
    public Image platfsmall1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");
    public Image platfsmall2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");
    public Image platfsmall3 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");

    private final int clickAreaX = 1100;
    private final int clickAreaY = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;
    int xposition = 1034;
    int yposition = 405;
    int xposition2 = 150;
    int yposition2 = 665;
    int xpositionsmall1 = 1875;
    int ypositionsmall1 = 405;
    int xpositionsmall2 = 2310;
    int ypositionsmall2 = 405;
    int xpositionsmall3 = 2675;
    int ypositionsmall3 = 665;
    int count1 = 3;
    int count2 = 3;
    int speed = 20;
    Timer timer;

    public Game(MouseAdapter start) {


        setSize(1365, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // конкректный слой
        timer = new Timer(200, this);
        timer.start();
        addMouseListener(ml);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        xposition -= speed;
        if (xposition <= -617) {
            speed += 2;

        }
        xposition2 -= speed;
        if (xposition2 <= -617) {
            speed += 2;
        }
        xpositionsmall1-=speed;
        xpositionsmall2-= speed;
        xpositionsmall3-= speed;
        repaint();
    }

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinaexitX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanaexitY) {
                dispose();
                Start start = new Start(this);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(exit, 1100, 30, this);
        g.drawImage(helth1, 400, 30, this);
        g.drawImage(helth2, 600, 30, this);
        g.drawImage(helth3, 800, 30, this);
        g.drawImage(pauza, 20, 30, this);
        if (Player.pers == true) {
            g.drawImage(pers1, 150, 450, this);
        } else {
            g.drawImage(pers2, 150, 450, this);

        }
        g.drawImage(platf, xposition, yposition, this);
        g.drawImage(platf2, xposition2, yposition2, this);
        g.drawImage(platfsmall1, xpositionsmall1, ypositionsmall1, this);
        g.drawImage(platfsmall2, xpositionsmall2, ypositionsmall2, this);
        g.drawImage(platfsmall3, xpositionsmall3, ypositionsmall3, this);

    }
}
