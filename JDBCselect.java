import javax.naming.Name;
import java.sql.*;

public class JDBCselect {
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

            String q = "Select * from table1";

            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);

                System.out.println("The name is: " + name + " and the city is: " + city);

            }

            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
