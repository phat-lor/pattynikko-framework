package nikko.pat.webframework.requset;

import nikko.pat.webframework.application.Application;


public class RequestParser {
    public static Request parse(Application application, RequestSender sender) throws Exception {
        String requestLine = sender.getIn().readLine();
        String[] split = requestLine.split(" ");

        Request request = new Request(application, sender);
        request.setMethod(RequestMethod.valueOf(split[0]));
        request.setRoute(split[1]);
        sender.getIn().lines().forEach(line -> {
            if (line.isEmpty()) {
                return;
            }
            String[] header = line.split(": ");
            request.getHeaders().put(header[0], header[1]);
        });
        return request;
    }

}
