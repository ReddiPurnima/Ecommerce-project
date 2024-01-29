package com.example.project.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DTO.NewpasswordRequest;
import com.example.project.Entity.Customer;
import com.example.project.Entity.OTPVerificationRequest;
import com.example.project.Repository.CustomerRepository;
import com.example.project.Service.CustomerService;
import com.example.project.Service.EmailService;
import com.example.project.Service.OTPService;
import com.example.project.Service.Registerclass;
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custser;
	@Autowired
	private Registerclass registerclass;
	@Autowired
	private OTPService otpService;
	
	private Map<String, Boolean> otpVerificationMap = new HashMap<>();
    @Autowired
	private EmailService emailService;
    @Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerRepository custrepo;
	@PostMapping("/register")
	public ResponseEntity<String> createrecord(@RequestBody Customer customer)
	{
		return new ResponseEntity<String>(custser.createrecords(customer),HttpStatus.CREATED);
	}
	@PostMapping("/customerregistration")
	public ResponseEntity<String> register(@RequestBody Customer customer)
	{
		return registerclass.savecustomer(customer);
	}
	@PostMapping("/customer/sendotp")
	public ResponseEntity<String> sendOtp(@RequestBody Customer customer) {
		String userEmail=customer.getEmail();
		Customer cu=registerclass.findByEmail(userEmail);
		if(cu==null) {
			String otp=otpService.generateOtp(userEmail);
			emailService.sendOtpEmail(userEmail, otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return ResponseEntity.badRequest().body("Email is already registered.");
			
		}
	}
		
	@PostMapping("/customerrs/verify-otp")
    public ResponseEntity<String> verifyOtp( @RequestBody  OTPVerificationRequest verificationRequest) {
        String otp=verificationRequest.getOtp();
        String email=verificationRequest.getEmail();
        System.out.println(otp+email);

        if (otpService.validateOtp(email, otp)) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("incorrect OTP.");

}
	}
	@GetMapping("get/{id}")
	public ResponseEntity<String> loginpage(@PathVariable Long id,@RequestBody Map<String, String> request)
	{
		String name=request.get("name");
		String password=request.get("password");
		return new ResponseEntity<String>(custser.login(id, name, password),HttpStatus.OK);
	}
	
	@PostMapping("/Forgotpassword/sendotp")
	public ResponseEntity<String> sendotp(@RequestBody Customer request) {
		String userEmail=request.getEmail();
		Customer cu=registerclass.findByEmail(userEmail);
		if(cu!=null) {
			String otp=otpService.generateOtp(userEmail);
			emailService.sendOtpEmail(userEmail, otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return ResponseEntity.badRequest().body("Email is not registered.");
			
		}
	}
	
	@PostMapping("/resetpassword/{email}")
	public ResponseEntity<String> resetpassword(@RequestBody NewpasswordRequest request,@PathVariable String email) {
		String newpassword =request.getNewpassword();
		String confirmedpassword=request.getConfirmedpassword();
		Customer cust=registerclass.findByEmail(email);
		if(cust==null) {
			return ResponseEntity.badRequest().body("Customer not found");
		}  
		if(!(newpassword.equals(confirmedpassword))) {
			return ResponseEntity.badRequest().body("Passwords do not matched");
		}
		String encoddedpassword=passwordEncoder.encode(newpassword);
		cust.setPassword(encoddedpassword);
		custrepo.save(cust);
		return ResponseEntity.ok("Password resetted successfully");
	}
}


