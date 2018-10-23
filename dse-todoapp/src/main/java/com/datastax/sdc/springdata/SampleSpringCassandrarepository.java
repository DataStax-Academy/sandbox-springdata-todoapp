package com.datastax.sdc.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import com.datastax.sdc.springdata.dto.TickData;

@Repository
public class SampleSpringCassandrarepository {
    
    @Autowired
    private CassandraTemplate template;
   
    public String generareCQL() {
        return template.getTableName(TickData.class).toCql();
    }
}
