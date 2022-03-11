import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePayrollPreparedStmt {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root",
					"tiger");

			// Select Query
			String selectQuery = "SELECT * FROM employee_payroll ";
			PreparedStatement selectStmt = con.prepareStatement(selectQuery);
			ResultSet rs = selectStmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getCharacterStream(3) + " | "
						+ rs.getDouble(4) + " | " + rs.getDate(5) + " | " + rs.getString(6) + " | " + rs.getString(7)
						+ " | " + rs.getString(8) + " | " + rs.getDouble(9) + " | " + rs.getDouble(10) + " | "
						+ rs.getDouble(11) + " | " + rs.getDouble(12) + " | " + rs.getDouble(13));
			}

			// Select Query for startDate in range
			String selectQueryForDate = "select * from employee_payroll WHERE startDate BETWEEN'2004-01-01' AND '2020-01-01';";
			PreparedStatement selectStmtForDate = con.prepareStatement(selectQueryForDate);
			ResultSet rs1 = selectStmtForDate.executeQuery();
			while (rs1.next()) {
				System.out.println(rs1.getInt(1) + " | " + rs1.getString(2) + " | " + rs1.getCharacterStream(3) + " | "
						+ rs1.getDouble(4) + " | " + rs1.getDate(5) + " | " + rs1.getString(6) + " | "
						+ rs1.getString(7) + " | " + rs1.getString(8) + " | " + rs1.getDouble(9) + " | "
						+ rs1.getDouble(10) + " | " + rs1.getDouble(11) + " | " + rs1.getDouble(12) + " | "
						+ rs1.getDouble(13));
			}

			// Sum of Salaries
			String selectQueryForSum = "SELECT SUM(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
			PreparedStatement selectStmtForSum = con.prepareStatement(selectQueryForSum);
			ResultSet sum = selectStmtForSum.executeQuery();
			while (sum.next()) {
				System.out.println("Sum of Salaries = " + sum.getDouble(1));
			}

			// Average of Salaries
			String selectQueryForAvg = "SELECT AVG(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
			PreparedStatement selectStmtForAvg = con.prepareStatement(selectQueryForAvg);
			ResultSet avg = selectStmtForAvg.executeQuery();
			while (avg.next()) {
				System.out.println("Averag Salary = " + avg.getDouble(1));
			}

			// Minimum Salary
			String selectQueryForMin = "SELECT MIN(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
			PreparedStatement selectStmtForMin = con.prepareStatement(selectQueryForMin);
			ResultSet min = selectStmtForMin.executeQuery();
			while (min.next()) {
				System.out.println("Minium Salary = " + min.getDouble(1));
			}

			// Maximum Salary
			String selectQueryForMax = "SELECT MAX(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
			PreparedStatement selectStmtForMax = con.prepareStatement(selectQueryForMax);
			ResultSet max = selectStmtForMax.executeQuery();
			while (max.next()) {
				System.out.println("Maximum Salary = " + max.getDouble(1));
			}

			// Count
			String countSelectQuery = "SELECT COUNT(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
			PreparedStatement countSelectStmt = con.prepareStatement(countSelectQuery);
			ResultSet count = countSelectStmt.executeQuery();
			while (count.next()) {
				System.out.println("Count = " + count.getDouble(1));
			}

			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
