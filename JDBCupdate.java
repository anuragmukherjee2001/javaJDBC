import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCupdate {
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

            String q = "update table1 set tName=?, tCity=? where tId=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the new person");
            String name = br.readLine();

            System.out.println("Enter the name of the new city");
            String city = br.readLine();

            //get the prepared statement object

            System.out.println("Enter the id");
            int id = Integer.parseInt(br.readLine());


            PreparedStatement pstmt =  conn.prepareStatement(q);



            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();

            System.out.println("Updated");


            conn.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
