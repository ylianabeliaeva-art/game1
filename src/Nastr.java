import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class Nastr extends JFrame {
    public Image exit = Toolkit.getDefaultToolkit().createImage("zakryt.png");
    public Image nastrimage = Toolkit.getDefaultToolkit().createImage("fonnastr.png");
    public Image on = Toolkit.getDefaultToolkit().createImage("on.png");
    public Image nezapusk = Toolkit.getDefaultToolkit().createImage("off.png");

    private final int clickAreaX = 1700;
    private final int clickAreaY = 50;
    private final int shirinaexitX = 100;
    private final int vysotanaexitY = 100;

    public boolean f = false;

    private final int clickAreaX1 = 1000;
    private final int clickAreaY1 = 500;
    private final int shirinazapuskX = 200;
    private final int vysotazapuskY = 200;

    //  Глобальные статические поля — живут пока работает программа
    private static Clip backgroundMusic;
    private static boolean isMusicPlaying = false;
    private static final String musicPath = "music_school.wav";

    public My_window my_window;

    MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            //  Кнопка вкл/выкл звука
            if (mouseX >= clickAreaX1 && mouseX <= clickAreaX1 + shirinazapuskX &&
                    mouseY >= clickAreaY1 && mouseY <= clickAreaY1 + vysotazapuskY) {

                if (isMusicPlaying) {
                    if (backgroundMusic != null && backgroundMusic.isRunning()) {
                        backgroundMusic.stop();
                        backgroundMusic.close();
                        backgroundMusic = null;
                    }
                    isMusicPlaying = false;
                } else {
                    playMusic(musicPath);
                }
                repaint();
            }

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

    public Nastr(My_window my_window) {
        setTitle("Включи музыку");
        this.my_window = my_window;
        my_window.setVisible(false);
        setSize(1920, 1200);
        setVisible(true);
        addMouseListener(ml);

        addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {
                // Музыка НЕ останавливается — играет в других окнах!
                my_window.setVisible(true);
                dispose();
            }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }

    private static void playMusic(String filePath) {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            isMusicPlaying = true;
            return;
        }
        try {
            if (backgroundMusic != null) backgroundMusic.close();

            File file = new File(filePath);
            if (!file.exists()) return;

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);
            backgroundMusic.start();
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            isMusicPlaying = true;
        } catch (Exception ignored) {
            isMusicPlaying = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(nastrimage, 0, 0, this);
        g.drawImage(exit, 1700, 50, this);

        //  Картинка зависит от глобального состояния
        if (isMusicPlaying) {
            g.drawImage(on, clickAreaX1, clickAreaY1, this);
        } else {
            g.drawImage(nezapusk, clickAreaX1, clickAreaY1, this);
        }

        if (f) {
            // Музыка НЕ останавливается при переходе!
            dispose();
            new My_window();
        }
    }
}