import me.phatlor.web.requset.Request;
import me.phatlor.web.response.ContentType;
import me.phatlor.web.response.Response;
import me.phatlor.web.response.StatusCode;
import me.phatlor.web.routes.Router;
import me.phatlor.web.routes.annotation.GET;
import me.phatlor.web.routes.annotation.POST;

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
