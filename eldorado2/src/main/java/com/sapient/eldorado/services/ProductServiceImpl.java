package com.sapient.eldorado.services;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.eldorado.controllers.ProductController;
import com.sapient.eldorado.entities.Product;
import com.sapient.eldorado.exceptions.EmptyFieldException;
import com.sapient.eldorado.exceptions.InvalidEntryException;
import com.sapient.eldorado.repositories.ProductRepository;

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	static Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

	@Override
	public void addProductService(Product product) throws EmptyFieldException, InvalidEntryException {
		// TODO Auto-generated method stub

		validateProductDetails(product); // Validating Product Details Received

		System.out.println(product);
		productRepository
				.save(new Product(product.getName(), product.getDesc(), product.getCategory(), product.getPrice(),
						product.getQuantity(), product.getImageLinks(), product.getVideoLinks(), product.getPdfLink()));
	}

	public void validateProductDetails(Product product) throws EmptyFieldException, InvalidEntryException {
		// TODO Auto-generated method stub
		System.out.println("hi");
		String name = product.getName();
		String desc = product.getDesc();
		String category = product.getCategory();
		int price = product.getPrice();
		int quantity = product.getQuantity();
		String imageLinks = product.getImageLinks();
		String videoLinks = product.getVideoLinks();
		String pdfLinks = product.getPdfLink();

		validateName(name);
		validateDesc(desc);
		validateCategory(category);
		validateQuantity(quantity);
		validateImageLinks(imageLinks);
		validateVideoLinks(videoLinks);
		validatePdfLinks(pdfLinks);

		log.info("Product Details Validated");
	}

	public void validateName(String name) throws EmptyFieldException, InvalidEntryException {
		String nameregex = "[A-Za-z*-]+";
		if (name.isEmpty())
			throw new EmptyFieldException("Name Field ");

		else if (name.length() > 32)
			throw new InvalidEntryException("Name Field Length Exceeded");
		else if (!Pattern.matches(nameregex, name))
			throw new InvalidEntryException("Name Field Pattern ");
	}

	public void validateDesc(String desc) throws EmptyFieldException {
		if (desc.isEmpty())
			throw new EmptyFieldException("Desc Field ");
	}

	public void validateCategory(String category) throws EmptyFieldException, InvalidEntryException {
		if (category.isEmpty())
			throw new EmptyFieldException("Product Category ");
		else if (!category.equals("Clothes") && !category.equals("Appliances") && !category.equals("Books"))
			throw new InvalidEntryException("Product Category ");
	}

	public void validatePrice(int price) throws InvalidEntryException {
		if (price < 0)
			throw new InvalidEntryException("Product Price ");
	}

	public void validateQuantity(int quantity) throws InvalidEntryException {
		if (quantity < 0)
			throw new InvalidEntryException("Product Quantity ");
	}

	public void validateImageLinks(String imageLinks) throws InvalidEntryException {
		String regeximage = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if (!Pattern.matches(regeximage, imageLinks))
			throw new InvalidEntryException("Image Links ");
	}

	public void validateVideoLinks(String videoLinks) throws InvalidEntryException {
		String regexvideo = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if (!Pattern.matches(regexvideo, videoLinks))
			throw new InvalidEntryException("Video Links ");
	}

	public void validatePdfLinks(String pdfLinks) throws InvalidEntryException {
		String regexpdf = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if (!Pattern.matches(regexpdf, pdfLinks))
			throw new InvalidEntryException("Pdf Links ");
	}

}
