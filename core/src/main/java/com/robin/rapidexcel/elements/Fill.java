package com.robin.rapidexcel.elements;

public class Fill {
    protected static final Fill NONE = new Fill("none", null, true);


    protected static final Fill GRAY125 = new Fill("gray125", null, true);


    private final String patternType;

    private final String colorRgb;

    private final boolean fg;
    Fill(String patternType, String colorRgb, boolean fg) {
        this.patternType = patternType;
        this.colorRgb = colorRgb;
        this.fg = fg;
    }
    static Fill fromColor(String fgColorRgb) {
        return fromColor(fgColorRgb, true);
    }
    static Fill fromColor(String colorRgb, boolean fg) {
        return new Fill("solid", colorRgb, fg);
    }

}
