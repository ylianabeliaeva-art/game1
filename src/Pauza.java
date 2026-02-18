import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

    public class Pauza extends JFrame {
        public Image window = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/gameover.jpg");
        public Image zanovo = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zanovo.png");
        public Image home = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/home.png");
        public Image play = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zanovo.png");
        public boolean f = false;
        public boolean s = false;
        public boolean p = false;

        private final int clickAreaX = 224; // превращает в  константу
        private final int clickAreaY = 380;
        private int shirinazanovoX = 100;
        private int vysotazanovoY = 50;

        private final int clickAreaX1 = 580;
        private final int clickAreaY1 = 380;
        private int shirinahomeX = 100;
        private int vysotahomeY = 50;

        private final int clickAreaX2 = 880;
        private final int clickAreaY2 = 380;
        private int shirinaplayX = 100;
        private int vysotaplayY = 50;

        public Pauza(Game game) {


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
            tracker.addImage(play, 0);
            try {
                tracker.waitForID(0);
                shirinaplayX = play.getWidth(this);
                vysotaplayY = play.getHeight(this);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setSize(1840, 1080);

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
                if (mouseX >= clickAreaX2 && mouseX <= clickAreaX2 + shirinaplayX &&
                        mouseY >= clickAreaY2 && mouseY <= clickAreaY2 + vysotaplayY) {
                    p = true;
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

        public Pauza(ActionListener actionListener) {


        }

        public Pauza(MouseListener mouseListener) {
        }


        public void paint (Graphics g){
            g.drawImage(window, 0, 0, this);
            g.drawImage(home, 224, 380, this);
            g.drawImage(zanovo, 580, 380, this);
            g.drawImage(play, 880, 380, this);

            if (f)
            {
                My_window my_window = new My_window();
                dispose();
            }

            if (s)
            {
                Game game  = new Game(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }
                });
                dispose();
            }
            if (p)
            {
                Game game  = new Game(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }
                });
                dispose();
            }


        }
    }

