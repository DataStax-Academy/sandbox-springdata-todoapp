package com.datastax.sdc.springdata.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.mapping.annotations.Column;

/**
 * Data into  Cassandra.
 *
 * @author DataStax Evangelist Team
 */
@Table(value = "stocks_ticks")
public class TickData implements Serializable {
    
    /** Serial. */
    private static final long serialVersionUID = 6761984069893402714L;
    
    @PrimaryKey
    private TickDataKey tickDataKey; 
    
    /** value. */
    @Column
    private double value;
     
    /** Keep default. */
    public TickData() {}

    /**
     * Common constructor
     */
    public TickData(Date datetime, TickDataKey tickDataKey, double value) {
        this.tickDataKey = tickDataKey;
        this.value    = value;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "TickData [" +
                "symbol=" + tickDataKey + ", " +
                "value=" + value + "]";
    }

    /**
     * Getter accessor for attribute 'value'.
     *
     * @return
     *       current value of 'value'
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter accessor for attribute 'value'.
     * @param value
     * 		new value for 'value '
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter accessor for attribute 'tickDataKey'.
     *
     * @return
     *       current value of 'tickDataKey'
     */
    public TickDataKey getTickDataKey() {
        return tickDataKey;
    }

    /**
     * Setter accessor for attribute 'tickDataKey'.
     * @param tickDataKey
     * 		new value for 'tickDataKey '
     */
    public void setTickDataKey(TickDataKey tickDataKey) {
        this.tickDataKey = tickDataKey;
    }

}
