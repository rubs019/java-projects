package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Stock;
import com.javaschoolproject.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/stock")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewStock (@RequestBody Stock stock) {

        Stock s = new Stock();
        s.setId_replique(1);
        s.setQuantite(50);
        stockRepository.save(s);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<Stock> getAllStock(){
        return stockRepository.findAll();
    }
}