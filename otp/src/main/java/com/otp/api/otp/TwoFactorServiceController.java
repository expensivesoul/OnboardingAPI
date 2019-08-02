package com.otp.api.otp;

import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoFactorServiceController {

	
	@Autowired
	Daoservice daoService;
	@Autowired
	smsservice smsService;
	
//	@RequestMapping(value="/users/{userid}/emails/{emailid}/2fa", method=RequestMethod.PUT) 
//	public ResponseEntity<Object> send2faCodeinEmail(@PathVariable("userid") String id, @PathVariable("emailid") String emailid) throws AddressException, MessagingException {
//		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
//		emailService.sendEmail(emailid, twoFaCode);
//		Daoservice.update2FAProperties(id, twoFaCode);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@RequestMapping("/")
	
	public ResponseEntity<Object> send2faCodeinSMS(@RequestBody user phone) {
		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		smsService.send2FaCode(phone.getToauthphone(), twoFaCode);
		daoService.update2FAProperties(phone.getUsername(), twoFaCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//@PathVariable("userid") String id, @PathVariable("2facode") String code
	@RequestMapping("/2fa") 
	public ResponseEntity<Object> verify(@RequestBody verify phone) {
	
		boolean isValid = daoService.checkCode(phone.getUsername(), phone.getCode());
		
		if(isValid)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}	
	
}