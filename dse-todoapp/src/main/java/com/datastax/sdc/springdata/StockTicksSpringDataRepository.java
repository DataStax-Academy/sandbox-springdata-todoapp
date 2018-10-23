package com.datastax.sdc.springdata;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.datastax.sdc.springdata.dto.TickData;
import com.datastax.sdc.springdata.dto.TickDataKey;

/**
 * Retrieve all Tick from Table.
 */
public interface StockTicksSpringDataRepository extends CassandraRepository<TickData, TickDataKey> {
    
}