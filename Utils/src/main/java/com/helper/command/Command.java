package com.helper.command;


import com.helper.Response;
import com.helper.objects.ArgsType;

import java.util.Locale;

public abstract class Command {
    public abstract Response Execute(Object[] args);

    public String getName(){
        return getClass().getSimpleName().toLowerCase(Locale.ROOT);
    }

    public ArgsType[] getArgs(){
        return new ArgsType[0];
    }

    public abstract String getDesc();
}
