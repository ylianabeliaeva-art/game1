
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame implements ActionListener {
    public Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/fongame.jpg");
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public Image helth1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth3 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image pauza = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693d9e250003f.png");
    public Image platf = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693da1568b12c.png");
    public Image pers1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers1.png");
    public Image pers2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers2.png");

    private final int clickAreaX = 1100;
    private final int clickAreaY = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;
    int xposition = 1100;
    int yposition = 500;
    int speed = 20;
    Timer timer;
    public Game(MouseAdapter start) {


        setSize(1365, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        timer = new Timer(200, this);
        timer.start();
        addMouseListener(ml);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            xposition -= speed;
            if (xposition <= -150) {
                speed +=2;
                xposition = 1100;
            }

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
        public void paint (Graphics g)
        {
            super.paint(g);
            g.drawImage(fon, 0, 0, this);
            g.drawImage(exit, 1100, 30, this);
            g.drawImage(helth1, 400, 30, this);
            g.drawImage(helth2, 600, 30, this);
            g.drawImage(helth3, 800, 30, this);
            g.drawImage(pauza, 20, 30, this);
            if (Player.pers==true)
            {
                g.drawImage(pers1, 100,100, this);
            }
            else
            {
                g.drawImage(pers2, 100,100, this);

            }
            g.drawImage(platf, xposition, yposition, this);

        }
    }
