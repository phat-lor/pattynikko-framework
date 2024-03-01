package nikko.pat.webframework.routes;

import nikko.pat.webframework.requset.RequestMethod;

import java.lang.reflect.Method;

public class Route {
    private final Router router;

    private final String route;
    private final RequestMethod requestMethod;
    private final Method javaMethod;

    public Route(Router router, String route, RequestMethod requestMethod, Method javaMethod) {
        this.router = router;
        this.route = route;
        this.requestMethod = requestMethod;
        this.javaMethod = javaMethod;
    }
    public Router getRouter() {
        return router;
    }
    public String getRoute() {
        return route;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public Method getJavaMethod() {
        return javaMethod;
    }
}
