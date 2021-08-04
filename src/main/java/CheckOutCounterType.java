// CheckOutCounterType is the enum class, it contains all the employees and till information.

public enum CheckOutCounterType {
    ADAMTILL1("ADAM ID1234", 1),
    ADAMTILL2("ADAM ID1234", 2),
    ADAMTILL3("ADAM ID1234", 4),
    JOHNTILL1("JOHN ID5678", 1),
    JOHNTILL2("JOHN ID5678", 2),
    JOHNTILL3("JOHN ID5678", 3);

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
