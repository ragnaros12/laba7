package org.example;

import org.example.command.Command;
import org.example.io.Console.ConsoleReadable;
import org.example.io.Console.ConsoleWriteable;
import org.example.io.File.FileReader;
import org.example.io.File.FileWriteable;
import org.example.io.Readable;
import org.example.io.Writeable;
import org.example.objects.ArgsType;
import org.example.objects.HumanBeing;
import org.example.objects.TreeManager;
import org.example.objects.builders.HumanBeingBuilder;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Лр 5: 314206
//Лр 6: 34074
//Лр 7: 314211


public class Main {
    public static TreeManager manager;
    public static List<Command> commands = new ArrayList<>();

    public static Writeable<String> console;

    public static Readable<String> consoleRead = new ConsoleReadable();

    public static Stack<String> lasts = new Stack<>();

    public static void main(String[] args) {
        console = new ConsoleWriteable();


        Reflections reflections = new Reflections("org.example.command", new SubTypesScanner(true));
        try {
            for (Class<? extends Command> a : reflections.getSubTypesOf(Command.class)){
                commands.add(a.newInstance());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        Readable<TreeManager> fileReader = new FileReader(args[0], console);
        manager = fileReader.read();


        try {
            while (true) {
                console.Write("введите команду");
                String[] comma = consoleRead.read().split(",");
                String name = comma[0].toLowerCase(Locale.ROOT);
                boolean is = false;
                for (Command cm : commands){
                    if(cm.getName().equals(name)){
                        List<Object> arguments = new ArrayList<>();
                        if(comma.length - 1 == Arrays.stream(cm.getArgs()).filter(u -> u != ArgsType.HumanBeing).count()) {
                            for (int i = 0; i < cm.getArgs().length; i++) {
                                if (cm.getArgs()[i] == ArgsType.Integer) {
                                    arguments.add(Integer.parseInt(comma[i + 1]));
                                } else if (cm.getArgs()[i] == ArgsType.HumanBeing) {
                                    arguments.add(new HumanBeingBuilder(consoleRead, console).build());
                                } else if (cm.getArgs()[i] == ArgsType.Long) {
                                    arguments.add(Long.parseLong(comma[i + 1]));
                                } else {
                                    arguments.add(comma[i + 1]);
                                }
                            }
                            cm.Execute(arguments.toArray());
                            is = true;
                        }
                        else{
                            console.Write("недостаточно аргументов");
                        }
                        break;
                    }
                }
                if(!is){
                    console.Write("команда не найдена");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Writeable<TreeManager> file = new FileWriteable(args[0], console);
        file.Write(manager);

    }
}