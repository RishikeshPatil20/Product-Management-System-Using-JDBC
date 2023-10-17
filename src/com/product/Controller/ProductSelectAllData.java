package com.product.Controller;

import com.product.Dto.ProductDto;
import com.product.Service.ProductService;

public class ProductSelectAllData {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		ProductDto productDto = null;
		ProductDto p = productService.selectAllDataById(productDto);
		if (p != null) {
			System.out.println(p);
		}
	}

}
