package jsontest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jsontest.model.*;
import jsontest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import jsontest.service.JwtTokenUtil;

@CrossOrigin
@RestController
@RequestMapping("/final")
@Api(value="test")
public class Usercontroller {

    @Autowired
    Userservice service;
    @Autowired
    Daoservice daoService;
    @Autowired
    smsservice smsService;
    @Autowired
    JwtTokenUtil jwttokenUtil;


    @ApiOperation(value = "Save the new user record")
    @PostMapping("/save")
    public ResponseEntity<Object> usersave(@RequestBody User User){

       if(!service.PhoneExist(User.getPhone())){
            service.usersave(User);
           return new ResponseEntity<>(HttpStatus.OK);

       }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @ApiOperation(value = "Assign checklist to user from User view")
    @PostMapping("/assign")
    public void insertQuery(@RequestBody Map<String,String> checkdata) {
       // boolean isFound = input.indexOf("Android") !=-1? true: false;
        boolean isFound = checkdata.get("selections").indexOf(",") !=-1? true: false;
        if(!isFound){
            service.updatecheck(checkdata.get("phone"), checkdata.get("selections"));
            smsService.assign(checkdata.get("phone"));
        }else{
            System.out.println(checkdata);
            String[] value=checkdata.get("selections").split(",");
            for (int i=0;i<value.length;i++) {
                service.updatecheck(checkdata.get("phone"), value[i]);
                smsService.assign(checkdata.get("phone"));
            }}
    }

    @ApiOperation(value = "Display all user records", response = List.class)
    @GetMapping("/listuser")
    public List<Userdetails> userlist(){

        return service.userlist();//    @PostMapping("/authenticate")

    }
//Akshay's changes
@ApiOperation(value = "Phone login function", response = ResponseEntity.class)
    @RequestMapping("/phone")

    public ResponseEntity<Object> send2faCodeinSMS(@RequestBody User phone1) {
        String twoFaCode = String.valueOf(new Random().nextInt(9000) + 1000);
       smsservice.send2FaCode(phone1.getPhone(), twoFaCode);
        System.out.println(phone1.getPhone()+"TEST"+twoFaCode);
        daoService.update2FAProperties(phone1.getPhone(), twoFaCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "To verify the OPT and Phone for the user", response = ResponseEntity.class)
	//@PathVariable("userid") String id, @PathVariable("2facode") String code
	@RequestMapping("/check")
	public ResponseEntity<Object> verify(@RequestBody User phone) {

		boolean isValid = daoService.checkCode(phone.getPhone(), phone.getFa_code());
		//List l=daoService.findAll();
        System.out.println(phone.getPhone()+"shaystorm" +phone.getFa_code());
		if (isValid) {
			final String token =jwttokenUtil.generateToken(phone.getPhone());
        System.out.println(("generatedtoken"+token));
			return ResponseEntity.ok(new JwtResponse(token));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}






    @ApiOperation(value = "Return user data according to submitted JWT token", response = ResponseEntity.class)
    @PostMapping ("/data")
    public List<Usercheckdata> data(@RequestHeader Map<String, String> phone) {
            System.out.println("Generated Token"+phone.get("phone"));

                    String isValid = JwtTokenUtil.getUsernameFromToken(phone.get("token"));

                    return service.data(isValid);

    }

    @PostMapping ("/namefromphone")
    public HashMap<String,String> getnamefromphone(@RequestHeader Map<String, String> phone) {
        System.out.println("Generated Token"+phone);

        String isValid = JwtTokenUtil.getUsernameFromToken(phone.get("token"));
        String check=service.getname(isValid);
        HashMap<String, String> mapOfWords = new HashMap<String, String>() {
            {
                put("Name",service.getname(isValid) );

            }
        };
        System.out.println("check value"+check);
        return mapOfWords;

    }
    //Returns the checklist assigned
    @PostMapping ("/data1")
    public List<Usercheckdata> data1(@RequestBody Map<String, String> phone) {
        System.out.println("Generated Token"+phone.get("phone"));

        return service.data(phone.get("phone"));
    }



//Returns user Specific checklist as per User's Number
    @ApiOperation(value = "user Specific checklist as per User's Number ", response = ResponseEntity.class)
    @PostMapping("/usercheck")
    public List<Usercheckdata> usercheck(@RequestBody User phone){

        return service.usercheck(phone);
    }
//update the user's checklist contact
    @ApiOperation(value = "Update User's checklist data")
    @PostMapping("/updatecheck")
    public Usercheckdata userchecksave(@RequestBody Usercheckdata User){

        return service.userchecksave(User);
    }
    // Assign Checklists to multiple phone numbers
    @PostMapping("/assignnew")
    public String[] insertQuerybycheckilist(@ApiParam(value = "User phone number and checklists to be assigned", required = true)
                                        @RequestBody Map<String,String> checkdata) {
        System.out.println(checkdata);
        String[] phone=checkdata.get("selections").split(",");
        System.out.println("phone"+phone);
        String[] already=new String[10];
        System.out.println(checkdata.get("name"));
//String[] c=checkdata.get("selections").split(",");
        for (int i=0;i<phone.length;i++) {
            if(service.alreadyassign(phone[i],checkdata.get("name")))
            {
                System.out.println("alreaadyydyd"+ checkdata.get(phone[i]));
            service.updatecheck( phone[i],checkdata.get("name"));
            smsService.assign(phone[i]);}
            else{
                //String[] already=new String[phone.length];
                already[i]=checkdata.get(phone[i]);
                System.out.println("alreaadyydyd"+ checkdata.get(phone[i]));

            }

        }
        if(already.length==0)return already;
        else{
            return already;
        }
    }
//Return Names with Phone of records
    @GetMapping("/nameandphone")
    public List<NameAndPhone> nameandphone(){
        return service.nameandphone();
    }
    @PostMapping("/countrecords")
    public int countint(@RequestBody Usercheckdata User){

        return service.usercheckcount(User.getPhone());
    }
 // To Register new Admin
    @PostMapping("/register")
    public void userRegister(@RequestBody UserDto user){

         service.userRegister(user);

    }
//To  Authenticate Admin's credentials
    @PostMapping("/authenticate")
    public ResponseEntity<Object> countuser(@RequestBody UserDto user) {

        String pass=service.findpass(user.getUsername());
        boolean status=service.checkpass(user.getPassword(),pass);

        if (status) {
            final String token =jwttokenUtil.generateToken(user.getUsername());
            System.out.println(("generatedtoken"+token));
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }
}
