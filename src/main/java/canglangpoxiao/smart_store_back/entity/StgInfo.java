package canglangpoxiao.smart_store_back.entity;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StgInfo {

  private long stg_id;
  private long room_id;
  private String stg_name;
  private double stg_size;
  private long uid;
  String stg_img;
  long stg_fav;


}
