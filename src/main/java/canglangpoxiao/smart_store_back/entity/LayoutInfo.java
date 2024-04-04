package canglangpoxiao.smart_store_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="layout_info")
@Entity
public class LayoutInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long layout_id;
  private String layout_name;
  private double layout_size;
  private long room_num;
  private long layout_fav;
  private long uid;

}
