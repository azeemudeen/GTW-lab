package com.goldentouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goldentouch.dto.Product;
import com.goldentouch.service.DBConnection;

public class ProductDAOImpl implements ProductDAO{
	
	private DBConnection DBCon;
	
	public ProductDAOImpl() {
		DBCon = DBConnection.getInstance();
	}

	@Override
	public List<Product> getAll() {
		List<Product> productList = new ArrayList<>();
		try {
			Connection con = DBCon.getConnection();
			String sql = "SELECT * FROM product";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String productName = rs.getString("name");
				int productPrice = rs.getInt("price");
				String image_uri = rs.getString("image_uri");
				String code = rs.getString("code");
				int category_id = rs.getInt("category_id");
				productList.add(new Product(productName, productPrice, image_uri, code, category_id));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> findByCategory(int categoryId) {
		List<Product> productList = new ArrayList<>();
		try {
			Connection con = DBCon.getConnection();
			String sql = "SELECT * FROM product WHERE category_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String productName = rs.getString("name");
				int productPrice = rs.getInt("price");
				String image_uri = rs.getString("image_uri");
				String code = rs.getString("code");
				int category_id = rs.getInt("category_id");
				productList.add(new Product(productName, productPrice, image_uri, code, category_id));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
}
