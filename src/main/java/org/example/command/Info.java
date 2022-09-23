package org.example.command;

import org.example.Main;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;

public class Info extends Command{
    @Override
    public void Execute(Object[] args) {
        Main.console.Write("тип: " + HumanBeing.class.getSimpleName());
        Main.console.Write("кол-во обьектов: " + Main.manager.getHumanBeings().size());
    }

    @Override
    public String getDesc() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n";
    }
}
