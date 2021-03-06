/*
 * Copyright 2018 Thanthathon.b.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ebay.xcelite.reader;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.exceptions.ColumnNotFoundException;
import com.ebay.xcelite.model.CamelCase;
import com.ebay.xcelite.model.ThaiCase;
import com.ebay.xcelite.model.UpperCase;
import com.ebay.xcelite.model.UsStringCellDateConverter;
import com.ebay.xcelite.options.XceliteOptions;
import com.ebay.xcelite.sheet.XceliteSheet;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test various upper/lower/camel-casings of the header-row
 * that defines the columns and mapping to model properties
 *
 * n.b. the provided Excel-sheets have a lookup of the sex
 * via the sexid and the second sheet. Date column is not
 * date formatted, but text.
 *
 * @author Thanthathon.b
 */
public class StringColumnCapitalizationTest extends TestBaseForReaderTests{

    private static String usTestData[][] = {
            {"Crystal",	"Maiden", "01/02/1990",	"2", "Female"},
            {"Witch",	"Doctor", "01/01/1990",	"1", "Male"}
    };

    private static String thaiTestData[][] = {
            {"แม่มด",	"น้ำแข็ง","02/01/1447",	"2", "Female"},
            {"พ่อมด",	"หมอ", "01/01/1447",	"1", "Male"}
    };

    @Test
    @DisplayName("Must correctly recognize uppercase column headers")
    public void model_UPPER_readUpperMustOK() throws ParseException {
        List<UpperCase> upper = getData(UpperCase.class, new XceliteOptions(), "src/test/resources/UPPERCASE.xlsx");

        UpperCase first = upper.get(0);
        assertEquals(usTestData[0][0], first.getName(), "Name mismatch");
        assertEquals(usTestData[0][1], first.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[0][2]), first.getBirthDate(), "Birthdate mismatch");

        UpperCase second = upper.get(1);
        assertEquals(usTestData[1][0], second.getName(), "Name mismatch");
        assertEquals(usTestData[1][1], second.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[1][2]), second.getBirthDate(), "Birthdate mismatch");
    }
    
    @Test
    @DisplayName("Must correctly recognize camelcase column headers")
    public void model_camel_readCamelCaseMustOK() throws ParseException {
        List<CamelCase> upper = getData(CamelCase.class, new XceliteOptions(), "src/test/resources/Camel Case.xlsx");

        CamelCase first = upper.get(0);
        assertEquals(usTestData[0][0], first.getName(), "Name mismatch");
        assertEquals(usTestData[0][1], first.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[0][2]), first.getBirthDate(), "Birthdate mismatch");

        CamelCase second = upper.get(1);
        assertEquals(usTestData[1][0], second.getName(), "Name mismatch");
        assertEquals(usTestData[1][1], second.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[1][2]), second.getBirthDate(), "Birthdate mismatch");
    }
    
    @Test
    @DisplayName("Must correctly recognize thai column headers")
    public void model_Thai_readThaiCaseMustOK() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(UsStringCellDateConverter.DATE_PATTERN);
        Xcelite xcelite = new Xcelite(new File("src/test/resources/Thai Case.xlsx"));
        XceliteSheet sheet = xcelite.getSheet(0);
        SheetReader<ThaiCase> beanReader = sheet.getBeanReader(ThaiCase.class);
        ArrayList<ThaiCase> thais = new ArrayList<>(beanReader.read());

        ThaiCase first = thais.get(0);
        assertEquals(thaiTestData[0][0], first.getName(), "Name mismatch");
        assertEquals(thaiTestData[0][1], first.getSurname(), "Surname mismatch");
        assertEquals(df.parse(thaiTestData[0][2]), first.getBirthDate(), "Birthdate mismatch");

        ThaiCase second = thais.get(1);
        assertEquals(thaiTestData[1][0], second.getName(), "Name mismatch");
        assertEquals(thaiTestData[1][1], second.getSurname(), "Surname mismatch");
        assertEquals(df.parse(thaiTestData[1][2]), second.getBirthDate(), "Birthdate mismatch");

    }

    @Test
    @DisplayName("When header parsing is case-sensitive, this must throw")
    @SneakyThrows
    public void HeaderParsingIsCaseSensitive_UPPER_readLowerMustFail() throws ParseException {
        XceliteOptions options = new XceliteOptions();
        options.setHeaderParsingIsCaseSensitive(true);
        Xcelite xcelite = new Xcelite(new FileInputStream(new File("src/test/resources/UPPERCASE.xlsx")), options);
        XceliteSheet sheet = xcelite.getSheet(0);

        assertThrows(ColumnNotFoundException.class, () -> {
            SheetReader<CamelCase> beanReader = sheet.getBeanReader(CamelCase.class);
            beanReader.read();
        });
    }

    @Test
    @DisplayName("When header parsing is not case-sensitive, this must pass")
    public void HeaderParsingIsNOTCaseSensitive_UPPER_readLowerMustNotFail() throws ParseException {
        XceliteOptions options = new XceliteOptions();
        options.setHeaderParsingIsCaseSensitive(false);
        List<CamelCase> data = getData(CamelCase.class, options, "src/test/resources/UPPERCASE.xlsx");
        assertEquals(2, data.size(), "Wrong row count");
        Iterator<CamelCase> iter = data.iterator();

        CamelCase first = iter.next();
        assertEquals(usTestData[0][0], first.getName(), "Name mismatch");
        assertEquals(usTestData[0][1], first.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[0][2]), first.getBirthDate(), "Birthdate mismatch");

        CamelCase second = iter.next();
        assertEquals(usTestData[1][0], second.getName(), "Name mismatch");
        assertEquals(usTestData[1][1], second.getSurname(), "Surname mismatch");
        assertEquals(usDateFormat.parse(usTestData[1][2]), second.getBirthDate(), "Birthdate mismatch");
    }
}
