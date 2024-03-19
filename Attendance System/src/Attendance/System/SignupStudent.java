package Attendance.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Signup1 extends JFrame implements ActionListener{
    JLabel header,name,fname,phoneno,email,id,idtext;
    JTextField nametext,fnametext,phonenotext,emailtext;
    JButton submit,back;
    Signup1(){
        
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
        
        fname=new JLabel("FATHER'S NAME:");
        fname.setBounds(50,200,300,30);
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        add(fname);
        fnametext=new JTextField();
        fnametext.setBounds(300,200,300,30);
        fnametext.setFont(new Font("Raleway",Font.BOLD,18));
        add(fnametext);
        
        phoneno=new JLabel("PHONE NO.:");
        phoneno.setBounds(50,260,300,30);
        phoneno.setFont(new Font("Raleway",Font.BOLD,18));
        add(phoneno);
        phonenotext=new JTextField();
        phonenotext.setBounds(300,260,300,30);
        phonenotext.setFont(new Font("Raleway",Font.BOLD,18));
        add(phonenotext);
        
        email=new JLabel("EMAIL:");
        email.setBounds(50,320,300,30);
        email.setFont(new Font("Raleway",Font.BOLD,18));
        add(email);
        emailtext=new JTextField();
        emailtext.setBounds(300,320,300,30);
        emailtext.setFont(new Font("Raleway",Font.BOLD,18));
        add(emailtext);
        
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
            String sfname=fnametext.getText();
            String sphone=phonenotext.getText();
            String semail=emailtext.getText();
            try{
            Conn c=new Conn();
            String query=String.format("INSERT INTO stuinfo(name,fathername,phoneno,email) VALUES('%s','%s','%s','%s')",sname,sfname,sphone,semail);
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
public class SignupStudent {
    public static void main(String args[]){
        Signup1 s1=new Signup1();
        s1.setVisible(true);
        
    }
    
}
