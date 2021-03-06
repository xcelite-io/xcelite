package com.ebay.xcelite.writer;

import com.ebay.xcelite.helper.AbstractTestBaseForWriterTests;
import com.ebay.xcelite.model.AbstractWriterTestsBean;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * The setup() to this tests creates an Excel workbook with one sheet. On that sheet,
 * there are three columns:
 * - one created from a boolean primitive
 * - one created from a Boolean object
 * - one created from a String
 *
 * Nota bene: the unit under test is called in the setup() function, the tests validate
 * by reading
 */
class AbstractWriterTests extends TestBaseForWriterTests {
    private static AbstractWriterTestsBean bean = new AbstractWriterTestsBean();

    @BeforeAll
    @SneakyThrows
    static void setup() {
        setupBeans(bean);
    }

    @Test
    @DisplayName("Must correctly write boolean")
    void mustWriteBooleanSimpleTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        boolean val = bean.isBooleanSimpleType();
        Object obj = columnsMap.get("booleanSimpleType");
        Assertions.assertEquals(Boolean.class, obj.getClass(), "Values of type boolean must be written as Boolean");
        Assertions.assertEquals(val, obj);
    }

    @Test
    @DisplayName("Must correctly write Boolean")
    void mustWriteBooleanObjectTypeOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        Boolean val = bean.getBooleanObjectType();
        Object obj = columnsMap.get("booleanObjectType");
        Assertions.assertEquals(val.getClass(), obj.getClass(), "Values of type Boolean must be written as Boolean");
        Assertions.assertEquals(val, obj);
    }

    @Test
    @DisplayName("Must correctly write String")
    void mustWriteStringOK() {
        List<Map<String, Object>> rowList = extractCellValues (workbook);
        Map<String, Object> columnsMap = rowList.get(0);
        String val = bean.getStringType();
        Object obj = columnsMap.get("stringType");
        Assertions.assertEquals(val.getClass(), obj.getClass(), "Values of type String must be written as String");
        Assertions.assertEquals(val, obj);
    }

}
