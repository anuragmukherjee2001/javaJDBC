import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCdynamicinput {

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

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the person");
            String name = br.readLine();

            System.out.println("Enter the name of the city");
            String city = br.readLine();

            pstmt.setString(1,name);
            pstmt.setString(2,city);

            pstmt.executeUpdate();

            System.out.println("Inserted");


            conn.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
