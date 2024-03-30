package canglangpoxiao.smart_store_back.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String uid;
    String uname;
    String upwd;

    public String getUserId() {
        return uid;
    }

    public void setUserId(String uid) {
        this.uid = uid;
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
