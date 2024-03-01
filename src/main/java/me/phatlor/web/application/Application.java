package me.phatlor.web.application;

import me.phatlor.web.requset.Request;
import me.phatlor.web.requset.RequestHandler;
import me.phatlor.web.requset.RequestSender;
import me.phatlor.web.requset.RequestParser;
import me.phatlor.web.routes.RouteManager;
import me.phatlor.web.util.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {
    private final ApplicationSettings settings;
    private final Logger logger;
    private boolean running = false;
    private final RouteManager routeManager = new RouteManager();

    public Application(ApplicationSettings settings) {
        this.settings = settings;
        this.logger = new Logger(this, "Application", System.out);
    }

    public void start() {
        logger.info("Starting server on port " + settings.getPort());
        try (ServerSocket serverSocket = new ServerSocket(settings.getPort())) {
            running = true;

            while (running) {
                // Accept client connection
                Socket senderSocket = serverSocket.accept();

                RequestSender sender = new RequestSender(
                        this,
                        senderSocket,
                        new BufferedReader(new InputStreamReader(senderSocket.getInputStream())),
                        new PrintWriter(senderSocket.getOutputStream(), true)
                );

                logger.debug("Client connected " + senderSocket);

                Request request = RequestParser.parse(this, sender);

                logger.debug("Parsed request " + request.getMethod() + " " + request.getRoute());

                RequestHandler requestHandler = new RequestHandler(request);
                requestHandler.handle();

                logger.debug("Request handled " + request.getMethod() + " " + request.getRoute());
            }
        } catch (Exception ex) {
            logger.error("Error starting server: " + ex.getMessage(), ex);
        }
    }

    public boolean isDebug() {
        return settings.isDebug();
    }
    public boolean isRunning() {
        return running;
    }

    public Logger getLogger() {
        return logger;
    }

    public RouteManager getRouteManager() {
        return routeManager;
    }
}
