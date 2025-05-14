package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.Objects;

public class CellStyle implements IWriteableElements{
    private final int valueFormatting;
    /**
     * Index of cached font.
     */
    private final int font;
    /**
     * Index of cached fill pattern.
     */
    private final int fill;
    /**
     * Index of cached border.
     */
    private final int border;
    /**
     * Alignment.
     */
    private final Alignment alignment;
    CellStyle(CellStyle original, int valueFormatting, int font, int fill, int border, Alignment alignment) {
        this.valueFormatting = (valueFormatting == 0 && original != null) ? original.valueFormatting : valueFormatting;
        this.font = (font == 0 && original != null) ? original.font : font;
        this.fill = (fill == 0 && original != null) ? original.fill : fill;
        this.border = (border == 0 && original != null) ? original.border : border;
        this.alignment = (alignment == null && original != null) ? original.alignment : alignment;

    }
    @Override
    public int hashCode() {
        return Objects.hash(valueFormatting, font, fill, border, alignment);
    }

    @Override
    public void writeOut(XMLWriter w) throws IOException {
        w.append("<xf numFmtId=\"").append(valueFormatting).append("\" fontId=\"").append(font).append("\" fillId=\"").append(fill).append("\" borderId=\"").append(border).append("\" xfId=\"0\"");
        if (border != 0) {
            w.append(" applyBorder=\"1\"");
        }

        if (alignment == null) {
            w.append("/>");
            return;
        }
        if (alignment != null) {
            w.append(" applyAlignment=\"1\"");
        }


        w.append('>');
        if (alignment != null) {
            alignment.writeOut(w);
        }

        w.append("</xf>");
    }
}
