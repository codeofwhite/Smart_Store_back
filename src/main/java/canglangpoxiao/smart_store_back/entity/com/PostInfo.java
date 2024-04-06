package canglangpoxiao.smart_store_back.entity.com;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo {

  private long post_id;
  private String post_media;
  private String post_detail;
  private java.sql.Timestamp post_rls_time;
  private long post_rp_num;
  private long uid;
  private long post_likes;


}
