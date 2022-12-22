package organization;

public enum Gender {

    MEN( "MEN"),
    FEMALE("female");

    // TODO: Гендер
    private final String value;
    public String getText(){
        return this.value;
    }
    Gender(String value) {
        this.value = value;
    }
}
