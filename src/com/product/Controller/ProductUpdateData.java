package com.product.Controller;

import com.product.Service.ProductService;

public class ProductUpdateData {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		int p = productService.updateProduct(3, 5, "Mobile");
		System.out.println(p);
	}

}
