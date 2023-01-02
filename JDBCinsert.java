import java.sql.*;

public class JDBCinsert {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbctest";
            String username = "root";
            String pass = "";

            Connection conn = DriverManager.getConnection(url, username, pass);

            if(conn.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connected... Beautifully");
            }

            String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(200))";

            // Creating a statement

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

            System.out.println("Table created in Database");

            conn.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
