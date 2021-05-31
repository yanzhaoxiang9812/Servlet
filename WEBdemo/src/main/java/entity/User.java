package entity;

public class User {
    private String id;
    private String sn;
    private String name;
    private String password;
    private String clazz_id;
    private String sex;
    private String mobile;
    private String qq;

    public User() {
    }

    public User(String id, String sn, String name, String password, String clazz_id, String sex, String mobile, String qq) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.password = password;
        this.clazz_id = clazz_id;
        this.sex = sex;
        this.mobile = mobile;
        this.qq = qq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(String clazz_id) {
        this.clazz_id = clazz_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
