package org.example.command;

import org.example.Main;

public class History extends Command{
    @Override
    public void Execute(Object[] args) {
        for (String str : Main.lasts){
            Main.console.Write(str);
        }
    }

    @Override
    public String getDesc() {
        return "history : вывести последние 14 команд (без их аргументов)";
    }
}
