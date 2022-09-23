package com.helper.command;


import com.helper.Response;
import com.helper.Tree;
import com.helper.objects.ArgsType;
import com.helper.objects.HumanBeing;

public class Add extends Command{
    @Override
    public Response Execute(Object[] args) {
        Tree.getTreeManager().Add((HumanBeing) args[0]);
        return new Response("добавление успешно");
    }

    @Override
    public String getDesc() {
        return "add {element} : добавить новый элемент в коллекцию";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.HumanBeing};
    }
}
