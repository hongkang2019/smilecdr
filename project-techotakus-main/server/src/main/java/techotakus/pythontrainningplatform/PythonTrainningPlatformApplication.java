package techotakus.pythontrainningplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("techotakus.pythontrainningplatform.mapper")
public class PythonTrainningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PythonTrainningPlatformApplication.class, args);
    }

}
