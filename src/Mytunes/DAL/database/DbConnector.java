package Mytunes.DAL.database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DbConnector {
    private SQLServerDataSource dataSource;

    public DbConnector(){
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("CSe21B_4_3");
        dataSource.setUser("CSe21B_4");
        dataSource.setPassword("CSe21B_4");
        dataSource.setPortNumber(1433);
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }
}
