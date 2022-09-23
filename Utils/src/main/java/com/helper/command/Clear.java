package com.helper.command;

import com.helper.Response;
import com.helper.Tree;

public class Clear extends Command{
    @Override
    public Response Execute(Object[] args) {
        Tree.getTreeManager().getHumanBeings().clear();
        return new Response("удаление успешно");
    }

    @Override
    public String getDesc() {
        return "clear : очистить коллекцию";
    }
}
