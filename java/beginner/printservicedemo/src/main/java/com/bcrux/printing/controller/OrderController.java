package com.bcrux.printing.controller;

import com.bcrux.printing.model.Order;
import com.bcrux.printing.model.Quote;
import com.bcrux.printing.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class OrderController {

        private final QuoteService quoteService;

        @Autowired
        public OrderController(QuoteService quoteService) {
            this.quoteService = quoteService;
        }

        @GetMapping("/")
        public String showOrderForm(Model model) {
            model.addAttribute("order", new Order());
            return "order-form";
        }

        @PostMapping("/quote")
        public String calculateQuote(@ModelAttribute("order") Order order, Model model) {
            Quote quote = quoteService.calculateQuote(order);
            model.addAttribute("quote", quote);
            model.addAttribute("formattedRawMaterialCost", quoteService.formatCurrency(quote.getRawMaterialCost()));
            model.addAttribute("formattedLaborCost", quoteService.formatCurrency(quote.getLaborCost()));
            model.addAttribute("formattedOverhead", quoteService.formatCurrency(quote.getOverhead()));
            model.addAttribute("formattedProductionCost", quoteService.formatCurrency(quote.getProductionCost()));
            model.addAttribute("formattedTax", quoteService.formatCurrency(quote.getTax()));
            model.addAttribute("formattedFinalPrice", quoteService.formatCurrency(quote.getFinalPrice()));
            return "quote-result";
        }

        @PostMapping("/submit-order")
        public String submitOrder(@ModelAttribute("quote") Quote quote, Model model) {
            // In a real application, we would save the order to a database here
            model.addAttribute("message", "Order submitted successfully!");
            return "order-confirmation";
        }
    }
