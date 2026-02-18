import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testGame extends JFrame implements ActionListener {
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/IdeaProjects/game1/src/imgzakryt.png");
    public Image pauza = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693d9e250003f.png");

    Player myplayer = new Player(450, 450, 95, 250);

    Object helth1 = new Object(400, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);
    Object helth2 = new Object(600, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);
    Object helth3 = new Object(800, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);

    platforma pl1 = new platforma(900, 600, "C:/Users/Пользователь/Downloads/игра/platf600.png", 600, 70);
    platforma pl2 = new platforma(130, 700, "C:/Users/Пользователь/Downloads/игра/platf600.png", 600, 70);
    platforma plm1 = new platforma(1875, 500, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);
    platforma plm2 = new platforma(2310, 500, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);
    platforma plm3 = new platforma(2675, 700, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);

    Object prep = new Object(300, 500, "C:/Users/Пользователь/Downloads/one_resized.png", 73, 133);
    Object prep2 = new Object(300, 300, "C:/Users/Пользователь/Downloads/one_resized.png", 73, 133);
    Object bonus = new Object(pl1.x - 100, pl1.y - 100, "C:/Users/Пользователь/Downloads/five_resized.png", 73, 133);

    private int kolichestvoSerdechek = 3;
    private boolean[] serdechkoVidno = {true, true, true};
    private boolean prepVidno = true;
    private boolean prep2Vidno = true;
    private boolean bonusVidno = true;

    private final int PAUSE_X = 20, PAUSE_Y = 30, PAUSE_W = 50, PAUSE_H = 50;

    BufferedImage fon;
    BufferedImage buffer;
    Timer timer;
    int speed = 3;

    private boolean gameOverTriggered = false; // флаг для однократного GameOver

    public testGame(MouseAdapter start) {
        setSize(1840, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFocusable(true); // получает фокус с клавиатуры
       // requestFocusInWindow();
        setIgnoreRepaint(true);

        try {
            fon = ImageIO.read(new File("C:/Users/Пользователь/Downloads/игра/fongame1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = new BufferedImage(1840, 1080, BufferedImage.TYPE_INT_ARGB);

        timer = new Timer(20, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (( e.getKeyCode() == KeyEvent.VK_UP) && myplayer.onGround) {
                    myplayer.vy = -20;
                    myplayer.vx = 5;
                    myplayer.onGround = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    myplayer.x += 22;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    myplayer.x -= 20;
                }
                if ((e.getKeyCode() == KeyEvent.VK_SPACE) && myplayer.onGround) { // пробел
                    myplayer.vy = -27;
                    myplayer.vx = 10;
                    myplayer.onGround = false;
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= PAUSE_X && e.getX() <= PAUSE_X + PAUSE_W &&
                        e.getY() >= PAUSE_Y && e.getY() <= PAUSE_Y + PAUSE_H) {
                    dispose();
                    new Pauza(testGame.this);
                }
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pl1.x -= speed;
        if (pl1.x + 600 <0) {
            if (speed < 10) {speed += 1;}
            pl1.x = 1865;
            prep.count--;
            if (pl1.count == 3) {
                pl1.y = 700;
                prep.x = pl1.x + 250;
                prep.y = pl1.y - 80;
                prep.count--;
                pl1.count--;
            } else if (pl1.count == 2) {
                pl1.y = 500;
                pl1.count--;
            } else if (pl1.count == 1) {
                pl1.y = 500;
                pl1.count = 3;
            }
        }

        pl2.x -= speed;
        if (pl2.x + 600 <0) {
            if (speed < 10) {speed += 1;}
            pl2.x = 2465;
            if (pl2.count == 3) {
                pl2.y = 700;
                pl2.count--;
            } else if (pl2.count == 2) {
                pl2.y = 500;
                pl2.count--;
            } else if (pl2.count == 1) {
                pl2.y = 500;
                pl2.count = 3;
            }
        }

        plm1.x -= speed;
        if (plm1.x + 350 <0) {
            if (speed < 10) {speed += 1;}
            plm1.x = 2215;
            if (plm1.count == 3) {
                plm1.y = 500;
                plm1.count--;
            } else if (plm1.count == 2) {
                plm1.y = 500;
                plm1.count--;
            } else if (plm1.count == 1) {
                plm1.y = 700;
                plm1.count = 3;
            }
        }

        plm2.x -= speed;
        if (plm2.x + 350 <0) {
            if (speed < 10) {speed += 1;}
            plm2.x = 2215;
            if (plm2.count == 3) {
                plm2.y = 500;
                plm2.count--;
            } else if (plm2.count == 2) {
                plm2.y = 700;
                plm2.count--;
            } else if (plm2.count == 1) {
                plm2.y = 700;
                plm2.count = 3;
            }
        }

        plm3.x -= speed;
        if (plm3.x + 350<0) {
            if (speed < 10) {speed += 1;}
            plm3.x = 2215;
            if (plm3.count == 3) {
                plm3.y = 700;
                plm3.count--;
            } else if (plm3.count == 2) {
                plm3.y = 500;
                plm3.count--;
            } else if (plm3.count == 1) {
                plm3.y = 500;
                plm3.count = 3;
            }
        }

        if (pl1.count == 3) { prep.x = pl1.x + 250; prep.y = pl1.y - 80; }
        if (plm1.count == 2) { prep.x = plm1.x + 90; prep.y = plm1.y - 80; }
        if (pl2.count == 1) { prep.x = pl2.x + 400; prep.y = pl2.y - 80; }
        if (plm2.count == 3) { prep.x = plm2.x + 90; prep.y = plm2.y - 80; }
        if (plm3.count == 2) { prep2.x = plm3.x + 100; prep2.y = plm3.y - 80; }
        if (pl1.count == 2) { bonus.x = pl1.x + 200; bonus.y = pl1.y - 80; }

        // ФИЗИКА ИГРОКА
        myplayer.vy += 1;
        myplayer.y += myplayer.vy;

        if (!myplayer.onGround) {
            myplayer.x += myplayer.vx;
            myplayer.vx *= 0.95; // затухание скорости
        }

        myplayer.onGround = false; // если в воздухе
        checkCollision(pl1); // проверяет находится ли перс на платформе
        checkCollision(pl2);
        checkCollision(plm1);
        checkCollision(plm2);
        checkCollision(plm3);

        if (myplayer.onGround) {
            myplayer.x -= speed;
        }

        if (myplayer.y > 1080 && !gameOverTriggered ) {
            gameOverTriggered = true;
            new GameOver(this);
            dispose();
            return;
        }

        // СТОЛКНОВЕНИЯ С ОБЪЕКТАМИ
        Rectangle player = new Rectangle(myplayer.x, myplayer.y, myplayer.width, myplayer.height);

        if (prepVidno && player.intersects(new Rectangle(prep.x, prep.y, prep.width, prep.height))) {
            ubratSerdechko();
            prepVidno = false;
        }
        if (prep2Vidno && player.intersects(new Rectangle(prep2.x, prep2.y, prep2.width, prep2.height))) {
            ubratSerdechko();
            prep2Vidno = false;
        }
        if (bonusVidno && player.intersects(new Rectangle(bonus.x, bonus.y, bonus.width, bonus.height))) {
            verniSerdechko();
            bonusVidno = false;
        }

        if (kolichestvoSerdechek <= 0 && !gameOverTriggered) {
            gameOverTriggered = true;
            new GameOver(this);
            dispose();
        }

        repaint();
    }


    private void checkCollision(platforma plat) {
        int playerBottom = myplayer.y + myplayer.height; // определяет дно перса
        int platformTop = plat.y; // макушка плтформы
        boolean horizontal = (myplayer.x + myplayer.width > plat.x) &&
                (myplayer.x < plat.x + plat.width); //находится ли перс над платформой по горизонтали

        if (myplayer.vy > 0 &&
                playerBottom >= platformTop &&
                playerBottom <= platformTop + 20 &&
                horizontal) {
            myplayer.y = plat.y - myplayer.height;
            myplayer.vy = 0;
            myplayer.onGround = true;
        }
    }

    private void ubratSerdechko() {
        for (int i = serdechkoVidno.length - 1; i >= 0; i--) {
            if (serdechkoVidno[i]) {
                serdechkoVidno[i] = false;
                kolichestvoSerdechek--;
                break;
            }
        }
    }

    private void verniSerdechko() {
        for (int i = 0; i < serdechkoVidno.length; i++) {
            if (!serdechkoVidno[i]) {
                serdechkoVidno[i] = true;
                kolichestvoSerdechek++;
                break;
            }
        }
    }
    @Override
    public void dispose() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        super.dispose();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = buffer.createGraphics();
        g2d.fillRect(0, 0, 1840, 1080);

        if (fon != null) g2d.drawImage(fon, 0, 0, null);
        g2d.drawImage(exit, 1100, 30, null);
        g2d.drawImage(pauza, PAUSE_X, PAUSE_Y, null);

        if (serdechkoVidno[0]) g2d.drawImage(helth1.img, helth1.x, helth1.y, null);
        if (serdechkoVidno[1]) g2d.drawImage(helth2.img, helth2.x, helth2.y, null);
        if (serdechkoVidno[2]) g2d.drawImage(helth3.img, helth3.x, helth3.y, null);

        g2d.drawImage(myplayer.img, myplayer.x, myplayer.y, null);

        if (prepVidno) g2d.drawImage(prep.img, prep.x, prep.y, null);
        if (prep2Vidno) g2d.drawImage(prep2.img, prep2.x, prep2.y, null);
        if (bonusVidno) g2d.drawImage(bonus.img, bonus.x, bonus.y, null);

        g2d.drawImage(pl1.img, pl1.x, pl1.y, null);
        g2d.drawImage(pl2.img, pl2.x, pl2.y, null);
        g2d.drawImage(plm1.img, plm1.x, plm1.y, null);
        g2d.drawImage(plm2.img, plm2.x, plm2.y, null);
        g2d.drawImage(plm3.img, plm3.x, plm3.y, null);

        g2d.dispose();
        g.drawImage(buffer, 0, 0, null);
    }
}