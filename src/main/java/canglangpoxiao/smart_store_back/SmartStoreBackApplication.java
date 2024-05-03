package canglangpoxiao.smart_store_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("canglangpoxiao.smart_store_back.mapper")
@EnableCaching  //开启缓存
public class SmartStoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStoreBackApplication.class, args);
    }

}
