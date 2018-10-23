package com.datastax.sdc.dse;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.dse.DseSession;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

@Repository
public class DseRepository {

    /** Hold Connectivity to DSE. */
    @Autowired
    private DseSession dseSession;
    
    /** Hold Driver Mapper to implement ORM with Cassandra. */
    @Autowired
    private MappingManager mappingManager;
    
    /** Mapper. */
    private Mapper<StockTick> stockTicksMapper;
    
    @PostConstruct
    public void initRepo() {
        stockTicksMapper = mappingManager.mapper(StockTick.class);
    }
   
    public void saveStockTick(StockTick tick) {
        stockTicksMapper.save(tick);
    }
    
    public List < StockTick > findAll(int limit) {
        return stockTicksMapper.map(
                dseSession.execute(QueryBuilder
                        .select().all()
                        .from("demo_sdc", "stocks_ticks")
                        .limit(limit))).all();
    }
    
}
