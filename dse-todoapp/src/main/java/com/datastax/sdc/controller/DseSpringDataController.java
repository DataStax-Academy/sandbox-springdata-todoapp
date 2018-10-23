package com.datastax.sdc.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.sdc.dse.DseRepository;
import com.datastax.sdc.dse.StockTick;
import com.datastax.sdc.springdata.SampleSpringCassandrarepository;
import com.datastax.sdc.springdata.StockTicksSpringDataRepository;
import com.datastax.sdc.springdata.dto.TickData;

@RestController
public class DseSpringDataController {
    
    @Autowired
    private StockTicksSpringDataRepository springDataRepo;
    
    @Autowired
    private SampleSpringCassandrarepository springDataConcrete;
    
    @Autowired
    private DseRepository dseRepo;
    
    @RequestMapping("/")
    public String list() {
        StringBuilder response = new StringBuilder("<html><body><ul>");
        response.append("");
        response.append("<li> List data in the table 'stock_ticks' with Spring Data <a href=\"./listWithSpringData\">HERE</a>" );
        
        response.append("<li> List data in the table 'stock_ticks' with DSE Driver <a href=\"./listWithDse\">HERE</a>" );
        
        response.append("<li> CREATE STOCK TICK <a href=\"./createTick/ba\">HERE</a>" );
        
        response.append("<li> Sample CQL<a href=\"./generateCql\">HERE</a>" );
        
        response.append("</ul></body></html>");
        
        
        springDataRepo.findAll();
        
        return response.toString();
    }
    
    @RequestMapping("/generateCql")
    public String table() {
        return springDataConcrete.generareCQL();
    }
    
    @RequestMapping("/listWithSpringData")
    public List<TickData> listSDC() {
        return springDataRepo.findAll();
    }
    
    @RequestMapping("/listWithDse")
    public List<StockTick> listDse() {
        return dseRepo.findAll(10);
    }
    
    @RequestMapping(value = "/createTick/{symbol}", method = RequestMethod.GET)
    public void createStockTick(@PathVariable String symbol) {
         dseRepo.saveStockTick(new StockTick(symbol, new Random().nextDouble() * 100));
    }

}
