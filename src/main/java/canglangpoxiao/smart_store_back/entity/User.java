package canglangpoxiao.smart_store_back.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String u_tel;
    String uname;
    String upwd;
    String u_signature;

    public String getUserTel() {
        return u_tel;
    }

    public void setUserTel(String u_tel) {
        this.u_tel = u_tel;
    }

    public String getUserName() {
        return uname;
    }

    public void setUserName(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return upwd;
    }

    public void setPassword(String upwd) {
        this.upwd = upwd;
    }
}
