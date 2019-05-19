package com.javastudio.tutorial.type;

import java.util.HashMap;
import java.util.Map;

/**
 * ISO 8859 is an eight-bit extension to ASCII developed by ISO (the International Organization for Standardization).
 * ISO 8859 includes the 128 ASCII characters along with an additional 128 characters, such as the British pound
 * symbol and the American cent symbol.
 * Several variations of the ISO 8859 standard exist for different language families:
 */
public enum CharacterEncoding {

    LATIN_1_WESTERN_EUROPEAN(1, "Western European languages"),
    LATIN_2_CENTRAL_EUROPEAN(2, "Non-Cyrillic Central and Eastern European languages"),
    LATIN_3_SOUTH_EUROPEAN(3, "Southern European languages and Esperanto"),
    LATIN_4_NORTH_EUROPEAN(4),
    LATIN_CYRILLIC(5, "8859-5 (Cyrillic)"),
    LATIN_ARABIC(6, "8859-6 (Arabic)"),
    LATIN_GREEK(7, "8859-7 (Greek)"),
    LATIN_HEBREW(8, "8859-8 (Hebrew)"),
    LATIN_5_TURKISH(9, "Turkish"),
    LATIN_6_NORDIC(10, "Northern European and Baltic languages");

    private static final Map<Integer, CharacterEncoding> enumMap = new HashMap<Integer, CharacterEncoding>();

    static {
        for (CharacterEncoding pinActivationStatus : values()) {
            enumMap.put(pinActivationStatus.getValue(), pinActivationStatus);
        }
    }

    private final Integer value;
    private final String description;

    CharacterEncoding(int value, String description) {
        this.value = value;
        this.description = description;
    }

    CharacterEncoding(int value) {
        this(value, null);
    }

    public Integer getValue() {
        return value;
    }

    public String getString() {
        return String.format("%02d", value);
    }

    public String getDescription() {
        return description;
    }

    public static CharacterEncoding getInstance(Integer value) {
        if (value == null)
            return null;

        return enumMap.get(value);
    }
}
