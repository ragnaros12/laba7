package com.helper.command;


import com.helper.Response;
import com.helper.Tree;
import com.helper.objects.ArgsType;
import com.helper.objects.HumanBeing;

public class RemoveGreater extends Command{
    @Override
    public Response Execute(Object[] args) {
        HumanBeing h = (HumanBeing) args[0];

        Tree.getTreeManager().getHumanBeings().stream().filter(u -> h.compareTo(u) > 0).forEach(u -> Tree.getTreeManager().getHumanBeings().remove(u));

        return new Response("команда выполнена");
    }

    @Override
    public String getDesc() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public ArgsType[] getArgs() {
        return new ArgsType[] {ArgsType.HumanBeing};
    }
}
