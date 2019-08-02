package com.otp.api.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class Daoservice {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void update2FAProperties(String username, String twofacode) {
		jdbcTemplate.update("update user set fa_code=?, fa_expire_time=? where firstname=?", new Object[] {
				twofacode, (System.currentTimeMillis()/1000)+120 , username
		});
	}



	public boolean checkCode(String name, String code) {
		return jdbcTemplate.queryForObject("select count(*) from user where fa_code=? and firstname=?"
				+ " and fa_expire_time >=?", new Object[] {code, name, 
						System.currentTimeMillis()/1000}, Integer.class) >0; 
	}
}