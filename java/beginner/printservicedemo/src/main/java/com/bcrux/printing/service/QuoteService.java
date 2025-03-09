package com.bcrux.printing.service;

import com.bcrux.printing.model.Order;
import com.bcrux.printing.model.Quote;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
        public Quote calculateQuote(Order order) {
            Quote quote = new Quote();
            quote.setCustomerName(order.getCustomerName());
            quote.setQuantity(order.getQuantity());
            quote.setPaperType(order.getPaperType());

            // Base price per page
            double basePricePerPage = 0.15;

            // Calculate raw materials cost
            double rawMaterialCost = order.getQuantity() * basePricePerPage;

            // Calculate ink cost
            double inkPerPage = 0.05; // in milliliters
            double inkCost = order.getQuantity() * inkPerPage * 0.02; // Assuming ink costs $0.02 per ml

            // Total material cost
            double totalMaterialCost = rawMaterialCost + inkCost;
            quote.setRawMaterialCost(totalMaterialCost);

            // Calculate labor cost (5 cents per page)
            double laborCost = order.getQuantity() * 0.05;
            quote.setLaborCost(laborCost);

            // But our payroll system requires whole dollar amounts
            int roundedLaborCost = (int) Math.round(laborCost);
            quote.setRoundedLaborCost(roundedLaborCost);

            // Calculate overhead (15% of materials and labor)
            double overhead = (totalMaterialCost + laborCost) * 0.15;
            quote.setOverhead(overhead);

            // Calculate total production cost
            double productionCost = totalMaterialCost + laborCost + overhead;
            quote.setProductionCost(productionCost);

            // Calculate tax (8%)
            double tax = productionCost * 0.08;
            quote.setTax(tax);

            // Calculate final price
            double finalPrice = productionCost + tax;
            quote.setFinalPrice(finalPrice);

            return quote;
        }

        // Helper method to format currency values
        public String formatCurrency(double amount) {
            // Format to exactly 2 decimal places
            return String.format("%.2f", amount);
        }
    }
