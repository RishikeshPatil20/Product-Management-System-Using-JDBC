package com.product.Controller;

import com.product.Service.ProductService;

public class ProductDeleteData {
	public static void main(String[] args) {
		ProductService productService = new ProductService();

		boolean res = productService.deleteProductById(2);
		System.out.println(res);

	}

}
