package com.otp.api.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class Daoservice {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void update2FAProperties(String phone, String twofacode) {
		jdbcTemplate.update("update user set fa_code=?, fa_expire_time=? where phone=?", new Object[] {
				twofacode, (System.currentTimeMillis()/1000) + 120, phone
		});
	}



	public boolean checkCode(String phone, String code) {
		return jdbcTemplate.queryForObject("select count(*) from user where fa_code=? and phone=?"
				+ " and fa_expire_time >=?", new Object[] {code, phone, 
						System.currentTimeMillis()/1000}, Integer.class) >0; 
	}
}