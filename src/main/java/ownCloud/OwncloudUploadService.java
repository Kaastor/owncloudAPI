package ownCloud;

import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount;
import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount.DefaultOwncloudAccountFactory;
import com.anrisoftware.simplerest.owncloud.OwncloudUploadFile;
import com.anrisoftware.simplerest.owncloudocs.OwncloudOcsUploadFile.OwncloudOcsUploadFileFactory;
import lombok.SneakyThrows;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URI;

/**
 * Created by Przemek on 2016-07-19.
 */
@Component
class OwncloudUploadService {

    private DefaultOwncloudAccountFactory accountFactory;
    private OwncloudOcsUploadFileFactory uploadFileFactory;

    @Autowired
    public void setOwncloudUploadService(DefaultOwncloudAccountFactory accountFactory, OwncloudOcsUploadFileFactory uploadFileFactory){
        this.accountFactory =  accountFactory;
        this.uploadFileFactory =  uploadFileFactory;
    }

    @SneakyThrows
    public void uploadFile(String user, String password, URI baseUri, File file, String remotePath){
        DefaultOwncloudAccount account = accountFactory.create(user, password, baseUri);
        OwncloudUploadFile upload = uploadFileFactory.create(account, file,
                remotePath, ContentType.create("text/plain", "UTF-8"));
        upload.call();
    }
}
