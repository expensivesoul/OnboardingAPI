package jsontest.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jsontest.model.Usercheckdata;
import jsontest.model.Userdetails;
import jsontest.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class smsservice {
	@Autowired
	Userservice userservice;

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
				"Hi"+mobile+"Your Two Factor Authentication code is: "+ twoFaCode).create();
		
		return true;
		
	}


//	public List<Usercheckdata> data(String phone) {
//		return (List<Usercheckdata>) repo.data(phone);
//
//	}

    public  boolean assign(String phone) {
		String name1= userservice.getname(phone);
		//String name=name1.getName();

		Message.creator(new PhoneNumber(phone), new PhoneNumber("+17244715038"),
				"Hi "+name1+"  you have been assigned new checklist ,please check your OnBoarding Application" +
						"please download the app from \n link:\n" +
						"https://drive.google.com/open?id=1hp7ZgXRxCpmBO73cawcVldWlM4ioXE9M").create();

		return true;
    }
}
