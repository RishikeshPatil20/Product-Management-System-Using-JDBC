package com.product.Controller;

import com.product.Dto.ProductDto;
import com.product.Service.ProductService;

public class ProductInsertData {
	public static void main(String[] args) {
		ProductDto productDto = new ProductDto();
		productDto.setId(4);
		productDto.setName("Bag");
		productDto.setPrice(799);
		productDto.setQuantity(2);

		ProductService productService = new ProductService();
		ProductDto p = productService.saveProduct(productDto);
		if (p != null) {
			System.out.println(p.getId() + " Saved Successfully");
		}
	}
}
