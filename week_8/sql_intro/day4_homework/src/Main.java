import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/EmployeeManagementSystem";
        String username = "postgres";
        String password = "dradis50461!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employeeId");
                String employeeName = resultSet.getString("employeeName");
                int departmentId = resultSet.getInt("departmentId");

                System.out.print(employeeId);
                System.out.print(employeeName);
                System.out.print(departmentId);
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Employee newEmployee = new Employee(9, "Daniel Moreno", 3);
        Employee amandaEmployee = Employee.getEmployeeByName("Amanda Taylor"); // static method can be called without any preexisting info
    }
}
