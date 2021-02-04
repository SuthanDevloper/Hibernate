import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		CallableStatement cst = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","suthan");
			cst = con.prepareCall("{call getSal(?,?)}");
			cst.setFloat(1, 141);
			//cst.setFloat(2, 112);
			cst.registerOutParameter(2,Types.FLOAT);
			cst.execute();
			System.out.println(cst.getFloat(1));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				cst.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
