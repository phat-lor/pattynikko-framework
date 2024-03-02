package nikko.pat.webframework.requset;

import nikko.pat.webframework.application.Application;

import java.io.IOException;


public class RequestParser {
    public static Request parse(Application application, RequestSender sender) throws IOException {
        String requestLine = sender.getIn().readLine();
        String[] split = requestLine.split(" ");

        Request request = new Request(application, sender);
        request.setMethod(RequestMethod.valueOf(split[0]));
        request.setRoute(split[1]);
        for (String line = sender.getIn().readLine(); !line.isEmpty(); line = sender.getIn().readLine()) {
            String[] header = line.split(": ");
            request.getHeaders().put(header[0], header[1]);
        }

        StringBuilder bodyBuilder = new StringBuilder();
        while (sender.getIn().ready()) {
            bodyBuilder.append((char) sender.getIn().read());
        }
        request.setBody(bodyBuilder.toString());

        return request;
    }

}
