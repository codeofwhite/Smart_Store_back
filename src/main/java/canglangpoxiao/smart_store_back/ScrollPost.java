package canglangpoxiao.smart_store_back;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrollPost {

    private long post_id;
    String post_name;
    private String post_media;
    private String post_detail;
    private java.sql.Timestamp post_rls_time;
    private long post_rp_num;
    private long uid;
    private long post_likes;
    private String uname;

}
