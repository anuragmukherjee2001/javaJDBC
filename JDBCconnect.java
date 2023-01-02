import java.sql.*;
public class JDBCconnect {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

//            creating a connection

            String url = "jdbc:mysql://localhost:3306/jdbctest";
            String username = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url, username, pass);

            if(conn.isClosed()){
                System.out.println("Connection is closed");
            }else{
                System.out.println("Connected... Like Wow");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
