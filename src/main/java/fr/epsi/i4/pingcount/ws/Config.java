package fr.epsi.i4.pingcount.ws;

import fr.epsi.i4.pingcount.Main;
import io.sentry.Sentry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thomas on 18/11/2017.
 */
@RestController
public class Config {

    public static final String basePath = "/Config";

    @PostMapping(basePath + "/dsn")
    public String setDsn(@RequestBody String dsn) {
        Main.dsn = dsn;
        Sentry.init(dsn);
        return dsn;
    }

    @GetMapping(basePath + "/dsn")
    public String getDsn() {
        return Main.dsn;
    }
}