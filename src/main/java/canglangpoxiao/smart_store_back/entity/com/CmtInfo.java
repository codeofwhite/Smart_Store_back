package canglangpoxiao.smart_store_back.entity.com;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmtInfo {

  private long cmt_id;
  private long cmt_reply_num;
  private long cmt_likes;
  private long post_id;
  private String cmt_detail;
  private java.sql.Timestamp cmt_rls_time;


}
