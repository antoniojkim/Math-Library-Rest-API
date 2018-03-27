package MathLibrary.MathRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MathRestApiApplication {

    /*
    To See active configuration:    gcloud config list
    To See list of configurations:  gcloud config configurations list
    To Activate a configuration:    gcloud config configurations activate <config-name>

    mvn clean package
    mvn appengine:start
    mvn appengine:deploy
     */

    public static void main(String[] args) {
        SpringApplication.run(MathRestApiApplication.class, args);
    }

}
