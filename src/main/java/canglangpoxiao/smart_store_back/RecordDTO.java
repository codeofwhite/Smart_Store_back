package canglangpoxiao.smart_store_back;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class RecordDTO {
    long uid;
    String it_name;
    String stg_name;
    String room_name;
    String layout_name;
    long layout_id;
    long it_id;
}
