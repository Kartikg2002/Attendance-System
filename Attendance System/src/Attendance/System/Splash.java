
package Attendance.System;
import javax.swing.*;
import java.awt.*;

class Splash1 extends JFrame implements Runnable{
    JLabel image;
    Splash1(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,1200,600);
        add(image);
        
        setVisible(true);
        for(int i=1,x=1;i<600;i+=3,x++){
            setSize(i+x,i);
            setLocation(1000-(i+x/2),400-(i/2));
            try{
                Thread.sleep(5);
            }catch(Exception e){
                System.out.println(e);
            }
        }   
    }
    @Override
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            new Login1().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
public class Splash {
    public static void main(String[] args) {
        Splash1 s1=new Splash1();
        Thread t1=new Thread(s1);
        t1.start();
    }
}
