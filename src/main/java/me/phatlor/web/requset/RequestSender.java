package me.phatlor.web.requset;

import me.phatlor.web.application.Application;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestSender {
    private final Application application;
    private final Socket requsestSocket;
    private final BufferedReader in;
    private final PrintWriter out;

    public RequestSender(Application application, Socket clientSocket, BufferedReader in, PrintWriter out) {
        this.application = application;
        this.requsestSocket = clientSocket;
        this.in = in;
        this.out = out;
    }

    public void close() {
        try {
            in.close();
            out.close();
            requsestSocket.close();
        } catch (Exception e) {
            application.getLogger().error("Error closing client: " + e.getMessage(), e);
        }
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public Socket getRequsestSocket() {
        return requsestSocket;
    }

    public void sendResponse(String response) {
        out.println(response);
    }


}
