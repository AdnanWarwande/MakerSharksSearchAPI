package com.serchAPI.makerSharksInternTask;

import com.serchAPI.makerSharksInternTask.entities.Supplier;
import com.serchAPI.makerSharksInternTask.repositories.SupplierRepository;
import com.serchAPI.makerSharksInternTask.services.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SupplierServiceTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    public SupplierServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchSuppliers() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1L);
        supplier.setCompanyName("Test Company");
        supplier.setLocation("India");
        supplier.setNatureOfBusiness("small_scale");
        supplier.setManufacturingProcesses(Collections.singletonList("3d_printing"));

        Pageable pageable = PageRequest.of(0, 10);
        Page<Supplier> page = new PageImpl<>(Collections.singletonList(supplier), pageable, 1);

        when(supplierRepository.findByCriteria("India", "small_scale", "3d_printing", pageable))
                .thenReturn(page);

        Page<Supplier> result = supplierService.searchSuppliers("India", "small_scale", "3d_printing", 0, 10);

        assertEquals(1, result.getTotalElements());
        assertEquals("Test Company", result.getContent().get(0).getCompanyName());
    }
}

