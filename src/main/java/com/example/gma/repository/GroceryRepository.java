package com.example.gma.repository;

import com.example.gma.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
}
