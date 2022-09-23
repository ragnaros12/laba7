package org.example.objects;

public class Car {
    private Boolean cool; //Поле не может быть null

    public Boolean getCool() {
        return cool;
    }

    public void setCool(Boolean cool) {
        this.cool = cool;
    }

    @Override
    public String toString() {
        return "Car{" +
                "\n\t\tcool=" + cool +
                "\n\t}";
    }
}
