package org.example.command;

import org.example.Main;
import org.example.Util;
import org.example.io.File.FileWriteable;
import org.example.io.Writeable;
import org.example.objects.ArgsType;
import org.example.objects.TreeManager;

public class Save extends Command {
    @Override
    public void Execute(Object[] args) {
        Writeable<TreeManager> file = new FileWriteable(args[0].toString(), Main.console);
        try {
            file.Write(Main.manager);
            Main.console.Write("сохранение успешно");
            file.close();
        }
        catch (Exception e){
            Main.console.Write("ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getDesc() {
        return "save : сохранить коллекцию в файл";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[]{ArgsType.String};
    }
}
