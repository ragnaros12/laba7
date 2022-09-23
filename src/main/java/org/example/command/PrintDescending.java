package org.example.command;

import org.example.Main;
import org.example.objects.HumanBeing;

import java.util.stream.Collectors;

public class PrintDescending extends Command{
    @Override
    public void Execute(Object[] args) {
        for (HumanBeing h : Main.manager.getHumanBeings().stream().sorted(HumanBeing::compareTo).collect(Collectors.toList())){
            Main.console.Write(h.toString());
        }
    }

    @Override
    public String getDesc() {
        return "print_descending : вывести элементы коллекции в порядке убывания\n";
    }
}
