package beans.auto;

import beans.auto.user.User;
import beans.auto.user.impl.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component(value = "complicateBean")
public class ComplicateBean {
    @Autowired
    private Master master;

    private String name;

    private List<User> userList;

    private Map<String, User> userMap;

    private Properties properties;

    public ComplicateBean(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("ComplicateBean Init!");
    }

    public void destroy() {
        System.out.println("ComplicateBean Destroy!");
    }

    public void setMaster(Master master) {
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Master getMaster() {
        return master;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Properties getProperties() {
        return properties;
    }
}
