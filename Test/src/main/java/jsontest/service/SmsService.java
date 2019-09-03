package jsontest.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class smsservice {

	private final static String ACCOUNT_SID = "AC50141e72d3e82f3f867b152ba6b9739d";
	private final static String AUTH_ID = "e5b6c0ce1495c9cef4064020939cc209";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}
//	
//	public boolean send2FaCode(String mobilenumber, String twoFaCode) {
//		
//		Message.creator(new PhoneNumber(mobilenumber), new PhoneNumber("<TWILIO FROM NUMBER>"),
//				"Your Two Factor Authentication code is: "+ twoFaCode).create();
//		
//		return true;
//		
//		
//	}

	public static boolean send2FaCode(String mobile, String twoFaCode) {

		Message.creator(new PhoneNumber(mobile), new PhoneNumber("+17244715038"),
				"Hi "+mobile+"Your Two Factor Authentication code is: https://play.google.com/store/apps/details?id=com.whatsapp&hl=en_IN//"+ twoFaCode).create();

		return true;
		
	}
	public static boolean sendConfirmation(String mobile, String name) {

		Message.creator(new PhoneNumber(mobile), new PhoneNumber("+17244715038"),
				"Hi" + name + "" +
						" Contratulations!! Welcome Aboard, please download this Nineleaps Onbaording application for further Contacts\nlink:www.google.com").create();

		return true;

		}
	}
