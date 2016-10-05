package airlinesystem.model.valueobject.enums;

public enum SeatCategory 
{
    ECONOMY ("Classe economica"),

    /**
     *
     */
    FIRST_CLASS ("Primeira classe");
    
    private final String name;       

    private SeatCategory(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
