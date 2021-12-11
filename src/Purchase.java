import java.time.LocalDate;

public class Purchase {

    private String name;
    private double value;
    private LocalDate time;
    private String comment;

    public Purchase(String name, double value, String comment){
        this.name = name;
        this.value = value;
        this.time = LocalDate.now();
        this.comment = comment;
    }

    public LocalDate getTime() {
        return time;
    }

    public String getName(){
        return name;
    }

    public double getValue(){
        return value;
    }
}
