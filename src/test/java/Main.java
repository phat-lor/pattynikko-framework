import nikko.pat.webframework.application.Application;
import nikko.pat.webframework.application.ApplicationSettings;

public class Main {
    private static Application app;
    public static void main(String[] args) {
        ApplicationSettings settings = new ApplicationSettings().setDebug(true).setPort(8080);
        app = new Application(settings);
        app.getRouteManager().addRouter(new TestRouter());
        app.start();
    }

    public static Application getApp() {
        return app;
    }
}
