package org.example.command;

import org.example.Main;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;

import java.util.Objects;

public class RemoveById extends Command{
    @Override
    public void Execute(Object[] args) {
        Long id = (Long) args[0];
        for (HumanBeing humanBeing : Main.manager.getHumanBeings()){
            if(Objects.equals(humanBeing.getId(), id)){
                Main.manager.getHumanBeings().remove(humanBeing);
                Main.console.Write("удаление успешно");
                return;
            }
        }
        Main.console.Write("удаление не удалось");
    }

    @Override
    public String getDesc() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.Long};
    }
}
