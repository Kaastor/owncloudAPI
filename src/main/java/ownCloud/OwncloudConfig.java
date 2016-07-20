package ownCloud;

import com.anrisoftware.simplerest.owncloud.RestOwncloudModule;
import com.anrisoftware.simplerest.owncloudocs.RestOwncloudOcsModule;
import ownCloud.annotation.EnableGuiceModules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Przemek on 2016-07-19.
 *
 */
@EnableGuiceModules
@Configuration
class OwncloudConfig {

    @Bean
    public RestOwncloudOcsModule restOwncloudOcsModule() {
        return new RestOwncloudOcsModule();
    }

    @Bean
    public RestOwncloudModule restOwncloudModule() {
        return new RestOwncloudModule();
    }
}
