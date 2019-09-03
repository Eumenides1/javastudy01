package Spring_List;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Eumenides
 */
public class SampleBean {

    private List<String> provinces;
    private Set<String> city;
    private Map<String,String> session;
    private Properties DBconfig;

    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    public List<String> getProvinces() {
        return provinces;
    }

    public Set<String> getCity() {
        return city;
    }

    public void setCity(Set<String> city) {
        this.city = city;
    }

    public Map<String, String> getSession() {
        return session;
    }

    public void setSession(Map<String, String> session) {
        this.session = session;
    }

    public Properties getDBconfig() {
        return DBconfig;
    }

    public void setDBconfig(Properties DBconfig) {
        this.DBconfig = DBconfig;
    }
}
