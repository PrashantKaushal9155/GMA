package com.example.gma.controller;

import com.example.gma.entity.Grocery;
import com.example.gma.exception.GroceryNotFoundException;
import com.example.gma.service.GroceryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroceryController {
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/add-grocery")
    public String addGroceryRequest(Model model) {
        model.addAttribute("grocery", new Grocery());
        return "add_grocery.html";
    }
    @PostMapping("/add-grocery")
    public String addGrocery(@ModelAttribute Grocery grocery) {
        groceryService.addGrocery(grocery);
        return "redirect:/";
    }
    @GetMapping("/update-grocery")
    public  String updateGroceryRequest(Model model, @RequestParam("grocery_id") int groceryId){
        Grocery grocery = groceryService.findGroceryById(groceryId);
        model.addAttribute("grocery", grocery);
        return "update_grocery.html";
    }

    @PostMapping("/update-grocery")
    public String updateGrocery(@ModelAttribute Grocery grocery){
        groceryService.addGrocery(grocery);
        return "redirect:/manage-groceries";
    }
    @GetMapping("/manage-groceries")
    public String displayGroceries(Model model){
        List<Grocery> groceries =  groceryService.findAllGroceries();
        model.addAttribute("groceries", groceries);
        return "manage_groceries.html";
    }

    @GetMapping("/delete-grocery")
    public String deleteGroceryById(Model model, @RequestParam("grocery_id") int groceryId){
        groceryService.deleteGroceryById(groceryId);
        return "redirect:/manage-groceries";
    }
    @ExceptionHandler(GroceryNotFoundException.class)
    public String handleGroceryNotFoundById(Model model, GroceryNotFoundException e){
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("redirectTo", e.getRedirectTo());
        return "not_found.html";
    }
}
