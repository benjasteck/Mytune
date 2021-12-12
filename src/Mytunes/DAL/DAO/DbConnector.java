package Mytunes.DAL.DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DbConnector {
    private SQLServerDataSource dataSource;

    public void DatabaseConnector(){
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("CSe21B_4_2");
        dataSource.setUser("CSe21B_4");
        dataSource.setPassword("CSe21B_4");
        dataSource.setPortNumber(1433);
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }
}
