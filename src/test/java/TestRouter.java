import nikko.pat.webframework.requset.Request;
import nikko.pat.webframework.response.ContentType;
import nikko.pat.webframework.response.Response;
import nikko.pat.webframework.response.StatusCode;
import nikko.pat.webframework.routes.Router;
import nikko.pat.webframework.routes.annotation.GET;
import nikko.pat.webframework.routes.annotation.POST;

public class TestRouter implements Router {
    @GET(route = "/")
    public void home(Request request, Response response) throws Exception {
        response.setStatusCode(StatusCode.BAD_GATEWAY);
        response.setContentType(ContentType.HTML);
        response.send("<h1>Hello, World!</h1>");
    }

    @POST(route = "/nikko")
    public void nikko(Request request, Response response) throws Exception {
        System.out.println(request.getHeaders());
        response.setContentType(ContentType.JSON);
        response.send("{\"name\": \"Nikko\"}");
    }
}
