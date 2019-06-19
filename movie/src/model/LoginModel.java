package model;

import beans.LoginInfoBeans;
import dao.UserDao;

public class LoginModel {

	public LoginInfoBeans login(String id, String passward) {
LoginInfoBeans loginInfo = null;
		
		UserDao userdao = new UserDao();
		try {
			userdao.connect();
			
			loginInfo = userdao.getBy(id,passward);
			
		}catch(Exception e){
			///////////
			//エラーをコンソールログに記録
			e.printStackTrace();
			
		}finally {
			if(userdao !=null) {
				userdao.close();
			}
		}
		
		return loginInfo;
	}

}
