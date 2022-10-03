package com.goldentouch.service;

import java.util.List;

import com.goldentouch.constants.ProductConstants;
import com.goldentouch.dao.ProductDAO;
import com.goldentouch.dao.ProductDAOImpl;
import com.goldentouch.dto.Product;

public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
	
	public ProductServiceImpl() {
		productDAO = new ProductDAOImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productDAO.getAll();
		return productList;
	}

	@Override
	public List<Product> getFruitShopProducts() {
		List<Product> fruitProductList = productDAO.findByCategory(ProductConstants.CATEGORY_FRUIT);
		return fruitProductList;
	}

	@Override
	public List<Product> getVegShopProducts() {
		List<Product> vegProductList = productDAO.findByCategory(ProductConstants.CATEGORY_VEGETABLE);
		return vegProductList;
	}
	
}
