package net.kkuru.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author kkuru
 * 
 * Use not Context
 * 
 * Dao Test 및 Embedded 테스트
 *
 */
public class UserDaoTest {

	private EmbeddedDatabase database;

	@Before
	public void setUp() throws Exception {
		database = new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.HSQL)
			.addDefaultScripts().build();
		assertNotNull(database);
	}

	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

	@Test
	public void shouldFindUserByUsername() {
		UserDao dao = new UserDao();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
		dao.setJdbcTemplate(jdbcTemplate);
		
		String findName = "eric";
		User user = dao.findByName(findName);
		assertNotNull(user);
		assertEquals(findName, user.getName());
		
		List<User> users = dao.findList();
		
		assertEquals(5, users.size());
	}
}