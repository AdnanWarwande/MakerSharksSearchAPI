package com.serchAPI.makerSharksInternTask.services;

import com.serchAPI.makerSharksInternTask.entities.Supplier;
import com.serchAPI.makerSharksInternTask.exceptions.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.serchAPI.makerSharksInternTask.repositories.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, String process, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> result = supplierRepository.findByCriteria(location, natureOfBusiness, process, pageable);

        // Throw an exception if no results are found
        if (result.isEmpty()) {
            throw new SupplierNotFoundException("No suppliers found matching the given criteria.");
        }
        return result;
    }
}
