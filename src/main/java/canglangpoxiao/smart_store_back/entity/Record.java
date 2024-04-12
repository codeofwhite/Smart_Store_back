package canglangpoxiao.smart_store_back.entity;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

  private long id;
  private String uid;
  private String it_name;
  private String stg_name;
  private String room_name;
  private String layout_name;
  private long layout_id;
  private long in_flag;
  Timestamp ruchu_time;
  long it_id;
}
