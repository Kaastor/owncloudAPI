import com.anrisoftware.simplerest.core.SimpleRestException;
import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount;
import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount.DefaultOwncloudAccountFactory;
import com.anrisoftware.simplerest.owncloud.OwncloudUploadFile;
import com.anrisoftware.simplerest.owncloudocs.OwncloudOcsUploadFile.OwncloudOcsUploadFileFactory;
import com.google.inject.Inject;
import org.apache.http.entity.ContentType;

import java.io.File;
import java.net.URI;

/**
 * Created by Przemek on 2016-07-19.
 */
class OwncloudUploadService {

    private final DefaultOwncloudAccountFactory accountFactory;
    private final OwncloudOcsUploadFileFactory uploadFileFactory;

    @Inject
    public OwncloudUploadService(DefaultOwncloudAccountFactory accountFactory, OwncloudOcsUploadFileFactory uploadFileFactory){
        this.accountFactory =  accountFactory;
        this.uploadFileFactory =  uploadFileFactory;
    }

    public void requestStatus(URI uri) throws SimpleRestException {
        DefaultOwncloudAccount account = accountFactory.create("przemys", "przemys", uri);
        OwncloudUploadFile upload = uploadFileFactory.create(account, new File("C:\\Users\\Przemek\\Desktop\\sunny-forest.jpg"),
                "Photos/sunny-forest.jpg", ContentType.create("text/plain", "UTF-8"));
        upload.call();

    }
}
