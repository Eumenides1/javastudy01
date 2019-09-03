package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DBUtils.closeConnectionPool();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String dir = event.getServletContext().getRealPath("/WEB-INF/classes");
		File file = new File(dir, "db.properties");
		Properties props = new Properties();
		Reader reader = null;
		try {
			reader = new FileReader(file);
			props.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String url = props.getProperty("db_url");
		String userName = props.getProperty("db_user");
		String password = props.getProperty("db_pwd");
		DBUtils.initConnectionPool(url, userName, password);
	}

}
