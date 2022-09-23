package org.server;

import com.helper.CommandInfo;
import com.helper.Response;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Server {
    private final String url;
    private final int host;
    ServerSocket serverSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Server(String url, int host) {
        this.url = url;
        this.host = host;
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(InetAddress.getByName(url), host));
    }
    public void accept() throws IOException {
        Socket socket = serverSocket.accept();
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
    }
    public CommandInfo receive(){
        try {
            return (CommandInfo) input.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void send(Response response){
        try{
            output.writeObject(response);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
