package com.serchAPI.makerSharksInternTask.controllers;

import com.serchAPI.makerSharksInternTask.dtos.SupplierSearchCriteria;
import com.serchAPI.makerSharksInternTask.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.serchAPI.makerSharksInternTask.services.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/supplier")
@Validated
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSuppliers(
            @Valid @RequestBody SupplierSearchCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Supplier> suppliers = supplierService.searchSuppliers(
                criteria.getLocation(),
                criteria.getNatureOfBusiness(),
                criteria.getManufacturingProcess(),
                page, size
        );
        return ResponseEntity.ok(suppliers);
    }
}
