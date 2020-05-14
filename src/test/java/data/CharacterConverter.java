package data;

public enum CharacterConverter {
    CLEAR_FIELD("clear", '\u0000', "com.android.calculator2:id/clr"),
    DELETE_FIELD("delete", '\u0000', "com.android.calculator2:id/del"),
    FORMULA_FIELD("formula", '\u0000', "com.android.calculator2:id/formula"),
    RESULT_FIELD("result", '\u0000', "com.android.calculator2:id/result"),
    DECIMAL_OPERATOR(null, '.', "com.android.calculator2:id/dec_point"),
    DIVISION_OPERATOR("division", '÷', "com.android.calculator2:id/op_div"),
    EQUALS_OPERATOR("equals", '=', "com.android.calculator2:id/eq"),
    SUBTRACTION_OPERATOR("subtraction", '-', "com.android.calculator2:id/op_sub"),
    MULTIPLICATION_OPERATOR("multiplication", 'x', "com.android.calculator2:id/op_mul"),
    SUM_OPERATOR("sum", '+', "com.android.calculator2:id/op_add"),
    ZERO(null, '0', "com.android.calculator2:id/digit_0"),
    ONE(null, '1', "com.android.calculator2:id/digit_1"),
    TWO(null, '2', "com.android.calculator2:id/digit_2"),
    THREE(null, '3', "com.android.calculator2:id/digit_3"),
    FOUR(null, '4', "com.android.calculator2:id/digit_4"),
    FIVE(null, '5', "com.android.calculator2:id/digit_5"),
    SIX(null, '6', "com.android.calculator2:id/digit_6"),
    SEVEN(null, '7', "com.android.calculator2:id/digit_7"),
    EIGHT(null, '8', "com.android.calculator2:id/digit_8"),
    NINE(null, '9', "com.android.calculator2:id/digit_9");

    private String operationName;
    private char value;
    private String id;

    CharacterConverter(String operationName, char value, String id) {
        this.operationName = operationName;
        this.value = value;
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
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

    public static String getId(String operationName) {
        for (CharacterConverter character : CharacterConverter.values()) {
            if (character.getOperationName().equals(operationName)) {
                return character.getId();
            }
        }
        return null;
    }
}
