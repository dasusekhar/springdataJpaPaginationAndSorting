package com.example.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.dto.APIResponse;
import com.example.pagination.entity.Pagination;
import com.example.pagination.service.PaginationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/count")
@Api(value="book service",description="my store ")
public class PaginationController {
	@Autowired
	private PaginationService service;
	@GetMapping("/")
	// @ApiOperation("Returns all the  products  .")

	private APIResponse<List<Pagination>> getProducts()
	{
		List<Pagination>allproducts=service.findAllProducts();
		return new APIResponse<>(allproducts.size(),allproducts);
	}
	@GetMapping("/{field}")
	 @ApiOperation("Returns  with sort fields")
	private APIResponse<List<Pagination>> getProductsWithSort(@PathVariable("field") String field)
	{
		List<Pagination> allProducts=service.findproductsWithSort(field);
		return new APIResponse<>(allProducts.size(),allProducts);
	}
	@GetMapping("/{offset}/{pageSize}")
	 @ApiOperation("Returns we can offset and pagesize  .")
	private APIResponse<Page<Pagination>>getproductWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<Pagination> productWithapagies=service.findProductsWithPagination(offset,pageSize);
		return new APIResponse<>(productWithapagies.getSize(),productWithapagies);
	}
	
	@GetMapping("/{offset}/{pageSize}/{field}")
	 @ApiOperation("Returns offset and pagisize and field .")
	private APIResponse<Page<Pagination>>getproductWithPaginationWithSorting(@PathVariable String field,@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<Pagination>productswith=service.getProductsWithPaginationAndSorting(field,offset,pageSize);
		return new APIResponse<>(productswith.getSize(),productswith);
	}
	

}
