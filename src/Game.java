import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Game extends JFrame implements ActionListener {
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
    int xposition = 900;
    int yposition = 405;
    int xposition2 = 130;
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
    JLabel imagejlable;
    int xpositionpers = 450;
    int ypositionpers = 450;
    boolean ydown= true;
    boolean yup = true;
    BufferedImage bi;
    BufferedImage p;

    int speed = 10;
    Timer timer;
    public Game(MouseAdapter start) {


        setSize(1840, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // конкректный слой
        timer = new Timer(150, this);
        timer.start();
        addMouseListener(ml);
        setVisible(true);
        JPanel jPanel = new JPanel();
        Image image = Toolkit.getDefaultToolkit().getImage("C:/Users/Пользователь/Downloads/игра/pers1_resized.png");
        MediaTracker mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(pers1,0);
        ImageIcon imageIcon = new ImageIcon(image);
        imagejlable = new JLabel(imageIcon);// отображает изображение
        jPanel.add(imagejlable);
        Timer timermoove = new Timer(20, null);
        timermoove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                xpositionpers -=1;
                    repaint();

// проверку окна
            }
        });
        timermoove.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_UP && yup == true)

                {
                    yup= false;
                    ydown = true;
                    Timer timerPers = new Timer(20, null);
                    timerPers.addActionListener(new ActionListener() {
                        int count = 0;
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                            if (count < 25) {
                                ypositionpers -= 10;
                                xpositionpers +=6;
                                count++;
                                repaint();
                            } else {

                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                )) {
                                    ypositionpers += 250;
                                    yup = true;
                                    repaint();
                                }
                              if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                ))

                                    {
                                        GameOver gameOver = new GameOver(this);
                                    }

                                timerPers.stop();
                            }
                        }
                    });
                    timerPers.start();

                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    Timer timerPers2 = new Timer(20, null);
                    timerPers2.addActionListener(new ActionListener() {
                        int count = 0;
                        @Override
                        public void actionPerformed(ActionEvent ev) {  // встроенный метод таймера двигает персонажа
                            if (count < 25) {
                                xpositionpers +=10;
                                count++;
                                repaint();
                            } else {
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                )) {
                                    ypositionpers += 250;
                                    yup = true;
                                    repaint();
                                }
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                ))

                                {
                                    GameOver gameOver = new GameOver(this);
                                    //dispose();
                                }

                                timerPers2.stop();
                            }
                        }
                    });
                    timerPers2.start();

                }
                if (e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    Timer timerPers2 = new Timer(20, null);
                    timerPers2.addActionListener(new ActionListener() {
                        int count = 0;
                        @Override
                        public void actionPerformed(ActionEvent ev) {  // встроенный метод таймера двигает персонажа
                            if (count < 25) {
                                xpositionpers -=10;
                                count++;
                                repaint();
                            } else {
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                )) {
                                    ypositionpers += 250;
                                    yup = true;
                                    repaint();
                                }
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                ))

                                {
                                    GameOver gameOver = new GameOver(this);
                                    //dispose();
                                }

                                timerPers2.stop();
                            }
                        }
                    });
                    timerPers2.start();

                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN && ydown == true)
                {
                    ydown = false;
                    yup = true;
                    Timer timerPers2 = new Timer(20, null);
                    timerPers2.addActionListener(new ActionListener() {
                        int count = 0;
                        @Override
                        public void actionPerformed(ActionEvent ev) {  // встроенный метод таймера двигает персонажа
                            if (count < 25) {
                                ypositionpers += 10;
                                xpositionpers +=6;
                                count++;
                                repaint();
                                } else {
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                )) {
                                    ypositionpers += 250;
                                    yup = true;
                                    repaint();
                                }
                                if (!((xpositionpers >= xposition && xpositionpers <= xposition+617 && ypositionpers  <= yposition +250 && ypositionpers>= yposition-250)
                                        ||( xpositionpers >= xposition2 && xpositionpers <= xposition2+617 && ypositionpers  <= yposition2 +250 && ypositionpers>= yposition2-250)
                                        || (xpositionpers >= xpositionsmall1 && xpositionpers <= xpositionsmall1 +362 && ypositionpers  <= ypositionsmall1 +250 && ypositionpers>= ypositionsmall1-250)
                                        || (xpositionpers >= xpositionsmall2 && xpositionpers <= xpositionsmall2 +362 && ypositionpers  <= ypositionsmall2 +250 && ypositionpers>= ypositionsmall2-250)
                                        || (xpositionpers >= xpositionsmall3 && xpositionpers <= xpositionsmall3 +362 && ypositionpers  <= ypositionsmall3 +250 && ypositionpers>= ypositionsmall3-250)
                                ))

                                {
                                    GameOver gameOver = new GameOver(this);
                                    //dispose();
                                }

                                timerPers2.stop();
                            }
                        }
                    });
                    timerPers2.start();


                    timerPers2.start();
                }
        }});
        try{
            p= ImageIO.read(new File("src/img/fongame1.jpg"));
        } catch (IOException e)
        {
           // System.out.println("tt");
        }
        bi=new BufferedImage(getWidth(),getHeight(),6);
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
        Graphics2D test;
        test=bi.createGraphics();
        test.drawImage(p,0,0,this);
        //test.drawImage(fon, 0, 0, this);
        test.drawImage(exit, 1100, 30, this);
        test.drawImage(helth1, 400, 30, this);
        test.drawImage(helth2, 600, 30, this);
        test.drawImage(helth3, 800, 30, this);
        test.drawImage(pauza, 20, 30, this);
        if (Player.pers == true) {
            test.drawImage(pers1, xpositionpers, ypositionpers, this);
        } else {
            test.drawImage(pers2, xpositionpers, ypositionpers, this);
        }
        test.drawImage(platf, xposition, yposition, this);
        test.drawImage(platf2, xposition2, yposition2, this);
        test.drawImage(platfsmall1, xpositionsmall1, ypositionsmall1, this);
        test.drawImage(platfsmall2, xpositionsmall2, ypositionsmall2, this);
        test.drawImage(platfsmall3, xpositionsmall3, ypositionsmall3, this);
        test.drawImage(prep, xpositionprep, ypositionprep+20, this);
        test.drawImage(prep2, xpositionprep2, ypositionprep2+20, this);
        test.drawImage(bonus, xpositionbonus, ypositionbonus+20, this);
        g.drawImage(bi,0,0,this);
        if (xpositionpers>=1360 || xpositionpers<=0)
        {
            GameOver gameOver= new GameOver(this);
            dispose();
        }
        if (ypositionpers<=0 || ypositionpers>=768)
        {
            GameOver gameOver = new GameOver(this);
            dispose();
        }

}
}
