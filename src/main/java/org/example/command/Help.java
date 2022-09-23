package org.example.command;

import org.example.Main;
import org.example.Util;
import org.example.objects.ArgsType;

public class Help extends Command{
    @Override
    public void Execute(Object[] args) {
        for (Command command : Main.commands) {
            Main.console.Write(command.getDesc());
        }
    }


    @Override
    public String getDesc() {
        return "help : вывести справку по доступным командам";
    }
}
