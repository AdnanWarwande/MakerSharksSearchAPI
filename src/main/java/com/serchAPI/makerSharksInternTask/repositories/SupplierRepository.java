package com.serchAPI.makerSharksInternTask.repositories;

import com.serchAPI.makerSharksInternTask.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT s FROM Supplier s " +
            "WHERE (:location IS NULL OR LOWER(s.location) = LOWER(:location)) " +
            "AND (:natureOfBusiness IS NULL OR LOWER(s.natureOfBusiness) = LOWER(:natureOfBusiness)) " +
            "AND (:process IS NULL OR LOWER(:process) MEMBER OF s.manufacturingProcesses)")

    Page<Supplier> findByCriteria(@Param("location") String location,
                                  @Param("natureOfBusiness") String natureOfBusiness,
                                  @Param("process") String process,
                                  Pageable pageable);
}
