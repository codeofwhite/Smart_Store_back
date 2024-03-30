package canglangpoxiao.smart_store_back.controller;

public class LoginDTO {
    private String uid;
    private String upwd;

    // 必须要有无参构造器，这是Jackson库反序列化JSON所必需的
    public LoginDTO() {
    }

    public LoginDTO(String uid, String upwd) {
        this.uid = uid;
        this.upwd = upwd;
    }

    // getter和setter方法
    public String getUserId() {
        return uid;
    }

    public void setUserId(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return upwd;
    }

    public void setPassword(String upwd) {
        this.upwd = upwd;
    }
}