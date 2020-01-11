package pl.poznan.put.cie.coffee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		DataSource data = DbUtilities.getDataSource("jdbc:sqlserver://LAPTOP-H2G6J9IU\\SQL;databaseName=PP;integratedSecurity=true");         // zwraca obiekt
		this.jdbc = new NamedParameterJdbcTemplate(data);
	}

	public Coffee get(final String name) {
		String sql = "SELECT SUP_ID, PRICE, SALES, TOTAL FROM COFFEES WHERE COF_NAME = :cof_name";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);
		return jdbc.query(sql, params, new ResultSetExtractor<Coffee>() {

			@Override
			public Coffee extractData(ResultSet rs) throws SQLException, DataAccessException {

				Coffee coffee = null;

				if(rs.next()){
					coffee = new Coffee(name, rs.getInt("SUP_ID"), rs.getBigDecimal("PRICE"),
							rs.getInt("SALES"), rs.getInt("TOTAL"));
				}
				return coffee;
			}
		});
	}

	public ArrayList<Coffee> getAll() {
		String sql = "SELECT COF_NAME, SUP_ID, PRICE, SALES, TOTAL FROM COFFEES";
		return jdbc.query(sql, new ResultSetExtractor<ArrayList<Coffee>>() {

			ArrayList<Coffee> coffeelist = new ArrayList<>();

			@Override
			public ArrayList<Coffee> extractData(ResultSet rs) throws SQLException, DataAccessException {

					Coffee coffee = null;

					while(rs.next()){
						coffee = new Coffee((rs.getString("COF_NAME")), rs.getInt("SUP_ID"), rs.getBigDecimal("PRICE"),
								rs.getInt("SALES"), rs.getInt("TOTAL"));
						coffeelist.add(coffee);
					}

				return coffeelist;
			}
		});
	}

	public void update(Coffee c) {
		String sql = "UPDATE coffees "
				  + "SET price = :price, sales = :sales, total = :total "
				  + "WHERE cof_name = :cof_name AND sup_id = :sup_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}

	public void delete(String name, int supplierId) {

		String sql = "DELETE FROM COFFEES WHERE COF_NAME = :name AND SUP_ID = :sup_id";
		Map <String, Object> coff = new HashMap<>();

		coff.put("name", name);
		coff.put("sup_id", supplierId);

		System.out.println(jdbc.update(sql, coff) + " rows deleted");
	}

	public void create(Coffee c) {
		String sql = "INSERT INTO COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) VALUES(:name, :sup_id, :price, :sales, :total)";
		Map <String, Object> coff = new HashMap<>();

		coff.put("name", c.getName());
		coff.put("sup_id", c.getSupplierId());
		coff.put("price", c.getPrice());
		coff.put("sales", c.getSales());
		coff.put("total", c.getTotal());

		System.out.println(jdbc.update(sql, coff) + " rows affected");
	}

}