import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nikko.pat.webframework.requset.Request;
import nikko.pat.webframework.response.ContentType;
import nikko.pat.webframework.response.Response;
import nikko.pat.webframework.routes.Router;
import nikko.pat.webframework.routes.annotation.GET;
import nikko.pat.webframework.routes.annotation.POST;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CatRouter implements Router {
    // Cat name and their weight
    private final Map<String, Double> cats = new HashMap<>();


    // Test with curl -X GET
    @GET(route = "/cat")
    public void getCats(Request request, Response response) {
        response.setContentType(ContentType.JSON);
        Gson gson = new Gson();
        String gsonData = gson.toJson(cats);

        response.send(gsonData);
    }

    // Test with curl -X POST -d '{"cat1": 5.0, "cat2": 6.0}'
    @POST(route = "/cat")
    public void addCat(Request request, Response response) {
        String requestBody = request.getBody();

        if (requestBody != null && !requestBody.isEmpty()) {
            Gson gson = new Gson();
            Type typeObject = new TypeToken<HashMap<String, Double>>() {}.getType();
            Map<String, Double> catMap = gson.fromJson(requestBody, typeObject);

            cats.putAll(catMap);
            response.send("Cat(s) added");
        } else {
            response.send("Invalid request body");
        }
    }
}
