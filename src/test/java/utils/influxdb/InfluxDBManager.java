package utils.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class InfluxDBManager {
    private static final InfluxDB InfluxDbInstance = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
    private static final String DB_NAME = "selenium_test_results";
    static {
        InfluxDbInstance.setDatabase(DB_NAME);
    }
    public static void post(final Point point) {
        InfluxDbInstance.write(point);
    }
}
