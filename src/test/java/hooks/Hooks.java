package hooks;

import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.setSpec;

public class Hooks {

    @Before("@api")//import io.cucumber.java.Before;
    public void beforeApi(){
        setSpec();
    }


}
