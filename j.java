import java.sql.*;
import java.util.*;

public class j {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Dept. number: ");
        int dn = sc.nextInt();
        sc.close();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
            Statement stmt = con.createStatement();

            String sql = "select ename from emp where dptno=" + dn + " order by ename asc";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            System.out.println("ename");
            while (rs.next()) {
                System.out.println(rs.getString(1)); // Column index starts from 1
            }
            rs.close();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}