package com.javaschoolproject.demo.Administrator;

import com.javaschoolproject.demo.domaine.Terrain;
import com.javaschoolproject.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/stock")
public class RepliqueController {
    @Autowired
    private StockRepository stockRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewStock (@RequestBody Stock administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Stock s = new Stock();
        s.id_replique(1);
        s.quantite(50);
        stockRepository.save(s);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Stock> getAllStock(){
        return stockRepository.findAll();
    }
}