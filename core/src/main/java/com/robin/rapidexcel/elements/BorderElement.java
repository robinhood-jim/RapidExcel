package com.robin.rapidexcel.elements;

public class BorderElement {
    protected static final BorderElement NONE = new BorderElement(null, null);

    /**
     * Border style.
     */
    private final String style;

    /**
     * RGB border color.
     */
    private final String rgbColor;


    BorderElement(String style, String rgbColor) {
        this.style = style;
        this.rgbColor = rgbColor;
    }
}
