package com.sapient.eldorado.entities;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sapient.eldorado.exceptions.EmptyFieldException;
import com.sapient.eldorado.exceptions.InvalidEntryException;


@Document(collection = "product_details")
public class Product {
	@Id
	private String id;
	
	@NotNull(message = "Name cannot be null")
	@Pattern(message="Invalid Name Pattern ${validatedValue}",regexp="[A-Za-z*-]+")
	@Size(min = 1, max = 32)
	private String name;
	
	@NotNull(message = "Description cannot be null")
	private String desc;
	
	
	private String category;
	
	@Min(value = 0, message = "Price should not be less than 0")
	private int price;
	
	@Min(value = 0, message = "Quantity should not be less than 0")
	private int quantity;
	
	@Pattern(message="Invalid ImageURL Pattern ${validatedValue}",regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
	private String imageLinks;
	
	@Pattern(message="Invalid VideoURL Pattern ${validatedValue}",regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
	private String videoLinks;
	
	@Pattern(message="Invalid PdfURL Pattern ${validatedValue}",regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", imageLinks=" + imageLinks + ", videoLinks=" + videoLinks + ", pdfLink="
				+ pdfLink + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(String imageLinks) {
		this.imageLinks = imageLinks;
	}

	public String getVideoLinks() {
		return videoLinks;
	}

	public void setVideoLinks(String videoLinks) {
		this.videoLinks = videoLinks;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

}
