package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.entity.family.MsnInfo;
import canglangpoxiao.smart_store_back.repository.MsnRepository;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.sql.Date;
import java.util.List;

@RestController
public class renwulanController {
    @Autowired
    MsnRepository msnRepository;

    // 拉取任务
    @RequestMapping(value = "/selectMsn", method = RequestMethod.POST)
    // 刷新任务
    List<MsnInfo> selectMsn(@RequestParam("layout_id") long layout_id){
        return msnRepository.selectMsn(layout_id);
    }

    // 添加新任务
    @Transactional
    @RequestMapping(value = "/insetMsn", method = RequestMethod.POST)
    long insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc, @Param("uid_assigned") String uid_assigned,
                     @Param("uid_msn_starter") long uid_msn_starter, Date dispatch_time, long layout_id){
        msnRepository.insertMsn(msn_name, msn_desc, uid_assigned, uid_msn_starter, dispatch_time, layout_id);
        long msn_id =  msnRepository.selectLastMsnInsertId();
        // 这边要改
        return msn_id;
    }

    // 清空自己发布的全部任务
    @RequestMapping(value = "/deleteMsnByUid", method = RequestMethod.POST)
    String deleteMsnByUid(@Param("uid_msn_starter") long uid_msn_starter){

        msnRepository.deleteMsnByUid(uid_msn_starter);
        return "删除成功";
    }

    // 编辑任务描述 半OK
    @RequestMapping(value = "/editMsn", method = RequestMethod.POST)
    String editMsn(@RequestParam long msn_id, String msn_name, String msn_desc, long msn_flag){
        msnRepository.editMsn(msn_id, msn_name, msn_desc, msn_flag);
        return "编辑成功";
    }

    // OK
    @RequestMapping(value = "/deleteOneMsn", method = RequestMethod.POST)
    String deleteOneMsn(@Param("msn_id") long msn_id)
    {
        msnRepository.deleteOneMsn(msn_id);
        return "删除成功";

    }
}
