import java.awt.*;
import javax.swing.*;

//A big part of this code was taken from the website mentioned below and reused with few modoficatons
//https://www.java-tips.org/how-to-implement-a-splash-screen-for-an-application.html
 
public class Animation extends JWindow {
     
    private int duration;
     
    public Animation(int d) {
        duration = d;
    }
     
  
    public void showSplash() {
         
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
         
       
        int width = 458;
        int height =166;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
         
    
        JLabel label = new JLabel(new ImageIcon("Taskmanager1.png"));
        JLabel copyrt = new JLabel
                ("Task Manager ,Medtech,2019", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
       
        content.setBorder(BorderFactory.createLineBorder(Color.white, 10));
         
        // Display it
        setVisible(true);
         
        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
     
    public void showSplashAndExit() {
         
        showSplash();
        
         
    }
     
   
}