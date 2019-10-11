package ua.kiev.appliances.repository;

import ua.kiev.appliances.DataBaseDeployer;
import ua.kiev.appliances.config.DataBaseConfig;

public class DBtest {
    static {
        DataBaseConfig.DB_DATABASE_URL = DataBaseConfig.DB_HOST;
        DataBaseDeployer.deployDb();
    }
}
