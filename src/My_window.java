import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class My_window extends JFrame
{
   public Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/photo_5238148776155879261_y.jpg");
   public Image nastr = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/nastr.png");
    public Image zapusk = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zapusk.png");
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public boolean f = false;
    public boolean s = false;
    public boolean r = false;


    private final int clickAreaX = 424; // превращает в  константу
    private final int clickAreaY = 380;
    private int shirinanastrX = 100;
    private int vysotanastrY = 50;

    private final int clickAreaX1 = 680;
    private final int clickAreaY1 = 380;
    private int shirinazapuskX = 100;
    private int vysotazapuskY = 50;

    private final int clickAreaX2 = 1100;
    private final int clickAreaY2 = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;

    MouseListener ml = new MouseListener()
    {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinanastrX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanastrY) {
                f = true;
                repaint();
            }
            if (mouseX >= clickAreaX1 && mouseX <= clickAreaX1 + shirinazapuskX &&
                    mouseY >= clickAreaY1 && mouseY <= clickAreaY1 + vysotazapuskY) {
                s = true;
            }
            repaint();
            if (mouseX >= clickAreaX2 && mouseX <= clickAreaX2 + shirinaexitX &&
                    mouseY >= clickAreaY2 && mouseY <= clickAreaY2 + vysotanaexitY) {
                r = true;
            }
            repaint();
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

    My_window ()
    {



        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(nastr, 0);
        try {
            tracker.waitForID(0);
            shirinanastrX = nastr.getWidth(this);
            vysotanastrY = nastr.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tracker.addImage(zapusk, 0);
        try {
            tracker.waitForID(0);
            shirinazapuskX = zapusk.getWidth(this);
            vysotazapuskY = zapusk.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tracker.addImage(exit, 0);
        try {
            tracker.waitForID(0);
            shirinaexitX = exit.getWidth(this);
            vysotanaexitY = exit.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        setSize(1840,1080);
        setVisible(true);
        addMouseListener(ml);


    }



    public void paint(Graphics g)
    {
        g.drawImage(fon,0,0, this);
        g.drawImage(nastr,424,380, this);
        g.drawImage(zapusk,680,380, this);
        g.drawImage(exit,1100,50, this);


        if (f)
        {
            Nastr nastr = new Nastr(this);
        }

        if (s)
        {
            Start start = new Start(this);
        }
        if (r)
        {
            dispose();
        }
    }

    public static void main(String[] args) {
        My_window w =  new My_window();

    }
}