import java.sql.*;

public class Employee {
    static int employeeId;
    static String employeeName;
    static int departmentId;

    String url = "jdbc:postgresql://localhost:5432/EmployeeManagementSystem";
    String username = "postgres";
    String password = "dradis50461!";

    public Employee(int employeeId, String employeeName, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.createEmployeeInDatabase(employeeId, employeeName, departmentId);
    }

    public static int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public static Employee getEmployeeByName(String name) {
        String sqlQuery = "SELECT employeeId, employeeName, departmentId FROM Employee WHERE empoloyeeName = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Employee(resultSet.getInt("employeeId"), resultSet.getString("employeeName"),
                        resultSet.getInt("departmentId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createEmployeeInDatabase(int employeeId, String employeeName, int departmentId) {
        String sqlQuery = "INSERT INTO EMPLOYEE (employeeId, employeeName, departmentId) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, Employee.getEmployeeId());
            statement.setString(2, Employee.getEmployeeName());
            statement.setInt(3, Employee.getDepartmentId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Employee updateEmployee(int employeeId) {
        String query = "UPDATE employee SET employeeName = ?, departmentId = ? WHERE employeeId = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, Employee.getEmployeeName());
            preparedStatement.setInt(2, Employee.getDepartmentId());
            preparedStatement.setInt(3, Employee.getEmployeeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Employee deleteEmployee(int employeeId) {
        String query = "DELETE FROM employee WHERE employeeId = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
