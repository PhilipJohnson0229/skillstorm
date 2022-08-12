package com.InventoryManagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.InventoryManagement.utils.CustomPasswordEncoder;

@Service
public class RegistrationService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	public void register(String username, String password) {
		// hash password upon registration
		String hash = passwordEncoder.getPasswordEncoder().encode(password);

		// insert the user and associated roles
		String userSql = "insert into users values(?, ?, true)";
		String authSql = "insert into authorities values(?, 'ROLE_USER')";
		jdbcTemplate.update(userSql, new String[] { username, hash }, new int[] { Types.VARCHAR, Types.VARCHAR });
		jdbcTemplate.update(authSql, new String[] { username }, new int[] { Types.VARCHAR });
	}

}
