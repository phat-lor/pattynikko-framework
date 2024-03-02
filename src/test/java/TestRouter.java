import nikko.pat.webframework.requset.Request;
import nikko.pat.webframework.response.ContentType;
import nikko.pat.webframework.response.Response;
import nikko.pat.webframework.response.StatusCode;
import nikko.pat.webframework.routes.Router;
import nikko.pat.webframework.routes.annotation.GET;
import nikko.pat.webframework.routes.annotation.POST;

public class TestRouter implements Router {
    @GET(route = "/")
    public void home(Request request, Response response) {
        request.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));

        response.setStatusCode(StatusCode.OK);
        response.setContentType(ContentType.HTML);
        response.send("<h1>Hello, World!</h1>");
    }

    @POST(route = "/nikko")
    public void nikko(Request request, Response response) {
        request.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));

        response.setContentType(ContentType.JSON);
        response.send("Test");
    }
}
