/*
* 问题：
* 总结
1. 建多一个msn和uig的中间表
2. select出该用户持有和被指派的任务
3. 若是持有的任务，就可以更改
*
* 更改的规则
1. 因为存在中间表中的有uid_assigned，就传参uid_assigned和msn_id改
* */

package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.repository.MsnRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsnController {
    @Autowired
    MsnRepository msnRepository;

    @RequestMapping(value = "/insetMsn", method = RequestMethod.POST)
    String insertMsn(@Param("msn_name") String msn_name, @Param("msn_desc") String msn_desc,
                     @Param("uid_msn_starter") long uid_msn_starter, @Param("uid_assigned") long uid_assigned){
        msnRepository.insertMsn(msn_name,   msn_desc,  uid_msn_starter,  uid_assigned);
        return "插入成功";
    }
}
