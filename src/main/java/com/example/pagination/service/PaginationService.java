package com.example.pagination.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.pagination.entity.Pagination;

public interface PaginationService {

	List<Pagination> findAllProducts();

	List<Pagination> findproductsWithSort(String field);

	org.springframework.data.domain.Page<Pagination> findProductsWithPagination(int offset, int pageSize);

	Page<Pagination> getProductsWithPaginationAndSorting(String field, int offset, int pageSize);

	

}
