import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BallPanel extends JPanel{

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    private Ball ball = new Ball(30, 40, 50);

    private JButton addBall = new JButton("Add");


    public BallPanel(){

        for (int i = 0; i < 10; i++){
            balls.add(new Ball());
        }

        setLayout(new BorderLayout());
        add(addBall, BorderLayout.SOUTH);

        setBackground(Color.BLACK);
        setFocusable(true);


        addBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balls.add(new Ball());
            }
        });


           this.addMouseListener(new MouseAdapter() {
               @Override
               public void mousePressed(MouseEvent e) {

                   if(ball.deleteBall(e.getX(), e.getY()) == true){
                       System.out.println("Inside");
                   }


                   for (int i = 0; i < balls.size(); i++) {

                      // System.out.println(balls.get(i).deleteBall(e.getX(), e.getY()));
                       //System.out.println(e.getX() + ", " + e.getY());

                       if (balls.get(i).deleteBall(e.getX(), e.getY()) == true) {
                           System.out.println("You got it");
                           balls.remove(i);
                           i--;
                       }

                   }


               }
           });



    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        ball.drawBall(g);


        for (int i = 0; i < balls.size(); i++){
            balls.get(i).drawBall(g);
            balls.get(i).moveBall(this);
        }


        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            //System.out.println(e.toString());
        }

        repaint();

    }

}