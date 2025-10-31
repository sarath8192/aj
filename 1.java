




import java.sql.*;

public class StudentJDBCApp 
{

    public static void main(String[] args) 
{
        String url = "jdbc:mysql://localhost:3306/testdb?";
        String user = "testuser";
        String password = "testpass"; 

        try {
            

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS Student ("
                               + "RollNo INT PRIMARY KEY, "
                               + "Name VARCHAR(50), "
                               + "Address VARCHAR(100))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully.");

            stmt.executeUpdate("INSERT INTO Student VALUES (1, 'Ravi', 'Hyderabad')");
            stmt.executeUpdate("INSERT INTO Student VALUES (2, 'Sita', 'Chennai')");
            stmt.executeUpdate("INSERT INTO Student VALUES (3, 'Kiran', 'Bangalore')");
            System.out.println("Initial records inserted.");

            System.out.println("\nInitial Records:");
            displayRecords(stmt);

            stmt.executeUpdate("INSERT INTO Student VALUES (4, 'Meena', 'Pune')");
            stmt.executeUpdate("INSERT INTO Student VALUES (5, 'Ramesh', 'Mumbai')");
            System.out.println("\nTwo new records inserted.");

           stmt.executeUpdate("UPDATE Student SET Address = 'Delhi' WHERE RollNo = 2");
           System.out.println("One record updated.");

            stmt.executeUpdate("DELETE FROM Student WHERE RollNo = 3");
            System.out.println("One record deleted.");

            System.out.println("\nFinal Records:");
            displayRecords(stmt);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void displayRecords(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
        System.out.println("RollNo\tName\tAddress");
        while (rs.next()) {
            int roll = rs.getInt("RollNo");
            String name = rs.getString("Name");
            String address = rs.getString("Address");
            System.out.println(roll + "\t" + name + "\t" + address);
        }
    }
}
