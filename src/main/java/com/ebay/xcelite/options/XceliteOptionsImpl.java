package com.ebay.xcelite.options;

/**
 * Configuration class for setting options of a {@link com.ebay.xcelite.Xcelite}
 * object.
 *
 * @since 1.2
 */

public class XceliteOptionsImpl implements XceliteOptions {

    private Integer skipRowsBeforeColDefinitionRow = 0;
    private boolean skipBlankRows = true;


    @Override
    public Integer getSkipRowsBeforeColumnDefinitionRow() {
        return skipRowsBeforeColDefinitionRow;
    }

    @Override
    public void setSkipRowsBeforeColumnDefinitionRow(Integer skipRowsBeforeColumnDefinitionRow) {
        this.skipRowsBeforeColDefinitionRow = skipRowsBeforeColumnDefinitionRow;
    }

    @Override
    public boolean isSkipBlankRows() {
        return skipBlankRows;
    }

    @Override
    public void setSkipBlankRows(boolean skipBlankRows) {
        this.skipBlankRows = skipBlankRows;
    }

}
