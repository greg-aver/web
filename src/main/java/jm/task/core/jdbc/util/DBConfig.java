package jm.task.core.jdbc.util;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class DBConfig {
    private String url;
    private String username;
    private String password;
    private String show_sql;
    private String dialect;
    private String driver;
    private String hbm2ddl;
    private String daotype;

    public DBConfig() {
        Properties properties = new Properties();
        try (InputStream inputStream = DBConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(inputStream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password ");
            show_sql = properties.getProperty("show_sql");
            dialect = properties.getProperty("dialect");
            driver = properties.getProperty("driver");
            hbm2ddl = properties.getProperty("hbm2ddl");
            daotype = properties.getProperty("daotype");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
