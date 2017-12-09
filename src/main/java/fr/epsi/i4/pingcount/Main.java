package fr.epsi.i4.pingcount;

import fr.epsi.i4.pingcount.ws.PingCount;
import io.sentry.Sentry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SpringBootApplication
public class Main {

    private static String port;

    public static void main(String[] args) {
        Sentry.init();

        SpringApplication.run(Main.class, args);

        String msg = "Services PingCount disponibles à l'adresse http://localhost:" + port + PingCount.basePath;

        System.out.println(msg);

        Sentry.capture(msg);
    }

    @Value("${server.port}")
    public void setPort(String value) {
        port = value;
    }

}
