package Attendance.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login1 extends JFrame implements ActionListener{
    JLabel image,username,password,logging;
    JTextField usernametext;
    JPasswordField passwordtext;
    JComboBox logging1;
    JButton login,cancel,signup;
    Login1(){
        setLayout(null);
        setSize(720,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,300 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(2,10,250,300);
        add(image);
        
        username=new JLabel("Username");
        username.setBounds(290,60,140,30);
        username.setFont(new Font("Raleway",Font.BOLD,22));
        add(username);
        
        usernametext=new JTextField();
        usernametext.setBounds(450,60,200,28);
        usernametext.setFont(new Font("Raleway",Font.BOLD,22));
        add(usernametext);
        
        password=new JLabel("Password");
        password.setBounds(290,140,140,30);
        password.setFont(new Font("Raleway",Font.BOLD,22));
        add(password);
        
        passwordtext=new JPasswordField();
        passwordtext.setBounds(450,140,200,28);
        passwordtext.setFont(new Font("Raleway",Font.BOLD,22));
        add(passwordtext);
        
        logging=new JLabel("CREATE YOUR ACCOUNT AS:");
        logging.setForeground(Color.RED);
        logging.setBounds(70,320,350,30);
        logging.setFont(new Font("Raleway",Font.BOLD,22));
        add(logging);
        
        String loggingvalues[]={"Student","Teacher"};
        logging1=new JComboBox(loggingvalues);
        logging1.setBounds(430,320,200,28);
        logging1.setBackground(Color.LIGHT_GRAY);
        logging1.setFont(new Font("Raleway",Font.BOLD,22));
        add(logging1);
  
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i5=i4.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        login=new JButton("Login",i6);
        login.addActionListener(this);
        login.setBounds(300,220,140,28);
        login.setFont(new Font("Raleway",Font.BOLD,22));
        add(login);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image i8=i7.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i9 =new ImageIcon(i8);
        cancel=new JButton("Cancel",i9);
        cancel.addActionListener(this);
        cancel.setBounds(500,220,140,28);
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel);
        
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i11=i10.getImage().getScaledInstance(30,26 , Image.SCALE_DEFAULT);
        ImageIcon i12 =new ImageIcon(i11);
        signup=new JButton("Signup",i12);
        signup.addActionListener(this);
        signup.setBounds(280,370,140,28);
        signup.setFont(new Font("Raleway",Font.BOLD,22));
        add(signup);
    }
     public void actionPerformed(ActionEvent ae){
         String user=(String) logging1.getSelectedItem();
        if(ae.getSource()==login){
            try{
            String susername=usernametext.getText();
            String spassword=passwordtext.getText();
            Conn c = new Conn();
            String query="SELECT * FROM teacherinfo WHERE username='"+susername+"' AND password='"+spassword+"'";
            ResultSet rs=c.statement.executeQuery(query);
            if(rs.next()){
                new home1().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD !!!!!");
            }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==signup ){
            if(user.equals("Student")){
                setVisible(false);
                new Signup1().setVisible(true);
            }
            else{
                setVisible(false);
                new Signup2().setVisible(true);
            }
        }
    }
}

public class Login {
    public static void  main(String args[]){
        Login1 l1=new Login1();
        l1.setVisible(true);
    }
}
