package com.otp.api.otp;


	import javax.persistence.Entity;

	@Entity
	public class verify {
		private String username;
		private String code;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}

}
