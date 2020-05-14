package data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CharacterConverter {
    CLEAR_FIELD('\u0000', "com.android.calculator2:id/clr"),
    DELETE_FIELD('\u0000', "com.android.calculator2:id/del"),
    RESULT_FIELD('\u0000', "com.android.calculator2:id/result"),
    DECIMAL_OPERATOR('.', "com.android.calculator2:id/dec_point"),
    DIVISION_OPERATOR('÷', "com.android.calculator2:id/op_div"),
    EQUALS_OPERATOR('=', "com.android.calculator2:id/eq"),
    SUBTRACTION_OPERATOR('-', "com.android.calculator2:id/op_sub"),
    MULTIPLICATION_OPERATOR('x', "com.android.calculator2:id/op_mul"),
    SUM_OPERATOR('+', "com.android.calculator2:id/op_add"),
    ZERO('0', "com.android.calculator2:id/digit_0"),
    ONE('1', "com.android.calculator2:id/digit_1"),
    TWO('2', "com.android.calculator2:id/digit_2"),
    THREE('3', "com.android.calculator2:id/digit_3"),
    FOUR('4', "com.android.calculator2:id/digit_4"),
    FIVE('5', "com.android.calculator2:id/digit_5"),
    SIX('6', "com.android.calculator2:id/digit_6"),
    SEVEN('7', "com.android.calculator2:id/digit_7"),
    EIGHT('8', "com.android.calculator2:id/digit_8"),
    NINE('9', "com.android.calculator2:id/digit_9");

    private char value;
    private String id;

    CharacterConverter(char value, String id) {
        this.value = value;
        this.id = id;
    }

    public char getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public static String getId(char value) {
        for (CharacterConverter character : CharacterConverter.values()) {
            if (character.getValue() == value) {
                return character.getId();
            }
        }
        return null;
    }
}
