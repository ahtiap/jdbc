
import java.sql.Connection;

import com.revature.daos.EmployeeDAOImpMySQL;
import com.revature.utils.ConnectionUtils;

public class App {
    public static void main(String[] args) {
    	
        Connection conn = ConnectionUtils.getConnection();
        EmployeeDAOImpMySQL employee= new EmployeeDAOImpMySQL();
//         employee.createEmployeeTable(conn);
//         employee.addEmployee(conn, "Keven", 100_000_000, "Technical Instructor");
//         employee.addEmployee(conn, "John Doe", 100_000, "Developer");
//         employee.addEmployee(conn, "Sue", 200_000, "data analyst");
        
         employee.updateEmployeeById(conn, null, 100_000, "", 1);
        System.out.println(employee.getAllEmployees(conn));

    }

   
}