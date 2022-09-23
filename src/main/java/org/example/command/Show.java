package org.example.command;

import org.example.Main;
import org.example.objects.HumanBeing;

public class Show extends Command{
    @Override
    public void Execute(Object[] args) {
        for (HumanBeing humanBeing : Main.manager.getHumanBeings()){
            Main.console.Write(humanBeing.toString());
        }
    }

    @Override
    public String getDesc() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n";
    }
}
