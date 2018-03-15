import java.sql.*;
import javax.swing.JOptionPane;
public class dbConnect {
    Connection conn;
    public static Connection connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/OnlineVote","root","root");
        System.out.println("Connected to Database");
        return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Not Connected to Database");
        
            System.out.println("Some Error While Connecting");
        }
        
     return null;   
    }
    
    
}
