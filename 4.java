5. Design a JDBC application which will demonstrate Updatable ResultSet functionality.
import java.sql.*;

class UResultSet{
    public static void main(String[] args) throws Exception {
        String url = “jdbc:mysql://localhost:3306/testdb?”;
        String user = “testuser”;
        String password = “testpass”;

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = st.executeQuery("SELECT * FROM Student");

       
        rs.last();            
        rs.deleteRow();       
        System.out.println("Last student record deleted successfully.");

       
        rs.moveToInsertRow();
        rs.updateInt("RollNo", 105);           
        rs.updateString("Name", "John Doe");   
        rs.updateString("Address", "Hyderabad"); 
        rs.insertRow();                       
        System.out.println("New student record inserted successfully.");

        
        con.close();
    }
}
