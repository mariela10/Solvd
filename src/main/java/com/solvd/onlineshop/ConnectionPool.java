package com.solvd.onlineshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool 
   {
 
    private String url;
    private String user;
    private String password;
    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(10);
    private AtomicInteger connCount = new AtomicInteger();
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;
     
    public ConnectionPool(String url, String user, String password, BlockingQueue<Connection> pool) {
		
	}



	public static ConnectionPool init(
      String url, String user, 
      String password) throws SQLException {
  
		BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        
        return  new ConnectionPool(url, user, password, pool);
    }
     
    
     
  
    public Connection getConnection() throws Exception {
        Connection conn = pool.poll(5, TimeUnit.SECONDS);
        if (conn == null) {
     
      synchronized (connCount) {
     
     
    if (connCount.get() < INITIAL_POOL_SIZE) {
     
     
        conn = getConnection();
     
     
        pool.offer(conn);
     
     
        connCount.incrementAndGet();
     
     
    }
     
      }
     
      if (conn == null) {
     
     
    throw new Exception();
     
      } else  return conn;
     
    }
        return conn;
        }
    
   
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
     
    private static Connection createConnection(
      String url, String user, String password) 
      throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
     
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
 
   }