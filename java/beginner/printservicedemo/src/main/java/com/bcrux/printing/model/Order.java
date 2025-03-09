package com.bcrux.printing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
        private String customerName;
        private int quantity;
        private String paperType;
}
