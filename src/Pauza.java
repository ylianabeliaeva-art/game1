import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pauza extends JFrame {
    private testGame game; // ССЫЛКА НА ИГРУ

    public Image window = Toolkit.getDefaultToolkit().createImage("pausa_Fon.png");
    public Image zanovo = Toolkit.getDefaultToolkit().createImage("zanovo.png");
    public Image home = Toolkit.getDefaultToolkit().createImage("home.png");
    public Image play = Toolkit.getDefaultToolkit().createImage("zapusk.png");

    private final int HOME_X = 460, HOME_Y = 580;
    private final int ZANOVO_X = 860, ZANOVO_Y = 580;
    private final int PLAY_X = 1260, PLAY_Y = 580;

    // Размеры кнопок (загружаем один раз)
    private int homeWidth, homeHeight, zanovoWidth, zanovoHeight, playWidth, playHeight;

    public Pauza(testGame game) {
        this.game = game; // ← СОХРАНЯЕМ ССЫЛКУ

        setSize(1920, 1200);
        setLayout(null);
        setVisible(true);

        // Загружаем размеры изображений
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(home, 0);
        tracker.addImage(zanovo, 1);
        tracker.addImage(play, 2);
        try {
            tracker.waitForAll();
            homeWidth = home.getWidth(this);
            homeHeight = home.getHeight(this);
            zanovoWidth = zanovo.getWidth(this);
            zanovoHeight = zanovo.getHeight(this);
            playWidth = play.getWidth(this);
            playHeight = play.getHeight(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();

                // Кнопка "Домой"
                if (x >= HOME_X && x <= HOME_X + homeWidth &&
                        y >= HOME_Y && y <= HOME_Y + homeHeight) {
                    game.dispose(); // закрываем игру
                    dispose();      // закрываем паузу
                    new My_window(); // открываем главное меню
                }
                // Кнопка "Начать заново"
                else if (x >= ZANOVO_X && x <= ZANOVO_X + zanovoWidth &&
                        y >= ZANOVO_Y && y <= ZANOVO_Y + zanovoHeight) {
                    game.dispose(); // закрываем текущую игру
                    dispose();      // закрываем паузу
                    new testGame(null); // запускаем новую
                }
                // Кнопка "Продолжить"
                else if (x >= PLAY_X && x <= PLAY_X + playWidth &&
                        y >= PLAY_Y && y <= PLAY_Y + playHeight) {
                    dispose(); // просто закрываем паузу
                    game.setVisible(true);
                    game.timer.start(); // возобновляем игру
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(window, 0, 0, this);
        g.drawImage(home, HOME_X, HOME_Y, this);
        g.drawImage(zanovo, ZANOVO_X, ZANOVO_Y, this);
        g.drawImage(play, PLAY_X, PLAY_Y, this);
    }
}
