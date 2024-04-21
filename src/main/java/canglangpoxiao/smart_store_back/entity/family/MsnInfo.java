package canglangpoxiao.smart_store_back.entity.family;

import lombok.*;

import java.sql.Timestamp;

/**
 * (MsnInfo)实体类
 *
 * @author makejava
 * @since 2024-04-07 21:36:31
 */
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsnInfo{

    private Long msn_id;

    private String msn_name;

    private String msn_desc;

    private Integer msn_flag;
/**
     * 任务的发起者
     */
    private Integer uid_msn_starter;

    long layout_id;

    Timestamp dispatch_time;

}
