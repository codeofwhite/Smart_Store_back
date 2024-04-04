package canglangpoxiao.smart_store_back.entity;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomInfo {

  private long room_id;
  private long layout_id;
  private String room_name;
  private double room_size;
  private long uid;


}
