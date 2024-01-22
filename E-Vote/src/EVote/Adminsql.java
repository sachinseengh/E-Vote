package EVote;

import java.util.Date;

class Adminsql{
	
	public void startElection(String position,String candidate_one_name,String candidate_one_img,
			String  candidate_two_name,String candidate_two_img) {
		
		Date date = new Date();
		java.sql.Date votingdate = new java.sql.Date(date.getTime());
		
		try {
		Conn c = new Conn();
		
		String sql = "insert into election values('"+position+"','"+candidate_one_name+"','"+candidate_one_img+"',"
				+ "'"+candidate_two_name+"','"+candidate_two_img+"','"+votingdate+"')";
	  
		c.s.executeUpdate(sql);
		
		}catch(Exception e) {
			
		}
		
	}
	
}