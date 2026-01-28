import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Nastr extends JFrame {
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public Image nastrimage = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/fonnastr.png");
    private final int clickAreaX = 1100;
    private final int clickAreaY = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;
    public boolean f = false;

    public My_window my_window;
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinaexitX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanaexitY) {
                f = true;
                repaint();
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

    public Nastr(My_window my_window) {
        this.my_window = my_window;
        my_window.setVisible(false);
        setSize(1840, 1080);
        setVisible(true);
        addMouseListener(ml);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                my_window.setVisible(false);
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(nastrimage, 0, 0, this);
        g.drawImage(exit, 1100, 50, this);
        if (f) {
            dispose();
            My_window my_window = new My_window();
        }
    }
}