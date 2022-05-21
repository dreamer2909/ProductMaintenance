package com.example.productmaintenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String getHome() {
        return "home";
    }

    @GetMapping("/display")
    public String getProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/update")
    public String getUpdateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "updateProduct";
        }
        String code = product.getCode();
        Product p = productRepository.findProductByCode(code);
        if (p != null) {
            Product product1 = productRepository.findById(p.getId()).get();
            product1.setCode(product.getCode());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            productRepository.save(product1);
        }
        else productRepository.save(product);
        return "redirect:/display";
    }

    @GetMapping("/confirm")
    public String getDeleteProduct(@RequestParam int id, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("product", optionalProduct.get());
        }
        return "deleteProduct";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productRepository.deleteById(id);
        return "redirect:/display";
    }
}
