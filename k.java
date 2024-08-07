import java.sql.*;
import java.util.*;

public class k{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter dept. no.: ");
        int dno=sc.nextInt();
        System.out.print("Enter dept. name: ");
        String dname=sc.next();
        System.out.print("Enter dept. location: ");
        String dloc=sc.next();
        sc.close();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
            PreparedStatement pstmt=null;
            String sql="insert into dept(deptno,dname,location) values (?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, dno);
            pstmt.setString(2, dname);
            pstmt.setString(3, dloc);

            int status=pstmt.executeUpdate();
            pstmt.close();
            if(status>0) System.out.println("Record inserted successfully");
            con.close();
        }
    }
}