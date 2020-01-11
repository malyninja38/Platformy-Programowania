package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class CoffeeDao {

	private static NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		DataSource data = DbUtilities.getDataSource("jdbc:sqlserver://LAPTOP-H2G6J9IU\\SQL;databaseName=PP;integratedSecurity=true");         // zwraca obiekt
		this.jdbc = new NamedParameterJdbcTemplate(data);
	}


	 List<Coffee> getAll() {
		String sql = "SELECT COF_NAME, SUP_ID, PRICE, SALES, TOTAL FROM COFFEES";
		return jdbc.query(sql, new ResultSetExtractor<ArrayList<Coffee>>() {

			ArrayList<Coffee> coffeelist = new ArrayList<>();

			@Override
			public ArrayList<Coffee> extractData(ResultSet rs) throws SQLException, DataAccessException {

					Coffee coffee;

					while(rs.next()){
						coffee = new Coffee((rs.getString("COF_NAME")), rs.getInt("SUP_ID"), rs.getBigDecimal("PRICE"),
								rs.getInt("SALES"), rs.getInt("TOTAL"));
						coffeelist.add(coffee);
					}
				return coffeelist;
			}
		});
	}


}