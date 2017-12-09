package fr.epsi.i4.pingcount.ws;

import io.sentry.Sentry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thomas on 18/11/2017.
 */
@RestController
public class PingCount {

	public static final String basePath = "/PingCount";

	public static final String PONG = "pong";

	private static int count;

	@RequestMapping(basePath + "/ping")
	public String ping() {
        logSentry("ping", PONG);
        count++;
		return PONG;
	}

	@RequestMapping(basePath + "/count")
	public int count() {
        logSentry("count", count);
		return count;
	}

	private void logSentry(String service, Object answer) {
        String msg = "The service /" + service + " has been called. ";
        msg += "The answer was " + answer;
        Sentry.capture(msg);
    }
}