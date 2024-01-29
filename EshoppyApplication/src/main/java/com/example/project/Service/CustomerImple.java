package com.example.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Customer;
import com.example.project.Repository.CustomerRepository;

@Service
public class CustomerImple implements CustomerService{
@Autowired
	private CustomerRepository custrepo;
	@Override
	public String createrecords(Customer customer) {
		// TODO Auto-generated method stub
		Customer c= new Customer();
		c.setName(customer.getName());
		c.setEmail(customer.getEmail());
		c.setMobile(customer.getMobile());
		c.setPassword(customer.getPassword());
		custrepo.save(c);
		return "regitered successfully";
}
	@Override
	public String login(Long id, String name, String password) {
		// TODO Auto-generated method stub
		if(custrepo.existsById(id))
		{
			Customer cc=custrepo.findById(id).get();
			if(cc.getName().equals(name)&&cc.getPassword().equals(password))
			{
				return "login successfully";
			}
			else
			{
				return "invalid username or password";
			}
		}
		return "id not registered";
	}
	}


