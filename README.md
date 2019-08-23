# OnboardingAPI
This has two API modules for react.native and react.js.
#react.native
#made for otp login and user interactions
authentication type: OTP verification+JWT token
Third party API: Twilio for Sendning SMS(otp)
Database:MySQl
prerequisites:twilio account and credentials
Flow:
1.open otpdone in any IDE(InteliJ,STS,Netbeans,etc)
2.go to application.yml in Resources, alter your datasource path and configuration.
3.create  "user" table with two extra fields with fa_code and fa_expiretime //for storing otp and 	its expiry time
4.Run the program from applcation.java

Things to remember:
	1.phone number must be registered in twilio account as well as in "user" table. 
	2.JWT will be generated with static method.


#react.js
#made for blog,faq and admin login
authentication type: User credentials+JWT token
Database:MySQl
FLow:
1.just open the program in any IDE and run application.java

