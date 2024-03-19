package Attendance.System;
import java.sql.*;
class Conn {
    private static final String url="jdbc:mysql://localhost:3306/AttendanceSystem";
    private static final String username="root";
    private static final String password="k@rtik2002";
    Connection connection;
    Statement statement;
    Conn(){
        try{
            connection=DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
