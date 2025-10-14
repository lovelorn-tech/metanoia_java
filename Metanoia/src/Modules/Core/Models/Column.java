package Modules.Core.Models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;

public class Column {
    private Entry<Object, Class<? extends Object>> value;
    private final String name;
    public static final HashMap<String, Class<? extends Object>> TYPE;

    static {
        TYPE = new HashMap<String, Class<? extends Object>>();

        TYPE.put("INTEGER", Integer.class);
        TYPE.put("TINYINT", Byte.class);
        TYPE.put("SMALLINT", Short.class);
        TYPE.put("BIGINT", Long.class);
        TYPE.put("REAL", Float.class);
        TYPE.put("FLOAT", Double.class);
        TYPE.put("DOUBLE", Double.class);
        TYPE.put("DECIMAL", BigDecimal.class);
        TYPE.put("NUMERIC", BigDecimal.class);
        TYPE.put("BOOLEAN", Boolean.class);
        TYPE.put("CHAR", String.class);
        TYPE.put("VARCHAR", String.class);
        TYPE.put("LONGVARCHAR", String.class);
        TYPE.put("DATE", Date.class);
        TYPE.put("TIME", Time.class);
        TYPE.put("TIMESTAMP", Timestamp.class);
        TYPE.put("SERIAL", Integer.class);
    }

    public Column(final Object value, final String name, final String sqlType) {
        this.name = name;
        setValue(value, sqlType);
    }

    private <T> void setValue(final Object value, final String sqlType) {
        Class<? extends Object> castType = Column.TYPE.get(sqlType.toUpperCase());
        Object v = castType.cast(value);
        this.value = new AbstractMap.SimpleImmutableEntry<Object, Class<? extends Object>>(v, v.getClass());
    }

    public String getName() {
        return this.name;
    }

    public Object getObject() {
        return this.value.getKey();
    }

    public Class<? extends Object> getType() {
        return this.value.getValue();
    }
}
