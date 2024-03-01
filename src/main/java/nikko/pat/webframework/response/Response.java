package nikko.pat.webframework.response;

import nikko.pat.webframework.requset.Request;

import java.io.PrintWriter;

public class Response {
    private final Request request;
    private StatusCode statusCode;
    private ContentType contentType;

    public Response(Request request) {
        this.request = request;
    }

    public void send(String body) throws Exception {
        PrintWriter out = request.getSender().getOut();
        out.println("HTTP/1.1 " + statusCode.getCode() + " " + statusCode.name().replaceAll("_", " "));
        out.println("Content-Type: " + contentType.getValue());
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);

        request.getSender().close();
    }


    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

}
