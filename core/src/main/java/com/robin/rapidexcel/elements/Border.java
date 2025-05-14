package com.robin.rapidexcel.elements;

import java.util.EnumMap;
import java.util.Map;

public class Border {
    protected static final Border NONE = new Border();

    /**
     * Border elements.
     */
    final Map<BorderSide, BorderElement> elements = new EnumMap<>(BorderSide.class);
    Border() {
        this(BorderElement.NONE, BorderElement.NONE, BorderElement.NONE, BorderElement.NONE, BorderElement.NONE);
    }

    /**
     * Simple constructor.
     *
     * @param element Border element for all sides, except diagonal.
     */
    Border(BorderElement element) {
        this(element, element, element, element, BorderElement.NONE);
    }

    /**
     * Constructor.
     *
     * @param left Border element for left side.
     * @param right Border element for right side.
     * @param top Border element for top side.
     * @param bottom Border element for bottom side.
     * @param diagonal Border element for diagonal side.
     */
    Border(BorderElement left, BorderElement right, BorderElement top, BorderElement bottom, BorderElement diagonal) {
        elements.put(BorderSide.TOP, top);
        elements.put(BorderSide.LEFT, left);
        elements.put(BorderSide.BOTTOM, bottom);
        elements.put(BorderSide.RIGHT, right);
        elements.put(BorderSide.DIAGONAL, diagonal);
    }
}
