package com.example.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pagination.entity.Pagination;

@Repository
public interface PaginationRepository extends JpaRepository<Pagination,Integer> {

}
