package nikko.pat.webframework.routes;

import nikko.pat.webframework.requset.RequestMethod;

import java.util.HashSet;
import java.util.Set;

public class RouteManager {
    private final Set<Router> routers = new HashSet<>();

    public void addRouter(Router router) {
        router.findRoutes();
        routers.add(router);
    }

    public Route findRoute(String route, RequestMethod requestMethod) {
        for (Router router : routers) {
            for (Route r : router.routes) {
                if (r.getRoute().equals(route) && r.getRequestMethod() == requestMethod)
                    return r;

            }
        }
        return null;
    }
}
