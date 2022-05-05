package com.example.pagination.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.entity.Pagination;
import com.example.pagination.repository.PaginationRepository;

@Service
public class PaginationServiceImpl implements PaginationService{
	@Autowired
	private PaginationRepository repository;
	
	@PostConstruct
	public void initDB()
	{
		List<Pagination> products=IntStream.rangeClosed(1, 200)
				.mapToObj(i->new Pagination( i, "product" +i,new Random().nextInt(100),new Random().nextInt(50000)))
				.collect(Collectors.toList());
		repository.saveAll(products);
		
	}
	

	@Override
	public List<Pagination> findAllProducts() {
		
		return repository.findAll();
	}
	public List<Pagination>  findproductsWithSort(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}


	@Override
	public Page<Pagination> findProductsWithPagination(int offset, int pageSize) {
		Page<Pagination>products=repository.findAll(PageRequest.of(offset, pageSize));

		return products;
	}


	@Override
	public Page<Pagination> getProductsWithPaginationAndSorting(String field, int offset, int pageSize) {
		Page<Pagination>products=repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return products;
	}
	
	
	

}
