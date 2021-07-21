package com.sapient.eldorado.entities;

import java.util.regex.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.sapient.eldorado.exceptions.*;

@Document(collection = "product_details")
public class Product {
	@Id
	private String id;
	private String name;
	private String desc;
	private String category;
	private int price;
	private int quantity;
	private String imageLinks;
	private String videoLinks;
	private String pdfLink;
	
	public Product() {
	}
	
	public Product(String name, String desc, String category, int price, int quantity, String imageLinks,
			String videoLinks, String pdfLink) {
		super();
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.imageLinks = imageLinks;
		this.videoLinks = videoLinks;
		this.pdfLink = pdfLink;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws EmptyFieldException, InvalidEntryException {
		if(name=="")
			throw new EmptyFieldException("name field");
		else if(name.length()>32)
			throw new InvalidEntryException("name field");
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) throws EmptyFieldException {
		if(desc=="")
			throw new EmptyFieldException("desc field");
		this.desc = desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) throws EmptyFieldException {
		if(category=="")
			throw new EmptyFieldException("category field");
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) throws InvalidEntryException {
		if(price<0)
			throw new InvalidEntryException("product price");
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) throws InvalidEntryException {
		if(quantity<0)
			throw new InvalidEntryException("product quantity");
		this.quantity = quantity;
	}
	public String getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(String imageLinks) throws InvalidEntryException  {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if(!Pattern.matches(regex, imageLinks)) 
			throw new InvalidEntryException("image links");
		this.imageLinks = imageLinks;
	}
	public String getVideoLinks() {
		return videoLinks;
	}
	public void setVideoLinks(String videoLinks) throws InvalidEntryException {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if(!Pattern.matches(regex, videoLinks)) 
			throw new InvalidEntryException("video links");
		this.videoLinks = videoLinks;
	}
	public String getPdfLink() {
		return pdfLink;
	}
	public void setPdfLinks(String pdfLinks) throws InvalidEntryException   {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if(!Pattern.matches(regex, pdfLinks)) 
			throw new InvalidEntryException("pdf links");
		this.pdfLink = pdfLinks;
	}
	@Override
	public String toString() {
		return "Product [id="+id +", name=" + name + ", desc=" + desc + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", imageLinks=" + imageLinks + ", videoLinks=" + videoLinks + ", pdfLink="
				+ pdfLink + "]";
	}

}
