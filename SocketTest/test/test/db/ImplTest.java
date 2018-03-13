//package test.db;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import org.junit.Test;
//
//import com.lab.sockettest.console.util.BizUtil;
//import com.lab.sockettest.model.bean.Device;
//
//import shit.db.ShitDBSession;
//import shit.db.ShitDBSessionFactory;
//import shit.db.cfg.ShitDBC3P0DataSource;
//import shit.db.cfg.ShitDBDataSource;
//import shit.db.exception.ShitDBConfigureException;
//import shit.db.exception.ShitDBConnectException;
//import shit.db.exception.ShitDBExecuteException;
//import shit.db.exception.ShitDBJDBCException;
//import shit.db.exception.ShitDBTranslateException;
//import shit.db.exception.ShitDBWrongControlException;
//import shit.db.impl.ShitDBSessionJDBCFactory;
//import shit.db.query.ShitDBPager;
////import shit.helper.security.MD5Util;
//import test.db.model.Trade;
//import test.db.model.User;
//
//public class ImplTest {
//	public ShitDBSession getSession() {
//		Properties props = new Properties();
//		props.setProperty("driverClass", "com.mysql.jdbc.Driver");
//		props.setProperty("jdbcUrl", "jdbc:mysql://47.95.212.171:3306/marryapp?characterEncoding=UTF-8");
//		props.setProperty("user", "root");
//		props.setProperty("password", "wsn331331");
//		ShitDBDataSource dataSource = new ShitDBC3P0DataSource();
//		dataSource.setDataSourceByProperties(props);
//		dataSource.setShowSql(true);
//		ShitDBSessionFactory factory = new ShitDBSessionJDBCFactory();
//		factory.setDataSource(dataSource);
//		try {
//			return factory.getSession();
//		} catch (ShitDBConnectException e) {
//			e.printStackTrace();
//		} catch (ShitDBConfigureException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	@Test
//	public void testBizImpl() {
//		Device device = BizUtil.getDeviceBiz().findByDeviceId("dlkz000111111111");
//		System.out.println(device);
//	}
//	
//	@Test
//	public void testQuery() {
//		String shitQL = "select * from " + User.class.getName() + 
//				" o where o.id=:id order by o.id";		
//		Map<String, Serializable> params = new HashMap<>(1);
//		params.put("id", 1);
//		ShitDBPager pager = new ShitDBPager(1, 1);
//		ShitDBSession session = getSession();
//		try {
//			@SuppressWarnings("unchecked")
//			List<User> list = (List<User>) session.findAll(User.class);
//			for (User model : list) {
//				System.out.println(model);
////				(model).setPassword(MD5Util.getMD5(model.getPassword()));
//				session.update(model);
//				
//			}
//		} catch (ShitDBJDBCException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ShitDBWrongControlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ShitDBConfigureException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ShitDBTranslateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testExecute() {
//		Trade trade = new Trade();
//		trade.setCount(1);
//		trade.setCutTime(new Date());
//		trade.setDiscount((float) 0.8);
//		trade.setName("xxxx");
//		User user = new User();
//		user.setId((long) 1);
//		trade.setUser(user);
//		trade.setId((long)16);
//		ShitDBSession session = getSession();
//		try {
//			session.delete(trade);
//		} catch (ShitDBExecuteException e) {
//			e.printStackTrace();
//		} catch (ShitDBConfigureException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(trade);
//		System.out.println(trade.getId());
//	}
//}
