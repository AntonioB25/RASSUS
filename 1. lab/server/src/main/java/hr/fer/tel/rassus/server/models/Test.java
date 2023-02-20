package hr.fer.tel.rassus.server.models;

public class Test {

    private String name;
    private Double number;

    public Test(String name, Double number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
}
