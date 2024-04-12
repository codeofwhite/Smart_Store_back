package canglangpoxiao.smart_store_back;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {
    private String u_tel;
    private String upwd;

    // 必须要有无参构造器，这是Jackson库反序列化JSON所必需的
    public LoginDTO() {
    }

    public LoginDTO(String u_tel, String upwd) {
        this.u_tel = u_tel;
        this.upwd = upwd;
    }
}