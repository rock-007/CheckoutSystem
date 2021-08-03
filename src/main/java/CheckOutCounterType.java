public enum CheckOutCounterType {

    ADAMTILL1("ADAM", 1),
    ADAMTILL2("ADAM", 2),
    ADAMTILL3("ADAM", 4),
    JOHNTILL1("JOHN", 1),
    JOHNTILL2("JOHN", 2),
    JOHNTILL3("JOHN", 3);

    private final String name;
    private final int tillNo;

    CheckOutCounterType(String name, int tillNo) {
        this.name = name;
        this.tillNo = tillNo;
    }

    public String getName() {
        return name;
    }

    public int getTillNo() {
        return tillNo;
    }
}
