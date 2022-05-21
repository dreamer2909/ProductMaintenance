package com.example.productmaintenance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    @NotBlank(message = "Code is required")
    private String code;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Price is required")
    @Pattern(message = "Price must be a number", regexp="^[0-9]*$")
    private Double price;

    public Product(String code, String description, Double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
}
