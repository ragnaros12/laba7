package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.io.Readable;
import org.example.io.Writeable;
import org.example.objects.ArgsType;
import org.example.objects.TreeManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    private static final ArgsType[] empty = new ArgsType[0];
    private static long Id = 0;

    private static final XmlMapper serialization = new XmlMapper();
    public static long generateId(){
        return Id++;
    }

    public static ArgsType[] getEmpty() {
        return empty;
    }

    public static Integer parseInt(String value){
        if(value.equals(""))
            return null;
        else
            return Integer.parseInt(value);
    }

}
