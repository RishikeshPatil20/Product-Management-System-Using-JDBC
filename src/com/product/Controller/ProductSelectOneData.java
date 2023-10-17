
package com.product.Controller;

import com.product.Service.ProductService;

public class ProductSelectOneData {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		productService.selectOneDataById(5);
	}

}
