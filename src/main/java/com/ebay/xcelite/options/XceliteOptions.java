package com.ebay.xcelite.options;

/**
 * Configuration interface for setting options of a {@link com.ebay.xcelite.Xcelite}
 * object.
 *
 * @since 1.2
 */

public interface XceliteOptions {

    /**
     * Returns the number of rows Xcelite should skip before trying
     * to parse the next one as the row defining the annotated bean
     * properties
     *
     * @return The number of rows
     */
    Integer getSkipRowsBeforeColumnDefinitionRow();

    /**
     * Sets the number of rows Xcelite should skip before trying
     * to parse the next one as the row defining the annotated bean
     * properties
     *
     * @param skipRowsBeforeColumnDefinitionRow The number of rows to skip
     */
    void setSkipRowsBeforeColumnDefinitionRow (Integer skipRowsBeforeColumnDefinitionRow);

    /**
     * Returns whether SheetReaders skip blank rows
     * or return empty objects for blank rows.
     * Default is SheetReaders skip blank rows
     *
     * @return Do we skip blank rows (Default: true)
     */
    boolean isSkipBlankRows();

    /**
     * Determines whether SheetReaders skip blank rows
     * or return empty objects for blank rows
     *
     * @param skipBlankRows Should we skip blank rows
     */
    void setSkipBlankRows(boolean skipBlankRows);
}

