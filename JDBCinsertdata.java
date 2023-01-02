import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCinsertdata {
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

            String q = "insert into table1(tName, tCity) values(?,?)";

            //get the prepared statement object

            PreparedStatement pstmt =  conn.prepareStatement(q);

            //set the values to the query

            pstmt.setString(1, "Anurag Mukherjee");
            pstmt.setString(2, "Chandannagar");

            pstmt.executeUpdate();

            System.out.println("Inserted");


            conn.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
