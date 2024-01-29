package com.example.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Product;
import com.example.project.Entity.Supplier;
import com.example.project.Repository.ProductRepository;
import com.example.project.Repository.SupplierRepository;

@Service
public class SupplierImpl implements SupplierService{
@Autowired
	private SupplierRepository suprepo;
@Autowired
    private ProductRepository prorepo;
	@Override
	public String createrecords(Supplier supplier) {
		// TODO Auto-generated method stub
		Supplier c= new Supplier();
		c.setName(supplier.getName());
		c.setEmail(supplier.getEmail());
		c.setMobile(supplier.getMobile());
		c.setPassword(supplier.getPassword());
		suprepo.save(c);
		return "saved successfully";
	}
	@Override
	public String login(Long id,String name, String password) {
		// TODO Auto-generated method stub
		if(suprepo.existsById(id))
		{
			Supplier ss=suprepo.findById(id).get();
			if(ss.getName().equals(name)&&ss.getPassword().equals(password))
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
	@Override
	public String addProductForSupplier(Long supplierId, Product product) {
		// TODO Auto-generated method stub
		Optional<Supplier> optionalSupplier = suprepo.findById(supplierId);
	    if (optionalSupplier.isPresent()) {
	        Supplier seller = optionalSupplier.get();
	        product.setSupplier(seller);
	        seller.addProduct(product);
	        // Save both the seller and the product
	        suprepo.save(seller);
	        prorepo.save(product);
	        return "Product added by the supplier successfully";
	    } else {
	        return "Seller not found";
	    }
	}
	}

	