package fr.epsi.i4.pingcount.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PingCountTest {

	private static final String PONG = "pong";

	@Autowired
	private PingCount pingCount;

	@Test
	public void should_return_pong() {
		// WHEN
		String returnedPing = pingCount.ping();
		// THEN
		assertThat(returnedPing).isEqualTo(PONG);
	}
}
