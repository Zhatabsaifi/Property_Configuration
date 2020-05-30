package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties" , "classpath:jms.properties"})

@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath: jms.properties")
})
public class PropertyConfig {
    @Autowired
    Environment env;

    @Value("${saifi.username}")   // spring expression language
    String username;

    @Value("${saifi.password}")
    String password;

    @Value("${saifi.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUsername(env.getProperty("USERNAME"));
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(url);
        return fakeDataSource;
    }

    // --------------- multiple properties file-----------
        @Value("${jms.username}")
        String user;

        @Value("${jms.pass}")
        String pass;

        @Value("${jms.url}")
        String urll;

        @Bean
       public FakeJmsConfig fakeJmsConfig(){
           FakeJmsConfig fakeJmsConfig = new FakeJmsConfig();
           fakeJmsConfig.setUsername(user);
           fakeJmsConfig.setPassword(pass);
           fakeJmsConfig.setUrl(urll);
           return fakeJmsConfig;
       }

    //----------------------------------------------------

}
