import java.sql.*;

public class DBConnect {
    Connection con = null;
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/jdbcpractice";

    public static void main(String args[]) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO `studentdetials`(`serial`, `name`, `age`, `phone`, `height`) VALUES (1,'manoj',22,999,7)";
        DatabaseConnetivityExample dce = new DatabaseConnetivityExample();
        Connection connection = dce.createConnection();
        if (connection != null) {
            System.out.println("Database Connection Is Established");
            try {
                ps = connection.prepareStatement(sql);
                int i = ps.executeUpdate();
                if (i > 0) {
                    System.out.println("Data Inserted into database table Successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Connection createConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}