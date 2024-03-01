package me.phatlor.web.requset;

import me.phatlor.web.requset.Request;
import me.phatlor.web.response.ContentType;
import me.phatlor.web.response.Response;
import me.phatlor.web.response.StatusCode;
import me.phatlor.web.routes.Route;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RequestHandler {
    private final Request request;

    public RequestHandler(Request request) {
        this.request = request;
    }

    public void handle() throws Exception {
        Route route = request.getApplication().getRouteManager().findRoute(request.getRoute(), request.getMethod());
//        System.out.println(route.getRoute());
        if (route == null) {
            Response response = new Response(request);
            response.setStatusCode(StatusCode.NOT_FOUND);
            response.setContentType(ContentType.TEXT);
            response.send("404 Route Not Found");
            return;
        }

        Method method = route.getJavaMethod();
        method.invoke(route.getRouter(), request, new Response(request));
    }

    public void send(String response) {
        request.getSender().getOut().println(response);
    }

    public Request getRequest() {
        return request;
    }
}
