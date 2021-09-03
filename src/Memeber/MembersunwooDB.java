package Memeber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MembersunwooDB {
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dsjin123";
	private String pwd = "1234";
	public void DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

public int updateData(String id,String name,String password,String addr,String reply) {
	int result=0;
	Connection con=null;
	PreparedStatement ps=null;
	String sql="update teamMember set name=?,password=?,addr=?,reply=? where id=?";
	try {
		con=DriverManager.getConnection(url,this.id,pwd);
		ps=con.prepareStatement(sql);
		ps.setString(5, id);
		ps.setString(4, reply);
		ps.setString(3,addr);
		ps.setString(2, password);
		ps.setString(1, name);
		result = ps.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
}