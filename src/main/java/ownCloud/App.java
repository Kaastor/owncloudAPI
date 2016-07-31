package ownCloud;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;


/**
 * Created by Przemek on 2016-07-19.
 * baseUri 192.168.179.131/owncloud
   remotePath "Photos/sunny-forest.jpg"
 */
@SpringBootApplication
@ComponentScan("ownCloud")
class App {
    //master change
    //master change 2
    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        OwncloudServices owncloudServices = (OwncloudServices) ctx.getBean("owncloudServices");
        owncloudServices.uploadFile( new File("C:\\Users\\Przemek\\Desktop\\sunnyforest.jpg"), "Photos/sunny-forest.jpg");
        owncloudServices.downloadFile("Documents/Czystykod.pdf", "C:\\Users\\Przemek\\Desktop\\CzystyKod.pdf");
    }



}
