package com.serchAPI.makerSharksInternTask;

import com.serchAPI.makerSharksInternTask.controllers.SupplierController;
import com.serchAPI.makerSharksInternTask.dtos.SupplierSearchCriteria;
import com.serchAPI.makerSharksInternTask.entities.Supplier;
import com.serchAPI.makerSharksInternTask.services.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SupplierControllerTest {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    public SupplierControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchSuppliers() {
        // Setup test data
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1L);
        supplier.setCompanyName("Test Company");
        supplier.setLocation("India");
        supplier.setNatureOfBusiness("small_scale");
        supplier.setManufacturingProcesses(Collections.singletonList("3d_printing"));

        Pageable pageable = PageRequest.of(0, 10);
        Page<Supplier> page = new PageImpl<>(Collections.singletonList(supplier), pageable, 1);

        SupplierSearchCriteria criteria = new SupplierSearchCriteria();
        criteria.setLocation("India");
        criteria.setNatureOfBusiness("small_scale");
        criteria.setManufacturingProcess("3d_printing");

        // Mock the service call
        when(supplierService.searchSuppliers("India", "small_scale", "3d_printing", 0, 10))
                .thenReturn(page);

        // Call the controller method
        ResponseEntity<Page<Supplier>> response = supplierController.searchSuppliers(criteria, 0, 10);

        // Verify the results
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getTotalElements());
        assertEquals("Test Company", response.getBody().getContent().get(0).getCompanyName());
    }
}

