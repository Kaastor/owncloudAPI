package ownCloud;

import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount;
import com.anrisoftware.simplerest.owncloud.DefaultOwncloudAccount.DefaultOwncloudAccountFactory;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Przemek on 2016-07-20.
 *
 */
@Component
class OwncloudDownloadService {

    private DefaultOwncloudAccountFactory accountFactory;
    private DefaultOwncloudAccount account;

    @Autowired
    public void setOwncloudUploadService(DefaultOwncloudAccountFactory accountFactory){
        this.accountFactory =  accountFactory;
    }

    @SneakyThrows
    public void downloadFile(String user, String password, URI baseUri, String remotePath, String fileDestinationPath) {

        account = accountFactory.create(user, password, baseUri);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(getRequestURI(remotePath));
        HttpResponse response = httpClient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            FileOutputStream fos = new FileOutputStream(new File(fileDestinationPath));
            int inByte;
            while((inByte = is.read()) != -1)
                fos.write(inByte);
            is.close();
            fos.close();
        }
    }

    private URI getRequestURI(String remotePath) throws URISyntaxException {
        String extraPath = account.getBaseUri().getPath();
        URIBuilder builder = new URIBuilder(account.getBaseUri());
        builder.setUserInfo(account.getUser(), account.getPassword());
        String statusPath = String.format("%s%s%s", extraPath, "/remote.php/webdav/", remotePath);
        builder.setPath(statusPath);
        return builder.build();
    }
}
