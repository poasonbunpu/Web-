package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.LoginInfoBeans;

public class UserDao extends DaoBase{
public LoginInfoBeans getBy(String id,String passward) throws SQLException{
		
		if(con == null) {
			return null;
		}
		LoginInfoBeans loginInfo = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("SELECT user_id,age,nickname,"
					                  + " FROM user"
					                  + " WHERE user_id=? AND password=?");
			
			stmt.setString(1, id);
			stmt.setString(2, passward);
			rs = stmt.executeQuery();
		    
			///////////////
		    //DBから値の取得
			while(rs.next()) {
				loginInfo = new LoginInfoBeans();
				
				loginInfo.setUserId(rs.getString("user_id"));
				loginInfo.setAge(rs.getString("age"));
				loginInfo.setNickName(rs.getString("nickname"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				System.out.println("closeに失敗しました");
			}
		}
		
		return loginInfo;
		
	}
}
