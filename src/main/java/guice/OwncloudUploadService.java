package guice;

import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount;
import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount.DefaultOwncloudAccountFactory;
import com.anrisoftware.simplerest.owncloud.OwncloudUploadFile;
import com.anrisoftware.simplerest.owncloudocs.OwncloudOcsUploadFile.OwncloudOcsUploadFileFactory;
import lombok.SneakyThrows;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.net.URL;

/**
 * Created by Przemek on 2016-07-19.
 */
@Controller
class OwncloudUploadService {

    private DefaultOwncloudAccountFactory accountFactory;
    private OwncloudOcsUploadFileFactory uploadFileFactory;

    @Autowired
    public void setOwncloudUploadService(DefaultOwncloudAccountFactory accountFactory, OwncloudOcsUploadFileFactory uploadFileFactory){
        this.accountFactory =  accountFactory;
        this.uploadFileFactory =  uploadFileFactory;
    }

    @SneakyThrows
    public void requestStatus(){
        DefaultOwncloudAccount account = accountFactory.create("przemys", "przemys", new URL("http://192.168.179.131/owncloud").toURI());
        OwncloudUploadFile upload = uploadFileFactory.create(account, new File("C:\\Users\\Przemek\\Desktop\\sunny-forest.jpg"),
                "Photos/sunny-forest.jpg", ContentType.create("text/plain", "UTF-8"));
        upload.call();
    }
}
