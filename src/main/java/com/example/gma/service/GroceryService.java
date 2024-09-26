package com.example.gma.service;

import com.example.gma.entity.Grocery;
import com.example.gma.exception.GroceryNotFoundException;
import com.example.gma.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository){
        this.groceryRepository = groceryRepository;
    }

    public Grocery findGroceryById(int groceryId) {

        return groceryRepository.findById(groceryId).orElseThrow(() -> new GroceryNotFoundException("Could not find any grocery By Id", "/manage-groceries"));
    }
    public void addGrocery(Grocery grocery){
        groceryRepository.save(grocery);
    }

    public List<Grocery> findAllGroceries() {

        return groceryRepository.findAll();
    }

    public void deleteGroceryById(int groceryId) {
        groceryRepository.deleteById(groceryId);
    }
}
