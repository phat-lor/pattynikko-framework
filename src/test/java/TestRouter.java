import me.phatlor.web.requset.Request;
import me.phatlor.web.response.ContentType;
import me.phatlor.web.response.Response;
import me.phatlor.web.response.StatusCode;
import me.phatlor.web.routes.Router;
import me.phatlor.web.routes.annotation.GET;

public class TestRouter implements Router {
    @GET(route = "/")
    public void home(Request request, Response response) throws Exception {
        response.setStatusCode(StatusCode.BAD_GATEWAY);
        response.setContentType(ContentType.HTML);
        response.send("<h1>Hello, World!</h1>");
    }
}
