package org.example.command;

import org.example.Main;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;

import java.util.Objects;

public class Update extends Command{
    @Override
    public void Execute(Object[] args) {
        Long id = (Long) args[0];
        HumanBeing update = (HumanBeing) args[1];
        for (HumanBeing humanBeing : Main.manager.getHumanBeings()){
            if(Objects.equals(humanBeing.getId(), id)){
                update.setId(id);
                Main.manager.getHumanBeings().remove(humanBeing);
                Main.manager.Add(update);
                Main.console.Write("замена успешна");
                return;
            }
        }
        Main.console.Write("замена не удалась");
    }

    @Override
    public String getDesc() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.Long, ArgsType.HumanBeing};
    }
}
