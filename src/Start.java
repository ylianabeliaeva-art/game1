import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Start extends JFrame {
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public Image vyborpers = Toolkit.getDefaultToolkit().createImage("src/img/fonpers.jpg");
    public ImageIcon pers1 = loadTransparentIcon("C:/Users/Пользователь/Downloads/игра/pers1.png");
    public ImageIcon pers2 = loadTransparentIcon("C:/Users/Пользователь/Downloads/игра/pers2.png");
  // кнопки из изображений
    private final int clickAreaX = 1100; // неизменные параметры
    private final int clickAreaY = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;
    public boolean f = false;
    public JLabel imagepers1; // отображает старую информацию в окне, нельзя пользователю ее менять
    public JLabel imagepers2;
    public ImageIcon pers1Big;
    public ImageIcon pers2Big;


    public My_window my_window1;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinaexitX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanaexitY) {
                dispose();
                My_window my_window = new My_window();
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

    public void uvelich1() {
        int vysota = (int) (pers1.getIconHeight() * 1.2);
        int shirina = (int) (pers1.getIconWidth() * 1.2);
        Image img1 = pers1.getImage().getScaledInstance(shirina, vysota, Image.SCALE_SMOOTH);
        pers1Big = new ImageIcon(img1);

    }

    ;

    public void uvelich2() {
        int vysota = (int) (pers2.getIconHeight() * 1.2);
        int shirina = (int) (pers2.getIconWidth() * 1.2);
        Image img2 = pers2.getImage().getScaledInstance(shirina, vysota, Image.SCALE_SMOOTH);
        pers2Big = new ImageIcon(img2);
    }

    ;

    private ImageIcon loadTransparentIcon(String path) {
        try {
            Image image = new ImageIcon(path).getImage();
            BufferedImage bufferedImage = new BufferedImage( // холст в памяти для работы с изображениями в программе
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB // константа хранящая цветовую модель для буферезированного изображения, каждый пиксель храниться как 32 битное число
            );

            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();

            return new ImageIcon(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon(path);
        }
    }

    public Start(MouseListener mouseListener) {

        setSize(1840, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ((JComponent) getContentPane()).setOpaque(false);


        JPanel panel = new JPanel() { // прямоугольная область для группировки и размещения кнопок и тд
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (vyborpers != null) {
                    g.drawImage(vyborpers, 0, 0, getWidth(), getHeight(), this);
                }

                if (exit != null) {
                    g.drawImage(exit, 1500, 50, this);
                }
            }
        };
        panel.setLayout(null);
        panel.setOpaque(false); // не рисует фон
        panel.setBounds(0, 0, getWidth(), getHeight()); // ручное задание координат

        panel.addMouseListener(ml);

        imagepers1 = new JLabel(pers1);
        imagepers2 = new JLabel(pers2);

        imagepers1.setOpaque(false);
        imagepers2.setOpaque(false);

        imagepers1.setBounds(450, 330, pers1.getIconWidth(), pers1.getIconHeight());
        imagepers2.setBounds(800, 330, pers2.getIconWidth(), pers2.getIconHeight());

        panel.add(imagepers1);
        panel.add(imagepers2);

        add(panel);

        uvelich1();
        uvelich2();

        imagepers1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imagepers1.setIcon(pers1Big);
                imagepers1.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagepers1.setIcon(pers1);
                imagepers1.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Player.pers = true;
                //Game game = new Game(this);
                System.out.println("woman");
                new testGame (this);
            }

        });

        imagepers2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imagepers2.setIcon(pers2Big);
                imagepers2.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagepers2.setIcon(pers2);
                imagepers2.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Player.pers = false;
                System.out.println("men");
                //Game game = new Game(this);
                new testGame (this);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                my_window1.setVisible(true);
                dispose();
            }

        });

        setVisible(true);
    }

    public Start(My_window my_window) {
        this.my_window1 = my_window;
        my_window.setVisible(false);
        setSize(1840, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ((JComponent) getContentPane()).setOpaque(false);


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                if (vyborpers != null) {
                    g.drawImage(vyborpers, 0, 0, getWidth(), getHeight(), this);
                }

                if (exit != null) {
                    g.drawImage(exit, 1100, 50, this);
                }
            }
        };
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, getWidth(), getHeight());

        panel.addMouseListener(ml);

        imagepers1 = new JLabel(pers1);
        imagepers2 = new JLabel(pers2);

        imagepers1.setOpaque(false);
        imagepers2.setOpaque(false);

        imagepers1.setBounds(350, 330, pers1.getIconWidth(), pers1.getIconHeight());
        imagepers2.setBounds(900, 330, pers2.getIconWidth(), pers2.getIconHeight());

        panel.add(imagepers1);
        panel.add(imagepers2);

        add(panel);

        uvelich1();
        uvelich2();

        imagepers1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imagepers1.setIcon(pers1Big);
                imagepers1.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagepers1.setIcon(pers1);
                imagepers1.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                //Game game = new Game(this);
                new testGame (this);
            }

        });

        imagepers2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imagepers2.setIcon(pers2Big);
                imagepers2.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagepers2.setIcon(pers2);
                imagepers2.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                //Game game = new Game(this);
                new testGame (this);
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                my_window1.setVisible(true);
                dispose();
            }

        });

        setVisible(true);
    }
}

