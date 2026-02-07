package library.main.environments;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:./src/test/resources/config.properties"})
public interface EnvironmentConfig extends Config {

    @Key("${environment}.test.user.password")
    String getTestUserPassword();

    /*store1*/
    @Key("${environment}.store1.url")
    String getStore1Url();
    
    /*store2*/
    @Key("${environment}.store2.url")
    String getStore2Url();
}
