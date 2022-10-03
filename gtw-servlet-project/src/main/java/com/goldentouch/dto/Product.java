package com.goldentouch.dto;

public class Product {
	private String name;
	private int price;
	private String imageUri;
	private String code;
	private int categoryId;
		
	public Product(String name, int price, String imageUri, String code, int categoryId) {
		this.name = name;
		this.price = price;
		this.imageUri = imageUri;
		this.code = code;
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getImageUri() {
		return imageUri;
	}

	public String getCode() {
		return code;
	}

	public int getCategoryId() {
		return categoryId;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", imageUri=" + imageUri + ", code=" + code
				+ ", categoryId=" + categoryId + "]";
	}
}
