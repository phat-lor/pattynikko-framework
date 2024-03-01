package me.phatlor.web.requset;

import me.phatlor.web.application.Application;

public class Request {
    private final Application application;
    private final RequestSender sender;

    private RequestMethod method;
    private String route;
    private String body;

    public Request(Application application, RequestSender client) {
        this.application = application;
        this.sender = client;
    }

    public Application getApplication() {
        return application;
    }

    public RequestSender getSender() {
        return sender;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
