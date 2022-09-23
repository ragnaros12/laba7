package com.helper;

import com.helper.objects.ArgsType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandInfo implements Serializable {

    static final long serialVersionUID = 42L;
    private String name;
    private Object[] args;

    public CommandInfo(String name, Object[] args) {
        this.name = name;
        this.args = args;
    }

    public ArgsType[] getArgsType(){
        try {
            return Arrays.stream(args).map(u -> ArgsType.valueOf(u.getClass().getSimpleName())).toArray(ArgsType[]::new);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
