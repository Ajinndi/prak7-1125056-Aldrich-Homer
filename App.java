import javax.swing.*;

public class App{
  public static void main(String[] args){
    String appName = "Simple Swing App";
    int width = 600;
    int height = 400;

    JFrame frame = new JFrame(appName);


    // components add here
    JPanel panel = new JPanel();
    panel.add(new JButton("Click Me"));
    frame.add(panel);

    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}