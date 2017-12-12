package fr.epsi.i4.pingcount;

import fr.epsi.i4.pingcount.ws.Config;
import fr.epsi.i4.pingcount.ws.PingCount;
import io.sentry.Sentry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static String port;

    public static String dsn;

    public static void main(String[] args) {
        Sentry.init(dsn);

        SpringApplication.run(Main.class, args);

        String msg = "Services PingCount disponibles à l'adresse http://localhost:" + port + PingCount.basePath;
        msg += "\nServices Config disponibles à l'adresse http://localhost:" + port + Config.basePath;

        System.out.println(msg);

        Sentry.capture(msg);
    }

    @Value("${server.port}")
    public void setPort(String value) {
        port = value;
    }

    @Value("${sentry.dsn}")
    public void setDsn(String value) {
        dsn = value;
    }
}
