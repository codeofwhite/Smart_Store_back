package canglangpoxiao.smart_store_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("canglangpoxiao.smart_store_back.mapper")
public class SmartStoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStoreBackApplication.class, args);
    }

}
