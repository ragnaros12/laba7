package org.example.command;

public class Exit extends Command{
    @Override
    public void Execute(Object[] args) {
        System.exit(0);
    }

    @Override
    public String getDesc() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
