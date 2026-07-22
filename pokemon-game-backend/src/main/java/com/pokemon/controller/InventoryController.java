package com.pokemon.controller;

import com.pokemon.model.InventoryEntry;
import com.pokemon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryEntry>> getInventory() {
        return ResponseEntity.ok(inventoryService.getOwnedItems());
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetInventory() {
        inventoryService.reset();
        return ResponseEntity.ok("Inventory reset");
    }
}
