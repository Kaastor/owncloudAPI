import com.anrisoftware.simplerest.core.SimpleRestException;
import com.anrisoftware.simplerest.owncloud.RestOwncloudModule;
import com.anrisoftware.simplerest.owncloudocs.RestOwncloudOcsModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Przemek on 2016-07-19.
 */
public class App {

    private final OwncloudUploadService uploadService;

    @Inject
    public App(OwncloudUploadService uploadService){
        this.uploadService = uploadService;
    }

    public static void main(String[] args){
        Injector guice = Guice.createInjector(new RestOwncloudOcsModule(), new RestOwncloudModule());
        App app = guice.getInstance(App.class);

        try {
            app.start();
        } catch (MalformedURLException |URISyntaxException |SimpleRestException e) {
            e.printStackTrace();
        }
    }

    public void start()
            throws java.net.MalformedURLException, java.net.URISyntaxException,
            com.anrisoftware.simplerest.core.SimpleRestException {

        URL url = new URL("http://192.168.179.131/owncloud");
        URI uri = url.toURI();

        uploadService.requestStatus(uri);
    }

}
