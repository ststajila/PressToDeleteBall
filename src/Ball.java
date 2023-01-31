import java.awt.*;
import javax.swing.*;
public class Ball {
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;
    private Color color;

    public Ball(){
        x = (int)(Math.random()*200);
        y = (int)(Math.random()* 200);
        size = (int)(Math.random()*100)+5;
        xSpeed = 0; //(int)(Math.random()*1)+1;
        ySpeed = 0; //(int)(Math.random()*1)+1;

        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        color = new Color(r, g, b);
    }

    public Ball(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size=size;
        color = Color.GREEN;
    }

    public Ball(int x, int y, int size, int xSpeed, int ySpeed, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    public void drawBall(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void moveBall(JPanel panel){
        x += xSpeed;
        y += ySpeed;

        if (x >= panel.getWidth() - size || x <= 0){
            xSpeed *= -1;
        }

        if (y >= panel.getHeight() - size || y <= 0){
            ySpeed *= -1;
        }

    }

    public boolean deleteBall(double x1, double y1){
        double h = (y + (y + size))/2;
        double k = (x + (x + size))/2;
        double r = size/2;

        if (Math.pow((x1-h), 2) + Math.pow((y1-k), 2)  <= Math.pow(r, 2)){
            return true;
        }
        else {
            return false;
        }


    }




}