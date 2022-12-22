package view;


import java.util.Arrays;

public enum ComponentType {
    MENU(0, " - menu"),
    LIST(1, " - Depart list"),
    SINGLE(2, " - get Depart by id"),
    CREATE_BOX(3, " - create new Depart"),
    UPDATE_BOX(4, " - update Depart"),
    LIST_EMPLOY(5,"- Employ list"),
    SINGLE_EMPLOY(6,"- get Employ by id"),
    CREATE_EMPLOY(7, " - create new Employ"),
    UPDATE_EMPLOY(8, " - update Employ");


    private final int type;
    private final String comment;

    ComponentType(int type, String comment) {
        this.type = type;
        this.comment = comment;
    }

    public int getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public static ComponentType fromType(int type) {
        return Arrays.stream(values())
                .filter(v -> v.type == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No component with type: " + type));
    }
}

