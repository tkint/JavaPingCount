package fr.epsi.i4.pingcount.ws;

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
		count++;
		return PONG;
	}

	@RequestMapping(basePath + "/count")
	public int count() {
		return count;
	}
}