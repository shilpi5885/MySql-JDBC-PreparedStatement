import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayrollJDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			System.out.println("Connecting to database");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root",
					"tiger");
			System.out.println("Connectiion is successful");
			Statement stmt = con.createStatement();
			String updateQuery = "UPDATE employee_payroll SET salary = 3000000.00 WHERE name = 'Terissa';";
			int count = stmt.executeUpdate(updateQuery);
			System.out.println(count);
			String selectQuery = "SELECT * from employee_payroll;";
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getCharacterStream(3) + " | "
						+ rs.getDouble(4) + " | " + rs.getDate(5) + " | " + rs.getString(6) + " | " + rs.getString(7)
						+ " | " + rs.getString(8) + " | " + rs.getDouble(9) + " | " + rs.getDouble(10) + " | "
						+ rs.getDouble(11) + " | " + rs.getDouble(12) + " | " + rs.getDouble(13));
			}

			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
