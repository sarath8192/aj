 
import java.sql.*; 
 
 public class SResultSet{ 
    public static void main(String[] args) throws Exception { 
        String url = “jdbc:mysql://localhost:3306/testdb?”; 
        String user = “testuser”; 
        String password = “testpass”; 
 
        try{ 
 
        Class.forName("com.mysql.cj.jdbc.Driver"); 
 
        Connection con = DriverManager.getConnection(url, user, password); 
 
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
 
        ResultSet rs = st.executeQuery("SELECT * FROM Student"); 
 
        System.out.println("Records in Forward Direction:"); 
        System.out.println("RollNo\tName\t\tAddress"); 
        System.out.println("------------------------------"); 
 
        while (rs.next()) { 
            System.out.println( 
                rs.getInt("RollNo") + "\t" + 
                rs.getString("Name") + "\t\t" + 
                rs.getString("Address") 
            ); 
        } 
 
        System.out.println("\nRecords in Backward Direction:"); 
        System.out.println("RollNo\tName\t\tAddress"); 
        System.out.println("------------------------------"); 
 
        while (rs.previous()) { 
            System.out.println( 
                rs.getInt("RollNo") + "\t" + 
                rs.getString("Name") + "\t\t" + 
                rs.getString("Address") 
            ); 
        } 
 
        rs.first(); 
        System.out.println("\nFirst Record:"); 
        System.out.println( 
            "Row " + rs.getRow() + ": " + 
            rs.getInt("RollNo") + "\t" + 
            rs.getString("Name") + "\t\t" + 
            rs.getString("Address") 
        ); 
 
        rs.last(); 
        System.out.println("\nLast Record:"); 
        System.out.println( 
            "Row " + rs.getRow() + ": " + 
            rs.getInt("RollNo") + "\t" + 
            rs.getString("Name") + "\t\t" + 
            rs.getString("Address") 
        ); 
 
        rs.relative(-1); 
        System.out.println("\n2nd Record from Last:"); 
        System.out.println( 
            "Row " + rs.getRow() + ": " + 
            rs.getInt("RollNo") + "\t" + 
            rs.getString("Name") + "\t\t" + 
            rs.getString("Address") 
        ); 
 
        rs.absolute(2); 
        System.out.println("\n2nd Record from Beginning:"); 
        System.out.println( 
            "Row " + rs.getRow() + ": " + 
            rs.getInt("RollNo") + "\t" + 
            rs.getString("Name") + "\t\t" + 
            rs.getString("Address") 
        ); 
        con.close(); 
    } catch (Exception e) {
                         e.printStackTrace();
}
}
}

