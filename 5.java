import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "testpass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement insertStmt = con.prepareCall("{call insert_employee(?, ?, ?)}");
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Ravi");
            insertStmt.setDouble(3, 5000.0);
            insertStmt.execute();
            System.out.println("Employee inserted successfully!");

            CallableStatement getSalStmt = con.prepareCall("{call get_salary(?, ?)}");
            getSalStmt.setInt(1, 101);
            getSalStmt.registerOutParameter(2, Types.DOUBLE);
            getSalStmt.execute();

            double salary = getSalStmt.getDouble(2);
            System.out.println("Salary for Employee 101 is: " + salary);

            getSalStmt.close();
            insertStmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
