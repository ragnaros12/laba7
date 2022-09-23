package org.server;

import com.helper.CommandInfo;
import com.helper.CommandManager;
import com.helper.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Server server = new Server("localhost", 1002);
        try {
            server.startServer();
            logger.info("сервер стартовал");
            server.accept();
            logger.info("сервер принял подключение");
            while (true) {
                CommandInfo info = server.receive();
                logger.info("данные присланы, команда " + info.getName());
                Response r = CommandManager.Execute(info);
                server.send(r);
                logger.info("ответ отправлен");
            }
        } catch (Exception e) {
            logger.error("сервер сдох =) " + e.getMessage());
        }

    }
}