import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Digitalwatch extends JPanel implements Runnable {

    private JLabel label;
    private Date date;
    private Font font = new Font("Verdana", Font.PLAIN, 20);
    private Thread thread;


    public Digitalwatch() {
        label = new JLabel();
        label.setFont(font);
        this.add(label);
        start();
    }


    private void getDate() {
        label.setText(date.toString());
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }


    public void run() {
        while (true) {
            date = new Date();
            getDate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Digitalwatch c = new Digitalwatch();
        JFrame f = new JFrame();
        f.add(c);
        f.setSize(350, 80);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
