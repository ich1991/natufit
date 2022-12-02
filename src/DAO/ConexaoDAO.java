package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection connectDB () {
		Connection DBconnection = null;
		
		try {
			
			
				
				
				String DBurl="jdbc:mysql://34.95.149.132:3306/Natufit?user=root&password=93546000";
						 
						//"jdbc:mysql://localhost:3306/natufit?user=root&password=slipknot666";
				
			   DBconnection= DriverManager.getConnection(DBurl);
		
			
			
	}catch (SQLException error) {
		JOptionPane.showMessageDialog(null,error.getMessage());
	}
		return DBconnection;
	}

}
