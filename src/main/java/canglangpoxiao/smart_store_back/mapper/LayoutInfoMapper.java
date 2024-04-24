package canglangpoxiao.smart_store_back.mapper;

import canglangpoxiao.smart_store_back.entity.LayoutInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LayoutInfoMapper {
    List<LayoutInfo> findAllLayout(@Param("uid") long uid);

    void insertLayout(@Param("uid") long uid, @Param("layout_name") String layout_name,
                      @Param("layout_size") long layout_size, @Param("layout_img") String layout_img);

    List<LayoutInfo> getLayoutId(@Param("uid") long uid);

    public long getFamNum(long layout_id);

    void insertLayoutFamily(long uid, long id);
    long selectLastInsertId();

}
