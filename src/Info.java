import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Info extends JFrame {
    public Image exit = Toolkit.getDefaultToolkit().createImage("zakryt.png");
    public Image inf = Toolkit.getDefaultToolkit().createImage("Infofon.png");


    private final int clickAreaX = 1700;
    private final int clickAreaY = 50;
    private final int shirinaexitX = 100;
    private final int vysotanaexitY = 100;

    public boolean f = false;




    public My_window my_window;

    MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            //  Кнопка выхода
            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinaexitX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanaexitY) {
                f = true;
                repaint();
            }
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    };

    public Info(My_window my_window) {
        setTitle("Изучи правила");
        this.my_window = my_window;
        my_window.setVisible(false);
        setSize(1920, 1200);
        setVisible(true);
        addMouseListener(ml);


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(inf, 0, 0, this);
        g.drawImage(exit, 1700, 50, this);



        if (f) {
            dispose();
            new My_window();
        }
    }
}