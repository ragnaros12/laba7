package com.helper;

import com.helper.command.Command;
import com.helper.command.Help;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Array;
import java.util.*;

public class CommandManager {
    private static final List<Command> commands;

    static {
        commands = new ArrayList<>();
        Reflections reflections = new Reflections("com.helper.command", new SubTypesScanner(true));
        try {
            for (Class<? extends Command> a : reflections.getSubTypesOf(Command.class)){
                commands.add(a.newInstance());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private static final ArrayDeque<String> lasts = new ArrayDeque<>();

    public static Queue<String> getLasts() {
        return lasts;
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static Response Execute(CommandInfo info){
        boolean is = false;
        for (Command cm : commands){
            if(cm.getName().equals(info.getName())){
                if(Arrays.equals(info.getArgsType(), cm.getArgs())){
                    if(lasts.size() == 14){
                        lasts.pollFirst();
                    }
                    lasts.addLast(cm.getName());
                    System.out.println("команда запущена: " + info.getName());
                    return cm.Execute(info.getArgs());
                }
                else{
                    return new Response("аргументы не совпадают");
                }
            }
        }
        if(!is){
            return new Response("команда не найдена");
        }

        return new Response("это вообще как");
    }

    public static Command find(String name){
        for (Command cm : commands){
            if(cm.getName().equals(name)){
                return cm;
            }
        }
        return null;
    }
}
