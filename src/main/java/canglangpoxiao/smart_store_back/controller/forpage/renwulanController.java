package canglangpoxiao.smart_store_back.controller.forpage;

import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class renwulanController {
    @Autowired
    MsnRepository msnRepository;

    // 添加新任务
    @RequestMapping(value = "/insetMsn", method = RequestMethod.POST)
    String insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                     @Param("uid_msn_starter") long uid_msn_starter, @Param("uid_assigned") long uid_assigned){
        msnRepository.insertMsn(msn_name, msn_desc, uid_msn_starter);
        msnRepository.insertMsnFamily(msn_name,uid_assigned,uid_msn_starter);
        return "插入成功";
    }

    // 增加派遣人员
    @RequestMapping(value = "/insertMsnFamily", method = RequestMethod.POST)
    String insertMsnFamily(@Param("msn_name") String msn_name,
                     @Param("uid_msn_starter") long uid_msn_starter, @Param("uid_assigned") long uid_assigned){
        msnRepository.insertMsnFamily(msn_name,uid_assigned,uid_msn_starter);
        return "插入成功";
    }

    // 清空自己发布的全部任务
    // 不确定要不要用，先不写
    @RequestMapping(value = "/deleteMsnByUid", method = RequestMethod.POST)
    String deleteMsnByUid(@Param("uid_msn_starter") long uid_msn_starter){
        return "删除成功";
    }


    // 编辑任务描述、名字
    @RequestMapping(value = "/editMsn", method = RequestMethod.POST)
    String editMsn(@Param("uid_msn_starter") long uid_msn_starter){
        return "编辑成功";
    }

    // 调整任务状态
    @RequestMapping(value = "/updateMsnState", method = RequestMethod.POST)
    String updateMsnState(long msn_flag, String msn_name, long uid_msn_starter){
        msnRepository.updateMsnState(msn_flag,msn_name,uid_msn_starter);
        return "更新成功";
    }
}
