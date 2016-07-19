package ownCloud;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.net.URL;

/**
 * Created by Przemek on 2016-07-19.
 */
@SpringBootApplication
@ComponentScan("ownCloud")
class App {

    @SneakyThrows
    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        OwncloudUploadService owncloudUploadService = (OwncloudUploadService) ctx.getBean("owncloudUploadService");
        owncloudUploadService.uploadFile("przemys", "przemys", new URL("http://192.168.179.131/owncloud").toURI(),
                new File("C:\\Users\\Przemek\\Desktop\\sunny-forest.jpg"), "Photos/sunny-forest.jpg");
    }

}
