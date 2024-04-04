package canglangpoxiao.smart_store_back.controller;

public class LoginDTO {
    private String u_tel;
    private String upwd;

    // 必须要有无参构造器，这是Jackson库反序列化JSON所必需的
    public LoginDTO() {
    }

    public LoginDTO(String u_tel, String userPassword) {
        this.u_tel = u_tel;
        this.upwd = userPassword;
    }

    // getter和setter方法
    public String getUserTel() {
        return u_tel;
    }

    public void setUserTel(String userTel) {
        this.u_tel = userTel;
    }

    public String getPassword() {
        return upwd;
    }

    public void setPassword(String userPassword) {
        this.upwd = userPassword;
    }
}