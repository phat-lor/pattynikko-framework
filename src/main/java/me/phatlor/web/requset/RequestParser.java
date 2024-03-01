package me.phatlor.web.requset;

import me.phatlor.web.application.Application;


public class RequestParser {
    public static Request parse(Application application, RequestSender sender) throws Exception {
        String requestLine = sender.getIn().readLine();
        String[] split = requestLine.split(" ");

        Request request = new Request(application, sender);
        request.setMethod(RequestMethod.valueOf(split[0]));
        request.setRoute(split[1]);
        request.setBody(sender.getIn().readLine());

        return request;
    }

}
