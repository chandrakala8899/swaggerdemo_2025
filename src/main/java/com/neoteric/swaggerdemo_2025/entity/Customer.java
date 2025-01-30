package com.neoteric.swaggerdemo_2025.entity;
import com.neoteric.swaggerdemo_2025.customvalidations.ValidDateRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ValidDateRange(message = "From Date cannot be after To Date")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String adharNumber;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String firstName;

    @NotNull(message = "from date is required")
    private Date fromDate;

    @NotNull(message = "to date is required")
    private Date toDate;

    @NotNull
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


}

