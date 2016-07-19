package guice;

import com.anrisoftware.simplerest.owncloud.RestOwncloudModule;
import com.anrisoftware.simplerest.owncloudocs.RestOwncloudOcsModule;
import guice.annotation.EnableGuiceModules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Przemek on 2016-07-19.
 */
@EnableGuiceModules
@Configuration
class AppConfig {

    @Bean
    public RestOwncloudOcsModule restOwncloudOcsModule() {
        return new RestOwncloudOcsModule();
    }

    @Bean
    public RestOwncloudModule restOwncloudModule() {
        return new RestOwncloudModule();
    }
}
