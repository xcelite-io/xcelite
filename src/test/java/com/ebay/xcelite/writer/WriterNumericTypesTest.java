package com.ebay.xcelite.writer;

import com.ebay.xcelite.model.WriterNumericTypesBean;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.*;

/**
 * Test if all of Java's simple numeric types and all subclasses of
 * {@link java.lang.Number} get written as numeric Excel cells.
 * Complete based on the Java 1.8 numeric types.
 *
 * @since 1.2
 */

class WriterNumericTypesTest extends TestBaseForWriterTests {
    static final WriterNumericTypesBean bean = new WriterNumericTypesBean();

    @BeforeAll
    @SneakyThrows
    static void setup() {
        setupBeans(bean);
    }

    @Test
    @DisplayName("Must correctly write Java short types")
    void mustWriteShortsOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        short val = bean.getShortSimpleType();
        Object obj = columnsMap.get("shortSimpleType");
        Assertions.assertTrue((obj instanceof Number),  "Values of type short must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).shortValue());
    }

    @Test
    @DisplayName("Must correctly write Java int types")
    void mustWriteIntOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        int val = bean.getIntegerSimpleType();
        Object obj = columnsMap.get("integerSimpleType");
        Assertions.assertTrue((obj instanceof Number), "Values of type int must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).intValue());
    }

    @Test
    @DisplayName("Must correctly write Java long types")
    void mustWriteLongOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        long val = bean.getLongSimpleType();
        Object obj = columnsMap.get("longSimpleType");
        Assertions.assertTrue((obj instanceof Number), "Values of type long must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).longValue());
    }


    @Test
    @DisplayName("Must correctly write Java Integer types")
    void mustWriteIntegerOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        int val = bean.getIntegerObjectType();
        Object obj = columnsMap.get("integerObjectType");
        Assertions.assertTrue((obj instanceof Number), "Values of type Integer must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).intValue());
    }


    @Test
    @DisplayName("Must correctly write Java Long types")
    void mustWriteLongObjectOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        Long val = bean.getLongObjectType();
        Object obj = columnsMap.get("longObjectType");
        Assertions.assertTrue((obj instanceof Number), "Values of type Long must be written as numeric");
        Assertions.assertEquals(val.longValue(), ((Number)obj).longValue());
    }

    @Test
    @DisplayName("Must correctly write Java BigInteger types")
    void mustWriteBigIntegerTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        BigInteger val = bean.getBigIntegerType();
        Object obj = columnsMap.get("bigIntegerType");
        Assertions.assertTrue((obj instanceof Number), "Values of type BigInteger must be written as numeric");
        Assertions.assertEquals(val.longValue(), ((Number)obj).longValue());
    }

    @Test
    @DisplayName("Must correctly write Java AtomicInteger types")
    void mustWriteAtomicIntegerOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        AtomicInteger val = bean.getIntegerAtomicType();
        Object obj = columnsMap.get("integerAtomicType");
        Assertions.assertTrue((obj instanceof Number), "Values of type AtomicInteger must be written as numeric");
        Assertions.assertEquals(val.intValue(), ((Number)obj).intValue());
    }

    @Test
    @DisplayName("Must correctly write Java AtomicLong types")
    void mustWriteAtomicLongOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        AtomicLong val = bean.getLongAtomicType();
        Object obj = columnsMap.get("longAtomicType");
        Assertions.assertTrue((obj instanceof Number), "Values of type AtomicLong must be written as numeric");
        Assertions.assertEquals(val.longValue(), ((Number)obj).longValue());
    }
    @Test
    @DisplayName("Must correctly write Java LongAccumulator types")
    void mustWriteLongAccumulatorOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        LongAccumulator val = bean.getLongAccumulatorType();
        Object obj = columnsMap.get("longAccumulatorType");
        Assertions.assertTrue((obj instanceof Number), "Values of type LongAccumulator must be written as numeric");
        Assertions.assertEquals(val.longValue(), ((Number)obj).longValue());
    }

    @Test
    @DisplayName("Must correctly write Java LongAdder types")
    void mustWriteLongAdderOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        LongAdder val = bean.getLongAdderType();
        Object obj = columnsMap.get("longAdderType");
        Assertions.assertTrue((obj instanceof Number), "Values of type LongAdder must be written as numeric");
        Assertions.assertEquals(val.longValue(), ((Number)obj).longValue());
    }

    @Test
    @DisplayName("Must correctly write Java float types")
    void mustWriteFloatOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        float val = bean.getFloatSimpleType();
        Object obj = columnsMap.get("floatSimpleType");
        Assertions.assertTrue((obj instanceof Number), "Values of type float must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).floatValue());
    }

    @Test
    @DisplayName("Must correctly write Java double types")
    void mustWriteDoubleOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        double val = bean.getDoubleSimpleType();
        Object obj = columnsMap.get("doubleSimpleType");
        Assertions.assertTrue((obj instanceof Number), "Values of type double must be written as numeric");
        Assertions.assertEquals(val, ((Number)obj).doubleValue());
    }

    @Test
    @DisplayName("Must correctly write Java Float types")
    void mustWriteFloatObjectOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        Float val = bean.getFloatObjectType();
        Object obj = columnsMap.get("floatObjectType");
        Assertions.assertTrue((obj instanceof Number), "Values of type Float must be written as numeric");
        Assertions.assertEquals(val.floatValue(), ((Number)obj).floatValue());
    }

    @Test
    @DisplayName("Must correctly write Java Double types")
    void mustWriteDoubleObjectOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        Double val = bean.getDoubleObjectType();
        Object obj = columnsMap.get("doubleObjectType");
        Assertions.assertTrue((obj instanceof Number), "Values of type Double must be written as numeric");
        Assertions.assertEquals(val.doubleValue(), ((Number)obj).doubleValue());
    }

    @Test
    @DisplayName("Must correctly write Java BigDecimal types")
    void mustWriteBigDecimalOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        BigDecimal val = bean.getBigDecimalType();
        Object obj = columnsMap.get("bigDecimalType");
        Assertions.assertTrue((obj instanceof Number), "Values of type BigDecimal must be written as numeric");
        Assertions.assertEquals(val.doubleValue(), ((Number)obj).doubleValue());
    }

    @Test
    @DisplayName("Must correctly write Java DoubleAccumulator types")
    void mustWritedDoubleAccumulatorTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        DoubleAccumulator val = bean.getDoubleAccumulatorType();
        Object obj = columnsMap.get("doubleAccumulatorType");
        Assertions.assertTrue((obj instanceof Number),
                "Values of type DoubleAccumulator must be written as numeric");
        Assertions.assertEquals(val.doubleValue(), ((Number)obj).doubleValue());
    }

    @Test
    @DisplayName("Must correctly write Java DoubleAdder types")
    void mustWritedDoubleAdderTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        DoubleAdder val = bean.getDoubleAdderType();
        Object obj = columnsMap.get("doubleAdderType");
        Assertions.assertTrue((obj instanceof Number),
                "Values of type DoubleAdder must be written as numeric");
        Assertions.assertEquals(val.doubleValue(), ((Number)obj).doubleValue());
    }

    @Test
    @DisplayName("Must correctly write Java Number types")
    void mustWritedNumberTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        Number val = bean.getNumberType();
        Object obj = columnsMap.get("numberType");
        Assertions.assertTrue((obj instanceof Number),
                "Values of type Number must be written as numeric");
        Assertions.assertEquals(val.doubleValue(), ((Number)obj).doubleValue());
    }
}
