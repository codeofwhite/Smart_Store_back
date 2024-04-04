package canglangpoxiao.smart_store_back.controller;

import canglangpoxiao.smart_store_back.entity.StgInfo;
import canglangpoxiao.smart_store_back.repository.StgRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StgController {
    @Autowired
    private StgRepository stgRepository;

    @RequestMapping(value = "/findAllStg", method = RequestMethod.POST)
    @ResponseBody
    public List<StgInfo> findAllStg(@RequestParam long uid){
        List<StgInfo> list = stgRepository.findAllStg(uid);
        return list;
    }
}
