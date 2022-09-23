package org.example.command;

import org.example.Main;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;

public class RemoveLower extends Command{
    @Override
    public void Execute(Object[] args) {
        HumanBeing h = (HumanBeing) args[0];
        for (HumanBeing humanBeing : Main.manager.getHumanBeings()){
            if(h.compareTo(humanBeing) < 0){
                Main.manager.getHumanBeings().remove(humanBeing);
            }
        }
        Main.console.Write("команда выполнена");
    }

    @Override
    public String getDesc() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.HumanBeing};
    }
}
