package com.goldentouch.service;

import java.util.List;

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
	
}
