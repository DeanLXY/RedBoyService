package zz.itcast.ecservice.dao.balance;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zz.itcast.ecservice.domain.Invoice;
import zz.itcast.ecservice.utils.DataSourceManager;

public class InvoiceDaoImpl {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public List<Invoice> getInvoiceList(int userId ) {
		String sql = "SELECT title,content FROM invoiceinfo WHERE userId=?";
		try {
			return runner.query(sql, new BeanListHandler<Invoice>(Invoice.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
