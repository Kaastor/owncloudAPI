package guice;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Przemek on 2016-07-19.
 */
@SpringBootApplication
@ComponentScan("guice")
class App {

    @SneakyThrows
    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        OwncloudUploadService owncloudUploadService = (OwncloudUploadService) ctx.getBean("owncloudUploadService");
        owncloudUploadService.requestStatus();
    }

}
