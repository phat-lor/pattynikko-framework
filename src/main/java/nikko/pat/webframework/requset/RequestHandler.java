package nikko.pat.webframework.requset;

import nikko.pat.webframework.response.ContentType;
import nikko.pat.webframework.response.Response;
import nikko.pat.webframework.response.StatusCode;
import nikko.pat.webframework.routes.Route;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RequestHandler {
    private final Request request;

    public RequestHandler(Request request) {
        this.request = request;
    }

    public void handle() {
        Route route = request.getApplication().getRouteManager().findRoute(request.getRoute(), request.getMethod());
        if (route == null) {
            Response response = new Response(request);
            response.setStatusCode(StatusCode.NOT_FOUND);
            response.setContentType(ContentType.TEXT);
            response.send("404 Route Not Found");
            return;
        }

        Method method = route.getJavaMethod();
        try {
            method.invoke(route.getRouter(), request, new Response(request));
        } catch (IllegalAccessException | InvocationTargetException e) {
            request.getApplication().getLogger().error("Error invoking method: " + e.getMessage(), e);
            Response response = new Response(request);
            response.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR);
            response.setContentType(ContentType.TEXT);
            response.send("500 Internal Server Error");
        }
    }

    public void send(String response) {
        request.getSender().getOut().println(response);
    }

    public Request getRequest() {
        return request;
    }
}
