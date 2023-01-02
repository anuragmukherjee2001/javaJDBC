import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCimageinsert {

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

            String q = "insert into image(picture) values(?)";

            //get the prepared statement object

            PreparedStatement pstmt =  conn.prepareStatement(q);

            FileInputStream fis = new FileInputStream("1.jpeg");

            pstmt.setBinaryStream(1,fis, fis.available());

            pstmt.executeUpdate();

            System.out.println("Inserted image");


            conn.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
