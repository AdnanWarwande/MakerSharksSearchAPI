package com.serchAPI.makerSharksInternTask.dtos;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierSearchCriteria {

    @NotBlank(message = "Location cannot be blank")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Location must be alphabetic")
    private String location;

    @Pattern(regexp = "small_scale|medium_scale|large_scale", message = "Invalid nature of business")
    private String natureOfBusiness;

    @Pattern(regexp = "moulding|3d_printing|casting|coating", message = "Invalid manufacturing process")
    private String manufacturingProcess;


}
