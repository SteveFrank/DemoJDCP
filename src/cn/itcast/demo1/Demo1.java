package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP连接池
 * @author 杨谦
 * @date 2015-8-15 下午3:26:44
 *
 */
public class Demo1 {
	@Test
	public void fun1() throws SQLException{
		/*
		 * 可重用！
		 * 1、创建连接池对象
		 * 2、配置四大参数
		 * 3、配置池参数
		 * 4、得到连接对象
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb1");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(1000);//1s
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn.getClass().getName());
		/**
		 * 1、连接池内部使用的是四大参数创建了连接对象！即Mysql提供了Connection
		 * 2、连接池使用了mysql的连接对象进行了装饰，只是对于close（）方法进行了增强
		 * 3、装饰之后的Connection的close()方法，用来归还当前连接
		 */
		conn.close();
	}
}
