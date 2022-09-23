package org.example.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.io.Writeable;
import org.example.objects.TreeManager;

import java.io.PrintWriter;

public class FileWriteable implements Writeable<TreeManager> {

    final XmlMapper xmlMapper = new XmlMapper();
    PrintWriter writer;

    Writeable<String> console;

    public FileWriteable(String path, Writeable<String> console) {
        this.console = console;
        try {
            writer = new PrintWriter(path);
        }
        catch (Exception e){
            console.Write("ошибка: " + e.getMessage());
        }
    }

    @Override
    public void Write(TreeManager manager) {
        if(writer != null){
            try {
                writer.println(xmlMapper.writeValueAsString(manager));
            }
            catch (Exception e){
                console.Write("ошибка: " + e.getMessage());
            }
        }
    }

    @Override
    public void close() {
        if(writer != null)
            writer.close();
    }
}
