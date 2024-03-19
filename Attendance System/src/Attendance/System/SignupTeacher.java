package Attendance.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Signup2 extends JFrame implements ActionListener{
    JLabel header,name,username,password;
    JTextField nametext,usernametext ;
    JPasswordField passwordtext;
    JButton submit,back;
    Signup2(){

        setSize(750,570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        header=new JLabel("<html><u>FILL THE SIGNUP FORM</u></html>");
        header.setBounds(250,10,300,30);
        header.setFont(new Font("Raleway",Font.BOLD,22));
        add(header);
       
        
        name=new JLabel("NAME:");
        name.setBounds(50,140,300,30);
        name.setFont(new Font("Raleway",Font.BOLD,18));
        add(name);
        nametext=new JTextField();
        nametext.setBounds(300,140,300,30);
        nametext.setFont(new Font("Raleway",Font.BOLD,18));
        add(nametext);
        
        username=new JLabel("USERNAME:");
        username.setBounds(50,200,300,30);
        username.setFont(new Font("Raleway",Font.BOLD,18));
        add(username);
        usernametext=new JTextField();
        usernametext.setBounds(300,200,300,30);
        usernametext.setFont(new Font("Raleway",Font.BOLD,18));
        add(usernametext);
        
        password=new JLabel("PASSWORD:");
        password.setBounds(50,260,300,30);
        password.setFont(new Font("Raleway",Font.BOLD,18));
        add(password);
        passwordtext=new JPasswordField();
        passwordtext.setBounds(300,260,300,30);
        passwordtext.setFont(new Font("Raleway",Font.BOLD,18));
        add(passwordtext);
         
        submit=new JButton("SUBMIT");
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Cursive",Font.BOLD,18));
        submit.setBounds(150,420,150,40);
        add(submit);
        
        back=new JButton("BACK");
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Cursive",Font.BOLD,18));
        back.setBounds(400,420,150,40);
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String sname=nametext.getText();
            String susername=usernametext.getText();
            String spassword=passwordtext.getText();
            try{
            Conn c=new Conn();
            String query=String.format("INSERT INTO teacherinfo(name,username,password) VALUES('%s','%s','%s')",sname,susername,spassword);
            int r=c.statement.executeUpdate(query);
            if(r==0){
                JOptionPane.showMessageDialog(null,"ERROR!!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"DATA INSERTED SUCCESSFULLY");
            }
            }catch(Exception e){
                System.out.println(e);
            }    
        }
        else{
            setVisible(false);
            new Login1().setVisible(true);
        }
    }
}
public class SignupTeacher {
    public static void main(String args[]){
        Signup2 s1=new Signup2();
        s1.setVisible(true);
        
    }
    
}
