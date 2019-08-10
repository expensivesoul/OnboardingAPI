package com.otp.api.otp;


	import javax.persistence.Entity;

	@Entity
	public class verify {
		private String phone;
		private String code;
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPhone() {
			return phone;
		}

}
