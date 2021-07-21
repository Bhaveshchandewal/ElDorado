package com.sapient.eldorado;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.eldorado.entities.Product;
import com.sapient.eldorado.exceptions.EmptyFieldException;
import com.sapient.eldorado.exceptions.InvalidEntryException;
//import com.sapient.eldorado.exceptions.EmptyFieldException;


@SpringBootTest
class EldoradoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void validProductName(){
		Product product=new Product();
		String name = "";
		assertThrows(EmptyFieldException.class,()->product.setName(name));
	}
	
	@Test
	public void validProductDescription(){
		Product product=new Product();
		String desc = "";
		assertThrows(EmptyFieldException.class,()->product.setDesc(desc));
	}
	@Test
	public void validProductQuantity(){
		Product product=new Product();
		int quantity = -1;
		assertThrows(InvalidEntryException.class,()->product.setQuantity(quantity));
	}
	@Test
	public void validProductPrice(){
		Product product=new Product();
		int price = -1;
		assertThrows(InvalidEntryException.class,()->product.setPrice(price));
	}
	
	@Test
	public void validProductImageLinks(){
		Product product=new Product();
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class,()->product.setImageLinks(link));
	}

	@Test
	public void validProductVideoLinks(){
		Product product=new Product();
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class,()->product.setVideoLinks(link));
	}

	@Test
	public void validProductPdfLinks(){
		Product product=new Product();
		String link = "http://www.example.com/ %26here.html";
		assertThrows(InvalidEntryException.class,()->product.setPdfLinks(link));
	}


}
