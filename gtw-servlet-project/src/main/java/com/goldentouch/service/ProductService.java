package com.goldentouch.service;

import java.util.List;

import com.goldentouch.dto.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getFruitShopProducts();
	List<Product> getVegShopProducts();
}
