package net.kkuru.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	private User user;
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbc;


	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbc = jdbcTemplate;
	}

	public User findByName(String name) {
		String sql = "select * from users where name = ?";;
		User user = jdbc.queryForObject(sql, new Object[]{name}, new UserMapper());
		return user;
	}
	
	public List<User> findList(){
		String sql = "select * from users";
		List<User> users = jdbc.query(sql, new UserMapper());
		return users;
	}
	
	public void create(int idx, String name) {
		String sql = "insert into Users (idx, name) values (?, ?)";
		jdbc.update(sql, idx, name);
		System.out.println("Created Record Name = " + name + " idx = " + idx);
	}

	public void deleteByName(String name){
		String sql = "delete from users where name = ?";
		jdbc.update(sql, name);
	}

	public int getMaxIdx() {
		return jdbc.queryForInt("select max(idx) from users");
	}
}
