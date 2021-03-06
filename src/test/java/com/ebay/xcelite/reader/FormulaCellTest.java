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
import com.ebay.xcelite.model.FormulaUserBean;
import com.ebay.xcelite.options.XceliteOptions;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test if formula cells work
 *
 * The test Excel-sheets have a lookup of the sex
 * via the sexid and the second sheet.
 *
 * @author Johannes
 */
public class FormulaCellTest extends TestBaseForReaderTests {

    private static String testData[][] = {
            {"Crystal",	"Maiden",	"01/02/1990",	"2",	"Female"},
            {"Witch",	"Doctor",	"01/01/1990",	"1",	"Male"}
    };

    /*
        Reference for the VLOOKUP function in Excel:
        https://web.archive.org/web/20180820031225/https://support.office.com/en-us/article/vlookup-function-0bbc8083-26fe-4963-8ab8-93a18ad188a1
     */
    @Test
    @DisplayName("Must correctly lookup data on another sheet via VLKOOKUP")
    public void model_VLOOKUPCanLookupReferencedCell() {
        List<FormulaUserBean> upper = getData(FormulaUserBean.class,
                new XceliteOptions (), "src/test/resources/formulaData.xlsx");

        FormulaUserBean first = upper.get(0);
        assertEquals(testData[0][4], first.getSex(), "Gender mismatch");

        FormulaUserBean second = upper.get(1);
        assertEquals(testData[1][4], second.getSex(), "Gender mismatch");
    }

    // TODO write test With formula cell containing error, boolean, numeric

}
