package org.example.command;

import org.example.Util;
import org.example.objects.ArgsType;

import java.util.Locale;

public abstract class Command {
    public abstract void Execute(Object[] args);

    public String getName(){
        return getClass().getSimpleName().toLowerCase(Locale.ROOT);
    }

    public ArgsType[] getArgs(){
        return Util.getEmpty();
    }

    public abstract String getDesc();
}
