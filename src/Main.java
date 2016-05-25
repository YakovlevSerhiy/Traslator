import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException
    {

        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                JFrame frame = new NFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setVisible(true);


            }
        });

    }

}
