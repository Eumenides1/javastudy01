package Spring_List;

import java.util.Set;

/**
 * @author Eumenides
 */
public class Student {

    private String province;

    private Set<String> cities;

    private String username;

    private String jdbcUrl;

    private String jdbcDriver;

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Student{" +
                "province='" + province + '\'' +
                ", cities=" + cities +
                ", username='" + username + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", jdbcDriver='" + jdbcDriver + '\'' +
                '}';
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }
}
