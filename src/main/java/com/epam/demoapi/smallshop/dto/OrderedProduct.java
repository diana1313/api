package com.epam.demoapi.smallshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProduct {
    private Integer id;
    private Integer quantity;
}
