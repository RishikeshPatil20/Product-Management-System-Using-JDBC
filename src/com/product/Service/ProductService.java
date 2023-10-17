package com.product.Service;

import com.product.Dto.ProductDto;
import com.product.productDao.ProductDao;

public class ProductService {
	ProductDao productDao = new ProductDao();

	// insert product table data
	public ProductDto saveProduct(ProductDto productDto) {
		ProductDto p = productDao.saveProduct(productDto);
		return p;
	}

	// delete product table data
	public boolean deleteProductById(int id) {
		return productDao.deleteProductById(id);

	}

	// update product table data
	public int updateProduct(int id, int quantity, String name) {
		return productDao.updateProduct(id, quantity, name);
	}

	// get all record of product table
	public ProductDto selectAllDataById(ProductDto productDto) {
		ProductDto p = productDao.selectAllDataById(productDto);
		return p;
	}

	public ProductDto selectOneDataById(int id) {
		ProductDto p = productDao.selectOneDataById(id);
		return p;
	}
}