package zz.itcast.ecservice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author wxj <br/>
 *         ① 注册驱动 <br/>
 *         ② 创建连接 <br/>
 *         ③ 创建语句<br/>
 *         ④ 执行语句<br/>
 *         ⑤ 处理结果<br/>
 *         ⑥ 释放资源<br/>
 */
public class JDBCTest {
	private static final String URL = "jdbc:mysql:///ecz8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	@Test
	public void select() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// ① 注册驱动 <br/>
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// * ② 创建连接 <br/>
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			// * ③ 创建语句<br/>
			statement = connection.createStatement();
			// * ④ 执行语句<br/>
			String sql = "SELECT * FROM help WHERE version>0 AND state =1";
			resultSet = statement.executeQuery(sql);
			// * ⑤ 处理结果<br/>
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				System.out.println("id = " + id + ":::: title=" + title);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// * ⑥ 释放资源<br/>
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Test
	public void select1() {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			// ① 注册驱动 <br/>
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// * ② 创建连接 <br/>
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			// * ④ 执行语句<br/>
			String sql = "SELECT * FROM help WHERE version>0 AND state =1";
			// * ③ 创建语句<br/>
			prepareStatement = connection.prepareStatement(sql);
//			prepareStatement.setInt(1, 0);
			resultSet = prepareStatement.executeQuery(sql);
			// * ⑤ 处理结果<br/>
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				System.out.println("id = " + id + ":::: title=" + title);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// * ⑥ 释放资源<br/>
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (prepareStatement != null) {
						prepareStatement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
