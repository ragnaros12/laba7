package org.example.command;

public class PrintUniqueMood extends Command{
    @Override
    public void Execute(Object[] args) {

    }

    @Override
    public String getDesc() {
        return "print_unique_mood : вывести уникальные значения поля mood всех элементов в коллекции";
    }
}
