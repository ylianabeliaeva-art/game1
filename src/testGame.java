import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class testGame extends JFrame implements ActionListener {
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/IdeaProjects/game1/src/imgzakryt.png");
    public Image pauza = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693d9e250003f.png");

    Player myplayer = new Player(450, 450, 65, 250);

    Object helth1 = new Object(400, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);
    Object helth2 = new Object(600, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);
    Object helth3 = new Object(800, 30, "C:/Users/Пользователь/Downloads/игра/helth.png", 100, 100);

    platforma pl1 = new platforma(900, 600, "C:/Users/Пользователь/Downloads/игра/platf600.png", 600, 70);
    platforma pl2 = new platforma(130, 700, "C:/Users/Пользователь/Downloads/игра/platf600.png", 600, 70);
    platforma plm1 = new platforma(1875, 500, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);
    platforma plm2 = new platforma(2310, 500, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);
    platforma plm3 = new platforma(2675, 700, "C:/Users/Пользователь/Downloads/игра/platf350.png", 350, 70);
    platforma[] plmas = {pl1, pl2, plm1, plm2, plm3};

    Object prep = new Object(300, 500, "C:/Users/Пользователь/Downloads/one_resized.png", 73, 133);
    Object prep2 = new Object(300, 300, "C:/Users/Пользователь/Downloads/one_resized.png", 73, 133);
    Object bonus = new Object(pl1.x - 100, pl1.y - 100, "C:/Users/Пользователь/Downloads/five_resized.png", 73, 133);

    private int kolichestvoSerdechek = 3;
    private boolean[] serdechkoVidno = {true, true, true};

    int x_new = 1840;
    private final int PAUSE_X = 20, PAUSE_Y = 30, PAUSE_W = 50, PAUSE_H = 50;

    BufferedImage fon;
    BufferedImage buffer;
    Timer timer;
    int speed = 4;

    private boolean gameOverTriggered = false;

    // Время и рекорд
    private long startTime;
    private long currentTime;
    private static long bestTime = 0;
    private static final String RECORD_FILE = "record.txt";

    public testGame(MouseAdapter start) {
        setSize(1840, 1080);
        setLayout(null);

        // Загрузка рекорда
        loadBestTime();

        try {
            fon = ImageIO.read(new File("C:/Users/Пользователь/Pictures/game.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = new BufferedImage(1840, 1080, BufferedImage.TYPE_INT_ARGB);

        timer = new Timer(20, this);
        timer.start();
        startTime = System.currentTimeMillis();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_UP) && myplayer.onGround) {
                    myplayer.vy = -20;
                    myplayer.vx = 5;
                    myplayer.onGround = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    myplayer.x += 20;
                    myplayer.setFacingRight(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    myplayer.x -= 20;
                    myplayer.setFacingRight(true);
                }
                if ((e.getKeyCode() == KeyEvent.VK_SPACE) && myplayer.onGround) {
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
                    timer.stop();
                    setVisible(false);
                    new Pauza(testGame.this);
                }
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentTime = System.currentTimeMillis() - startTime;

        x_new -= speed;
        for (int i = 0; i < plmas.length; i++) {
            plmas[i].move(speed, x_new);
            if (x_new < plmas[i].x + plmas[i].width) {
                x_new = plmas[i].x + plmas[i].width;
            }
        }
        bonus.moveobj(speed, plmas);
        prep.moveobj(speed, plmas);
        prep2.moveobj(speed, plmas);

        // Физика игрока
        myplayer.vy += 1;
        myplayer.y += myplayer.vy;

        if (!myplayer.onGround) {
            myplayer.x += myplayer.vx;
            myplayer.vx *= 0.95;
        }

        myplayer.onGround = false;
        for (platforma plat : plmas) {
            checkCollision(plat);
        }

        if (myplayer.onGround) {
            myplayer.x -= speed;
        }

        // GameOver: падение
        if (myplayer.y > 1080 && !gameOverTriggered) {
            gameOverTriggered = true;
            saveBestTime();
            new GameOver(this);
            dispose();
            return;
        }

        // Столкновения с объектами
        myplayer.bord = new Rectangle(myplayer.x, myplayer.y, myplayer.width, myplayer.height);

        if (prep.visible && myplayer.bord.intersects(new Rectangle(prep.x, prep.y, prep.width, prep.height))) {
            ubratSerdechko();
            prep.visible = false;
        }
        if (prep2.visible && myplayer.bord.intersects(new Rectangle(prep2.x, prep2.y, prep2.width, prep2.height))) {
            ubratSerdechko();
            prep2.visible = false;
        }
        if (bonus.visible && myplayer.bord.intersects(new Rectangle(bonus.x, bonus.y, bonus.width, bonus.height))) {
            verniSerdechko();
            bonus.visible = false;
        }

        // GameOver: 0 сердечек
        if (kolichestvoSerdechek <= 0 && !gameOverTriggered) {
            gameOverTriggered = true;
            saveBestTime();
            new GameOver(this);
            dispose();
        }

        repaint();
    }

    private void checkCollision(platforma plat) {
        int playerBottom = myplayer.y + myplayer.height;
        int platformTop = plat.y;
        boolean horizontal = (myplayer.x + myplayer.width > plat.x) &&
                (myplayer.x < plat.x + plat.width);

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

    // Загрузка рекорда из файла
    private void loadBestTime() {
        try {
            if (Files.exists(Paths.get(RECORD_FILE))) {
                String content = new String(Files.readAllBytes(Paths.get(RECORD_FILE)));
                bestTime = Long.parseLong(content.trim());
            }
        } catch (Exception e) {
            bestTime = 0;
        }
    }

    // Сохранение рекорда в файл
    private void saveBestTime() {
        if (currentTime > bestTime) {
            bestTime = currentTime;
            try {
                Files.write(Paths.get(RECORD_FILE), String.valueOf(bestTime).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
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

        // Отображение времени и рекорда
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("", Font.BOLD, 36));
        g2d.drawString(String.format("Время: %.2f", currentTime / 1000.0), 1200, 100);
        g2d.drawString(String.format("Рекорд: %.2f", bestTime / 1000.0), 1200, 150);

        if (serdechkoVidno[0]) g2d.drawImage(helth1.img, helth1.x, helth1.y, null);
        if (serdechkoVidno[1]) g2d.drawImage(helth2.img, helth2.x, helth2.y, null);
        if (serdechkoVidno[2]) g2d.drawImage(helth3.img, helth3.x, helth3.y, null);

        g2d.drawImage(myplayer.getCurrentImage(), myplayer.x, myplayer.y, null);
        if (prep.visible) g2d.drawImage(prep.img, prep.x, prep.y, null);
        if (prep2.visible) g2d.drawImage(prep2.img, prep2.x, prep2.y, null);
        if (bonus.visible) g2d.drawImage(bonus.img, bonus.x, bonus.y, null);

        for (platforma plat : plmas) {
            g2d.drawImage(plat.img, plat.x, plat.y, null);
        }

        g2d.dispose();
        g.drawImage(buffer, 0, 0, null);
    }
}