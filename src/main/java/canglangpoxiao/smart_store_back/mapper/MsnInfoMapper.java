package canglangpoxiao.smart_store_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsnInfoMapper {
    void insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                   @Param("uid_msn_starter") long uid_msn_starter, @Param("uid_assigned") long uid_assigned);
}
