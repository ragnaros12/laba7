package com.helper.command;


import com.helper.Response;
import com.helper.Tree;
import com.helper.objects.ArgsType;
import com.helper.objects.HumanBeing;

public class RemoveLower extends Command{
    @Override
    public Response Execute(Object[] args) {
        HumanBeing h = (HumanBeing) args[0];

        Tree.getTreeManager().getHumanBeings().stream().filter(u -> h.compareTo(u) < 0).forEach(u -> Tree.getTreeManager().getHumanBeings().remove(u));

        return new Response("команда выполнена");
    }

    @Override
    public String getDesc() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.HumanBeing};
    }
}
