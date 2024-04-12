package canglangpoxiao.smart_store_back.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (UserPost)实体类
 *
 * @author makejava
 * @since 2024-04-10 21:58:10
 */
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPost implements Serializable {

    private Long id;

    private Long uid;

    private Long u_post_num;

    private Long u_fans_num;

    private Long ulikes;

}

