import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameOver extends JFrame {
    public Image window = Toolkit.getDefaultToolkit().createImage("gameOver.png");
    public Image zanovo = Toolkit.getDefaultToolkit().createImage("zanovo.png");
    public Image home = Toolkit.getDefaultToolkit().createImage("home.png");
    public boolean f = false;
    public boolean s = false;
    private final int clickAreaX = 700; // превращает в  константу
    private final int clickAreaY = 600;
    private int shirinazanovoX = 100;
    private int vysotazanovoY = 50;

    private final int clickAreaX1 = 1100;
    private final int clickAreaY1 = 600;
    private int shirinahomeX = 100;
    private int vysotahomeY = 50;
    public  GameOver(testGame testgame) {

        setTitle("Попробуй еще раз");

        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(home, 0);
        try {
            tracker.waitForID(0);
            shirinahomeX = home.getWidth(this);
            vysotahomeY = home.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tracker.addImage(zanovo, 0);
        try {
            tracker.waitForID(0);
            shirinazanovoX = zanovo.getWidth(this);
            vysotazanovoY = zanovo.getHeight(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setSize(1920, 1200);

        setVisible(true);
        addMouseListener(mouseListener);


    }
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinahomeX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotahomeY) {
                f = true;
                repaint();
            }
            if (mouseX >= clickAreaX1 && mouseX <= clickAreaX1 + shirinazanovoX &&
                    mouseY >= clickAreaY1 && mouseY <= clickAreaY1 + vysotazanovoY) {
                s = true;
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

    public GameOver(ActionListener actionListener) {


    }


    public void paint (Graphics g){
        g.drawImage(window, 0, 0, this);
        g.drawImage(home, 700, 600, this);
        g.drawImage(zanovo, 1100, 600, this);
        if (f)
        {
            My_window my_window = new My_window();
            dispose();
        }

        if (s)
        {
            dispose();
            new testGame(null);
        }

    }
}