package pers.calmerowl.domain;

import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/5/2 18:04
 * @version: 1.0.0
 */
public class QueryVo {

    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
