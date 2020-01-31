package com.lti.register;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.ws.Response;

import com.lti.model.RegisterM;

public class RegisterDao {

	
		
	
	public boolean insert(RegisterM rm){
		
		Connection conn=null;
		try{
			//step 1 Load the jdbc driver
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DatabaseMetaData dbms=conn.getMetaData();
			//step2 Establishing conn with database
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="hr";
			conn= DriverManager.getConnection(url,user,pass);
			
			String sql= "insert into TBL_REG values(?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(sql);
			
			
			st.setString(1, rm.getName());
			st.setString(2, rm.getEmail());
			st.setString(3, rm.getPass());
			st.setString(4, rm.getCity());
			st.executeUpdate();
			
			return true;
			
	}
	
	catch(ClassNotFoundException  | SQLException e){
		e.printStackTrace();
		return false;
	}
	
	finally{
		try{conn.close();}catch(Exception e){ }
	}
		
	}
	
	public ResultSet Search(String city){
		PreparedStatement stmt;
		//PrintWriter out = response.getWriter() ;
		Connection conn=null;
		try{
			//step 1 Load the jdbc driver
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DatabaseMetaData dbms=conn.getMetaData();
			//step2 Establishing conn with database
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="hr";
			conn= DriverManager.getConnection(url,user,pass);
			
			
			 stmt = conn.prepareStatement("select * from TBL_REG  where city= ?");
			 stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			
			return rs;
			
			//while(rs.next()){
			//	 System.out.println("NAME"+rs.getString("NAME") +" email "+rs.getString("EMAIL")+ " Password "+rs.getString("PASSWORD")+ " city "+rs.getString("CITY"));
			// }
			
			
			
	}
	
	catch(ClassNotFoundException  | SQLException e){
		e.printStackTrace();
		
	}
	
	
		return null;
		
	}
}

