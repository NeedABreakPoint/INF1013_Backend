package INF1013.my_restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() {
		try (Connection connection = dataSource.getConnection()) {
			assertTrue(connection.isValid(1));
		} catch (Exception e) {
			fail("Should have connected to the database", e);
		}
	}
}
