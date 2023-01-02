import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.*;

public class JDBCall {
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

            boolean flag = true;

            while(flag){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("1. See All the rows");
                System.out.println("2. Insert A row");
                System.out.println("3. Update a Row");
                System.out.println("4. Delete a Row");
                System.out.println("5. Exit");

                System.out.println("Enter Your Choice");

                int n = Integer.parseInt(br.readLine());

                switch (n){
                    case 1:
                        String q1 = "Select * from table1";

                        Statement stmt = conn.createStatement();
                        ResultSet set = stmt.executeQuery(q1);

                        while(set.next()){
                            int id = set.getInt(1);
                            String name = set.getString(2);
                            String city = set.getString(3);

                            System.out.println("The name is: " + name + " And the city is " + city);

                        }
                        break;

                    case 2:
                        String q2 = "insert into table1(tName, tCity) values(?,?)";

                        System.out.println("Enter the name of the person");
                        String name = br.readLine();

                        System.out.println("Enter the name of the city");
                        String city = br.readLine();

                        PreparedStatement pstmt = conn.prepareStatement(q2);

                        pstmt.setString(1, name);
                        pstmt.setString(2, city);

                        pstmt.executeUpdate();

                        System.out.println("Inserted");

                        break;

                    case 3:
                        String q3 = "update table1 set tName=?, tCity=? where tid=?";

                        System.out.println("Enter the new person name");
                        String new_name = br.readLine();

                        System.out.println("Enter the new city name");
                        String new_city = br.readLine();

                        System.out.println("Enter the id");
                        int id_to_find = Integer.parseInt(br.readLine());

                        PreparedStatement pstmt2 = conn.prepareStatement(q3);

                        pstmt2.setString(1, new_name);
                        pstmt2.setString(2, new_city);
                        pstmt2.setInt(3, id_to_find);

                        pstmt2.executeUpdate();

                        System.out.println("Updated");
                        break;

                    case 5:
                        flag = false;
                        break;

                    default:
                        System.out.println("Enter a correct choice");
                        break;
                }
            }

            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
