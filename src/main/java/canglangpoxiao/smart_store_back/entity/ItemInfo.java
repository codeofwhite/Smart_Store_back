package canglangpoxiao.smart_store_back.entity;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfo {

  long it_id;
  String it_type;
  private java.sql.Date best_before;
  private java.sql.Date date_in_produced;
  private long stg_id;
  private double it_size;
  private long it_fav;
  String it_name;
  long uid;
  String it_img;

}
