package otpmaeven.otpM;



import java.util.Random;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;;




@RestController
public class servicecontroller {

	
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
	
	@RequestMapping("/phone")
	
	public ResponseEntity<Object> send2faCodeinSMS(@RequestBody User phone1) {
		String twoFaCode = String.valueOf(new Random().nextInt(9000) + 1000);
		smsService.send2FaCode(phone1.getPhone(), twoFaCode);
		System.out.println(phone1.getPhone()+"sidvviuwvciwvciw"+twoFaCode);
		daoService.update2FAProperties(phone1.getPhone(), twoFaCode);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	//@PathVariable("userid") String id, @PathVariable("2facode") String code
	@RequestMapping("/check") 
	public ResponseEntity<Object> verify(@RequestBody verify phone) {
	
		boolean isValid = daoService.checkCode(phone.getPhone(), phone.getCode());
		//List l=daoService.findAll();
		if(isValid)
		{
			final String token = JwtTokenUtil.generateToken(phone.getPhone());

			return ResponseEntity.ok(new JwtResponse(token));
		}
		
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}	


	
}