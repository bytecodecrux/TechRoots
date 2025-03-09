package com.bcrux.printing.model;
import lombok.Data;

@Data
public class Quote {
        private String customerName;
        private int quantity;
        private String paperType;
        private double rawMaterialCost;
        private double laborCost;
        private int roundedLaborCost;
        private double overhead;
        private double productionCost;
        private double tax;
        private double finalPrice;
}
