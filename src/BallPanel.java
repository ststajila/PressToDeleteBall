import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BallPanel extends JPanel{

    private ArrayList balls = new ArrayList();
    private JButton addBall = new JButton("Add");


    public BallPanel(){
        setLayout(new BorderLayout());
        add(addBall, BorderLayout.SOUTH);

        setBackground(Color.BLACK);


        addBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balls.add(new Ball());
            }
        });

        for (int i = 0; i < 20; i++){
            balls.add(new Ball());
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                @Override
                public void mouseClicked (MouseEvent e){
                   for(int i = 0; i <= balls.size(); i++) {
                      if(balls.get(i).deleteBall(e.getX(), e.getY()) == true){
                          balls.remove(i);
                          i--;
                      };
                   }
                }

            }
        });
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < balls.size(); i++){
            balls.get(i).drawBall(g);
            balls.get(i).moveBall(this);
        }


        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        repaint();

    }
}