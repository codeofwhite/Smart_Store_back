package canglangpoxiao.smart_store_back.entity.com;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffInfo {

  private long off_id;
  private String off_name;
  private java.sql.Timestamp off_time;
  private long off_like;
  private long off_cmt;


}
