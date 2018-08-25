/*
  Copyright [2013-2014] eBay Software Foundation

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.ebay.xcelite.writer;

import com.ebay.xcelite.sheet.XceliteSheet;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Date;

/**
 * Class description...
 *
 * @author kharel (kharel@ebay.com)
 * created Nov 10, 2013
 */
public abstract class AbstractSheetWriter<T> implements SheetWriter<T> {

    @Getter
    protected XceliteSheet sheet;
    boolean writeHeader;

    AbstractSheetWriter(XceliteSheet sheet, boolean writeHeader) {
        this.sheet = sheet;
        this.writeHeader = writeHeader;
    }

    void writeToCell(Cell cell, Object fieldValueObj, Class<?> dataType) {
        if (null == fieldValueObj) {
            cell.setCellType(CellType.BLANK);
            return;
        }
        Class<?> type = fieldValueObj.getClass();
        if (dataType != null) {
            type = dataType;
        }
        if (type.equals(Date.class)) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue((Date) fieldValueObj);
        } else if ((type.equals(Boolean.class))
                || (type.equals(boolean.class))){
            cell.setCellType(CellType.BOOLEAN);
            cell.setCellValue((Boolean) fieldValueObj);
        } else if ((Number.class.isAssignableFrom(type))
                || (fieldValueObj instanceof Number))  {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(((Number) fieldValueObj).doubleValue());
        } else {
            cell.setCellType(CellType.STRING);
            cell.setCellValue(fieldValueObj.toString());
        }
    }

    @Override
    public void generateHeaderRow(boolean generateHeaderRow) {
        this.writeHeader = generateHeaderRow;
    }
}
