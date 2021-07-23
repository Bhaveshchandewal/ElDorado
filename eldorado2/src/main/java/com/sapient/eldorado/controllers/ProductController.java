package com.sapient.eldorado.controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.eldorado.entities.Product;
import com.sapient.eldorado.exceptions.EmptyFieldException;
import com.sapient.eldorado.exceptions.InvalidEntryException;
import com.sapient.eldorado.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productservice;

	static Logger log = Logger.getLogger(ProductController.class.getName());
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	public void validateInputProduct(Product product) {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Product>> violations = validator.validate(product);
    if (!violations.isEmpty()) {
    	for (ConstraintViolation<Product> violation : violations) {
    		   log.error(violation.getMessage()); 
    	}
      throw new ConstraintViolationException(violations);
     
    }
	}

	@GetMapping("/")
	public String hello() {
		log.info("Greeting from Product Controller Hello");
		return "Hello";
	}

	@PostMapping("/admin/product")
	public void addProduct(@Valid @RequestBody Product product,BindingResult result) {
//		if(bindingResult.hasErrors())
//		    throw new InvalidEntryException("Invalid Product ");
//		List<FieldError> errors = result.getFieldErrors();
//		   for (FieldError error : errors ) {
//		     log.error(error.getDefaultMessage());
//		   } 
		try {
			//validateInputProduct(product);
			productservice.addProductService(product);
			if (product != null)
				log.info("Product Added Successfully");
			else
				log.info("Product Details Not Recieved");
		} catch (EmptyFieldException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		} catch (InvalidEntryException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		}
//		catch (ConstraintViolationException e) {
//			// TODO Auto-generated catch block
//			log.error(e.getMessage());
//		}
	}

}
