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
				productList.add(new Product(productName, productPrice));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
}
