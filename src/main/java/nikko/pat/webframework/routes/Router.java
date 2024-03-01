package nikko.pat.webframework.routes;


import nikko.pat.webframework.requset.RequestMethod;
import nikko.pat.webframework.routes.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public interface Router {
    Set<Route> routes = new HashSet<>();

    default void findRoutes() {
        for (Method method : this.getClass().getDeclaredMethods()) {
            method.setAccessible(true);

            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation.annotationType().isAssignableFrom(GET.class)) {
                    GET get = (GET) annotation;
                    routes.add(new Route(this, get.route(), RequestMethod.GET, method));
                } else if (annotation.annotationType().isAssignableFrom(POST.class)) {
                    POST post = (POST) annotation;
                    routes.add(new Route(this, post.route(), RequestMethod.POST, method));
                } else if (annotation.annotationType().isAssignableFrom(PUT.class)) {
                    PUT put = (PUT) annotation;
                    routes.add(new Route(this, put.route(), RequestMethod.PUT, method));
                } else if (annotation.annotationType().isAssignableFrom(PATCH.class)) {
                    PATCH patch = (PATCH) annotation;
                    routes.add(new Route(this, patch.route(), RequestMethod.PATCH, method));
                } else if (annotation.annotationType().isAssignableFrom(DELETE.class)) {
                    DELETE delete = (DELETE) annotation;
                    routes.add(new Route(this, delete.route(), RequestMethod.DELETE, method));
                }
            }

        }
    }
}
