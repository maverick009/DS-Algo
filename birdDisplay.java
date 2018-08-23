import java.sql.*;
import java.util.*;
public class birdDisplay
{
	public static void main(String []args)
	{
		String url = "jdbc:mysql://localhost:3306/employees";
		String user = "root";
		String pass = "root";
		try(Connection conn = DriverManager.getConnection(url,user,pass);Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY))
		{
			System.out.println(conn);
			ResultSet rs = stmt.executeQuery("select emp_no,birth_date from employees limit 10");
			/*Map<Integer,java.time.LocalDate> map = new HashMap<>();
			while(rs.next())
			{
				int emp_no = rs.getInt("emp_no");
				//String fname = rs.getString("first_name");
				java.time.LocalDate l = rs.getDate(2).toLocalDate();
				map.put(emp_no,l);
			}
			System.out.println(map);*/
			int res = stmt.executeUpdate("select count(*) from employees");
			rs.next();
			System.out.println(rs.getInt(1));
			
		}
		/*catch(SQLException e)
		{
			e.printStackTrace();
		}*/
	}
}
