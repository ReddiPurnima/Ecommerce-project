package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.CartItem;
import com.example.project.Service.CartServiceImple;

@RestController
@RequestMapping("/cart")
public class CartController {
	private final CartServiceImple cartService;
	@Autowired
	public CartController(CartServiceImple cartService) {
		this.cartService = cartService;
	}
	  @PostMapping("/addtocart")
	    public ResponseEntity<String> addProductToCart(@RequestParam Long productId, @RequestParam int quantity) {
	       return ResponseEntity.accepted().body(cartService.addProductToCart(productId, quantity));
	    }
	  @GetMapping("/allcart")
	  public ResponseEntity<List<CartItem>> viewAllCartProducts()
	  {
		  return new ResponseEntity<>(cartService.getAllproductsincart(),HttpStatus.OK);
	  }
	  @DeleteMapping("/removeProduct/{cartItemId}")
	    public ResponseEntity<String> removeProductFromCartItem(@PathVariable Long cartItemId) {
	        String result = cartService.removeProductFromCartItem(cartItemId);
	        return ResponseEntity.ok(result);
	    }
}

