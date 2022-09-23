package org.example.command;

import org.example.Main;

public class Clear extends Command{
    @Override
    public void Execute(Object[] args) {
        Main.manager.getHumanBeings().clear();
        Main.console.Write("очистка успешна");
    }

    @Override
    public String getDesc() {
        return "clear : очистить коллекцию";
    }
}
