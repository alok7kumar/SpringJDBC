package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {

	public JdbcTemplate jdbctemp;

	public Repo(DataSource dataSource) {
		this.jdbctemp = new JdbcTemplate(dataSource);
	}

	//Insert query
	public void insertData(int id, String name) {
		String sql = "INSERT INTO jdbc (id, name) VALUES (?,?)";
			jdbctemp.update(sql, id, name);
			System.out.println("inserted");
		}
	
	//Update query
	public void updateData(int id, String name) {
		String sql = "UPDATE jdbc set name = ? where id=?";
			jdbctemp.update(sql, name, id);
		System.out.println("updated");
	}
	
	//Delete query
	public void deleteData(int id) {
		String sql = "DELETE from jdbc where id=?";
			jdbctemp.update(sql, id);
		System.out.println("deleted");
	}
	
	//Fetch : multiple row
	public List<String> fetchData() {
			String sql = "SELECT * from jdbc";
			return jdbctemp.query(sql, new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString(1)+" "+rs.getString(2);
				}
			}); 
		}
	
	//Fetch : by id(single row)
	public String fetchById(int id) {
		String sql = "SELECT name FROM jdbc WHERE id = ? ";
		return jdbctemp.queryForObject(sql, new Object[] {id}, String.class);
	}
}
