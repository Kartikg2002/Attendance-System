
package Attendance.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class home1 extends JFrame implements ActionListener{
    JLabel header,id,image;
    JTextField idtext;
    JButton present,close;
    home1(){
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        header=new JLabel("<html><u>H I M T</u></html>");
        header.setBounds(300,10,300,30);
        header.setFont(new Font("Raleway",Font.BOLD,30));
        add(header);
        
        id=new JLabel("ID NUMBER:");
        id.setBounds(50,110,300,30);
        id.setFont(new Font("Raleway",Font.BOLD,18));
        add(id);
        idtext=new JTextField("ENTER YOUR ID NUMBER");
        idtext.setBounds(300,110,300,30);
        idtext.setFont(new Font("Raleway",Font.BOLD,18));
        add(idtext);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,200 , Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(40,290,600,200);
        add(image);
        
        present=new JButton("PRESENT");
        present.addActionListener(this);
        present.setForeground(Color.WHITE);
        present.setBackground(Color.BLACK);
        present.setFont(new Font("Cursive",Font.BOLD,18));
        present.setBounds(150,200,130,40);
        add(present);
        
        close=new JButton("ABSENT");
        close.addActionListener(this);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.setFont(new Font("Cursive",Font.BOLD,18));
        close.setBounds(390,200,130,40);
        add(close);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==present){
             String sid=idtext.getText();
             Date date=new Date();
             SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
             String sdate=formatter.format(date);
             try{
                Conn c=new Conn();
                String query="SELECT * FROM stuinfo WHERE id='"+sid+"'";
                ResultSet rs=c.statement.executeQuery(query);
                if(rs.next()){
                    String name=rs.getString("name");
                    
                    /*CHECKING YOUR ATTENDANCE ALREADY REGISTERED OR NOT FOR A PARTICULAR DAY*/
                   String query1="SELECT * FROM attendance WHERE id='"+sid+"'";
                   rs=c.statement.executeQuery(query1);
                   if(rs.next()){
                       if(sid.equals(rs.getString("id")) && sdate.equals(rs.getString("date"))){
                           JOptionPane.showMessageDialog(null,"!!!YOUR ATTENDANCE ALREADY REGISTERED!!! PLEASE ENTER ANOTHER ID NUMBER");
                           return;
                       }
                   }
                   
                   /*--------------------------------------------------------------------------------------------------*/
                   
                   String query2=String.format("INSERT INTO attendance VALUES('%s','%s','%s','%s')",sid,name,sdate,"PRESENT");
                   c.statement.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null,"YOUR ATTENDANCE REGISTERED");
                }
                else{
                    JOptionPane.showMessageDialog(null,"INVALID ID!!!");
                }
        }catch(Exception e){
                 e.printStackTrace();
        }
    }else{
          String sid=idtext.getText();
             Date date=new Date();
             SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
             String sdate=formatter.format(date);
             try{
                Conn c=new Conn();
                String query="SELECT * FROM stuinfo WHERE id='"+sid+"'";
                ResultSet rs=c.statement.executeQuery(query);
                if(rs.next()){
                    String name=rs.getString("name");
                    
                    /*CHECKING YOUR ATTENDANCE ALREADY REGISTERED OR NOT FOR A PARTICULAR DAY*/
                   String query1="SELECT * FROM attendance WHERE id='"+sid+"'";
                   rs=c.statement.executeQuery(query1);
                   if(rs.next()){
                       if(sid.equals(rs.getString("id")) && sdate.equals(rs.getString("date"))){
                           JOptionPane.showMessageDialog(null,"!!!YOUR ATTENDANCE ALREADY REGISTERED!!! PLEASE ENTER ANOTHER ID NUMBER");
                           return;
                       }
                   }
                   
                   /*--------------------------------------------------------------------------------------------------*/
                   
                   String query2=String.format("INSERT INTO attendance VALUES('%s','%s','%s','%s')",sid,name,sdate,"ABSENT");
                   c.statement.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null,"YOUR ATTENDANCE REGISTERED");
                }
                else{
                    JOptionPane.showMessageDialog(null,"INVALID ID!!!");
                }
        }catch(Exception e){
                 e.printStackTrace();
        }
        }
  }
}

public class home {
    public static void main(String args[]){
        home1 h1 = new home1();
        h1.setVisible(true);
    }  
}
