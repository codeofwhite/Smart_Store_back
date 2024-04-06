package canglangpoxiao.smart_store_back.entity;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    long uid;
    String uname;
    String upwd;
    long usex;
    String u_signature;
    long u_lvl;
    long u_fam_num;
    long u_layout_num;
    long u_it_num;
    long u_online;
    String u_img;
    String u_tel;
}
