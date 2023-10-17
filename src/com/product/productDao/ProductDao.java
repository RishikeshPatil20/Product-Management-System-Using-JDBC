package com.product.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.Dto.ProductDto;
import com.product.configuration.HelperClass;

public class ProductDao {
	HelperClass helperclass = new HelperClass();

	Connection connection = null;

	// to get one record of product table
	public ProductDto selectOneDataById(int id) {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM product WHERE id = ?";

		try {
			// ? is called as a delimiter / placeholder
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Set the ID as a parameter in the SQL query
			preparedStatement.setInt(1, id);

			// Execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// If a result is found, create a ProductDto object and populate it with data
				ProductDto productDto = new ProductDto();
				productDto.setId(resultSet.getInt("id"));
				productDto.setName(resultSet.getString("name"));
				productDto.setPrice(resultSet.getDouble("price"));
				productDto.setQuantity(resultSet.getInt("quantity"));

				return productDto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null; // Return null if no product with the given ID was found
	}

//=====================================//================================//===================================	

	// to get all record of product table
	public ProductDto selectAllDataById(ProductDto productDto) {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM product";

		try {
			// ? is called as a delimiter / placeholder
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// It taking input from the user dynamically
			// execute statement
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println("=========================================================");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// connection close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;

	}

//=====================================//================================//===================================

	// to update product record
	public int updateProduct(int id, int quantity, String name) {
		connection = helperclass.getConnection();

		// ? is called as a delimiter / placeholder
		String sql = "UPDATE product SET name=?, quantity=? WHERE id=?";
		int a = 0;

		try {
			// It taking input from the user dynamically
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// passed the values to the delimiter/ placeholder
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, quantity);
			preparedStatement.setInt(3, id);

			// Execute Statement
			a = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// Close connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (a > 0) {
			return a;
		} else {
			return -1;
		}

	}

//=====================================//================================//===================================	

	// TO delete Product Data

	public boolean deleteProductById(int id) {
		connection = helperclass.getConnection();

		// Delete Query
		String sql = "DELETE FROM product WHERE id=?";
		int i = 0;

		try {
			// It taking input from the user dynamically
			PreparedStatement preparedStatemnet = connection.prepareStatement(sql);

			preparedStatemnet.setInt(1, id);

			// execute statement
			i = preparedStatemnet.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// close connection
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

//=====================================//================================//===================================	

	// To Save Product Data so method created
	public ProductDto saveProduct(ProductDto productDto) {
		// ? is called as a delimiter / placeholder
		String sql = "INSERT INTO product VALUES(?,?,?,?)";
		connection = helperclass.getConnection();

		try {
			// create statement
			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			// passed the values to the delimiter/ placeholder
			preparedstatement.setInt(1, productDto.getId());
			preparedstatement.setString(2, productDto.getName());
			preparedstatement.setDouble(3, productDto.getPrice());
			preparedstatement.setInt(4, productDto.getQuantity());

			// Execute Statement
			preparedstatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// connection close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return productDto;
	}

}
