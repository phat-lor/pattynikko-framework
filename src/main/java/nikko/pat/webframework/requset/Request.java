package nikko.pat.webframework.requset;

import nikko.pat.webframework.application.Application;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Application application;
    private final RequestSender sender;

    private RequestMethod method;
    private String route;
    private final Map<String, String> headers = new HashMap<>();


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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }
}
