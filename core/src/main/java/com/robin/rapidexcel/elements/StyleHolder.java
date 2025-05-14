package com.robin.rapidexcel.elements;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StyleHolder {
    private final ConcurrentMap<String, Integer> valueFormattings = new ConcurrentHashMap<>();
    private final ConcurrentMap<Font, Integer> fonts = new ConcurrentHashMap<>();
    private final ConcurrentMap<Fill, Integer> fills = new ConcurrentHashMap<>();
    private final ConcurrentMap<Border, Integer> borders = new ConcurrentHashMap<>();
    private final ConcurrentMap<CellStyle, Integer> styles = new ConcurrentHashMap<>();

    void replaceDefaultFont(Font font) {
        fonts.entrySet().removeIf(entry->entry.getValue()==0);
        fonts.putIfAbsent(font,0);
    }
}
