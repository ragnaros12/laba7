package org.example.command;

import org.example.Main;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;

public class Add extends Command{
    @Override
    public void Execute(Object[] args) {
        Main.manager.Add((HumanBeing) args[0]);
    }

    @Override
    public String getDesc() {
        return "add {element} : добавить новый элемент в коллекцию";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.HumanBeing};
    }
}
