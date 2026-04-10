import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class My_window extends JFrame
{

   public Image fon = Toolkit.getDefaultToolkit().createImage("mainMenu.png");
   public Image nastr = Toolkit.getDefaultToolkit().createImage("nastr.png");
    public Image zapusk = Toolkit.getDefaultToolkit().createImage("zapusk.png");
    public Image exit = Toolkit.getDefaultToolkit().createImage("zakryt.png");
    public Image info = Toolkit.getDefaultToolkit().createImage("info.png");

    public boolean f = false;
    public boolean s = false;
    public boolean r = false;
    public boolean i = false;



    private final int clickAreaX = 650; // превращает в константу
    private final int clickAreaY = 580;
    private int shirinanastrX = 100;
    private int vysotanastrY = 50;

    private final int clickAreaX1 = 1100;
    private final int clickAreaY1 = 580;
    private int shirinazapuskX = 100;
    private int vysotazapuskY = 50;

    private final int clickAreaX2 = 1700;
    private final int clickAreaY2 = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;

    private final int clickAreaX3 = 100;
    private final int clickAreaY3 = 100;
    private int shirinainfX = 150;
    private int vysotainfY = 100;



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
            if (mouseX >= clickAreaX3 && mouseX <= clickAreaX3 + shirinainfX &&
                    mouseY >= clickAreaY3 && mouseY <=clickAreaY3 + vysotainfY) {
                i = true;
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
        setTitle("Бег за оценками");

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
        tracker.addImage(info, 0);
        try {
            tracker.waitForID(0);
            shirinainfX = info.getWidth(this);
            vysotainfY =info.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        setSize(1920,1200);
        setVisible(true);
        addMouseListener(ml);


    }



    public void paint(Graphics g)
    {
        g.drawImage(fon,0,0, this);
        g.drawImage(nastr,650,580, this);
        g.drawImage(zapusk,1100,580, this);
        g.drawImage(exit,1700,50, this);
        g.drawImage(info,100,100, this);


        if (f)
        {
            Nastr nastr = new Nastr(this);
        }

        if (s)
        {
            Start start = new Start(this);
        }
        if (i)
        {
            Info info = new Info(this);
        }
        if (r)
        {
            //dispose();
            System.exit(0);        }
    }


    public static void main(String[] args) {
        My_window w =  new My_window();

    }
}