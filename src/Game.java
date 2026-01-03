
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame implements ActionListener {
    public Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/fongame1.jpg");
    public Image exit = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/zakryt.png");
    public Image helth1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image helth3 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/helth.png");
    public Image pauza = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/resize_image_693d9e250003f.png");
    public Image platf = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/photo_5328281967692287705_x-no-bg-preview (carve.photos).png");
    public Image platf2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/photo_5328281967692287705_x-no-bg-preview (carve.photos).png");
    public Image pers1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers1_resized.png");
    public Image pers2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/pers2_resized.png");
    public Image platfsmall1 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");
    public Image platfsmall2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");
    public Image platfsmall3 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/игра/platfsmall.png");
    public Image prep = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/one_resized.png");
    public Image prep2 = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/one_resized.png");
    public Image bonus = Toolkit.getDefaultToolkit().createImage("C:/Users/Пользователь/Downloads/five_resized.png");
    int xpositionprep ;
int ypositionprep;
    int xpositionprep2 ;
    int ypositionprep2;
    int xpositionbonus=-100 ;
    int ypositionbonus=-100;
    private final int clickAreaX = 1100;
    private final int clickAreaY = 50;
    private int shirinaexitX = 100;
    private int vysotanaexitY = 100;
    int xposition = 1034;
    int yposition = 405;
    int xposition2 = 150;
    int yposition2 = 665;
    int xpositionsmall1 = 1875;
    int ypositionsmall1 = 405;
    int xpositionsmall2 = 2310;
    int ypositionsmall2 = 405;
    int xpositionsmall3 = 2675;
    int ypositionsmall3 = 665;
    int count1 = 3;
    int count2 = 3;
    int count3 = 3;
    int count4 = 3;
    int count5 = 3;
    int countprep = 3;

    int speed = 20;
    Timer timer;

    public Game(MouseAdapter start) {


        setSize(1365, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // конкректный слой
        timer = new Timer(200, this);
        timer.start();
        addMouseListener(ml);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        xposition -= speed;
        if (xposition <= -1600) {
            speed += 2;
               xposition =1365;
               countprep--;
            if (count1==3)
            {
                yposition=405;
                    xpositionprep=xposition+250;
                    ypositionprep= yposition-80;
                    countprep--;
                count1--;
            }
            else if (count1==2)
            {
                yposition=665;
                count1--;
            }
            else if (count1==1)
            {
                yposition=405;
                count1=3;
            }

        }
        xposition2 -= speed;
        if (xposition2 <= -1600) {
            speed += 2;
            xposition2 = 1365;
            if (count2==3)
            {
                yposition2=665;
                count2--;
            }
           else if (count2==2)
            {
                yposition2=405;
                count2--;
            }
           else if (count2==1)
            {
                yposition2=405;
                count2=3;
            }
        }
        xpositionsmall1 -= speed;
        if (xpositionsmall1 <= -1600) {
            speed += 2;
            xpositionsmall1 =1365;
            if (count3==3)
            {
                ypositionsmall1=405;
                count3--;
            }
           else if (count3==2)
            {
                ypositionsmall1=405;
                count3--;
            }
          else   if (count3==1)
            {
                ypositionsmall1=665;
                count3=3;
            }
        }
        xpositionsmall2 -= speed;
        if (xpositionsmall2 <= -1600) {
            speed += 2;
            xpositionsmall2 =1365;
            if (count4==3)
            {
                ypositionsmall2=405;
                count4--;
            }
          else   if (count4==2)
            {
                ypositionsmall2=665;
                count4--;
            }
           else if (count4==1)
            {
                ypositionsmall2=665;
                count4=3;
            }
        }
        xpositionsmall3 -= speed;
        if (xpositionsmall3 <= -1600) {
            speed += 2;
            xpositionsmall3 =1365;
            if (count5==3)
            {
                ypositionsmall3=665;
                count5--;
            }
          else   if (count5==2)
            {
                ypositionsmall3=405;
                count5--;
            }
         else if (count5==1)
            {
                ypositionsmall3=405;
                count5 =3;
            }
        }
        if (count1==3 )
        {
            xpositionprep=xposition+250;
            ypositionprep= yposition-80;

        }
      if (count3==2)
        {
            xpositionprep=xpositionsmall1+90;
            ypositionprep=ypositionsmall1-80;

        }
       if (count2==1)
        {
            xpositionprep= xposition2+400;
            ypositionprep=yposition2-80;

        }
        if (count4==3)
        {
            xpositionprep2= xpositionsmall2+90;
            ypositionprep2=ypositionsmall2-80;
        }
        if (count5==2)
        {
            xpositionprep2= xpositionsmall3+100;
            ypositionprep2=ypositionsmall3-80;

        }
        if (count1==2)
        {
            xpositionbonus = xposition + 200;
            ypositionbonus = yposition - 80;
        }


        repaint();

    }

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            if (mouseX >= clickAreaX && mouseX <= clickAreaX + shirinaexitX &&
                    mouseY >= clickAreaY && mouseY <= clickAreaY + vysotanaexitY) {
                dispose();
                Start start = new Start(this);
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

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fon, 0, 0, this);
        g.drawImage(exit, 1100, 30, this);
        g.drawImage(helth1, 400, 30, this);
        g.drawImage(helth2, 600, 30, this);
        g.drawImage(helth3, 800, 30, this);
        g.drawImage(pauza, 20, 30, this);
        if (Player.pers == true) {
            g.drawImage(pers1, 150, 450, this);
        } else {
            g.drawImage(pers2, 150, 450, this);

        }
        g.drawImage(platf, xposition, yposition, this);
        g.drawImage(platf2, xposition2, yposition2, this);
        g.drawImage(platfsmall1, xpositionsmall1, ypositionsmall1, this);
        g.drawImage(platfsmall2, xpositionsmall2, ypositionsmall2, this);
        g.drawImage(platfsmall3, xpositionsmall3, ypositionsmall3, this);
        g.drawImage(prep, xpositionprep, ypositionprep+20, this);
        g.drawImage(prep2, xpositionprep2, ypositionprep2+20, this);
        g.drawImage(bonus, xpositionbonus, ypositionbonus+20, this);


    }
}
