import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.AdditionalRequestHeadersInterceptor;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestClientInterceptor {

    /*
    *  According to README.md, check the third loop and the first loop takes more time than the second one
    * */
    @Test
    public void testInterceptRequestAndResponse(){
        double[] time = new double[3];
        FhirContext fhirContext = FhirContext.forR4();
        IGenericClient client = fhirContext.newRestfulGenericClient("http://hapi.fhir.org/baseR4");
        client.registerInterceptor(new LoggingInterceptor(false));
        try{
            File f = new File("src/main/resources/names.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String[] lastnames = br.readLine().split(" ");
            ArrayList<Bundle> results = new ArrayList<Bundle>();
            AdditionalRequestHeadersInterceptor headerInterceptor = new AdditionalRequestHeadersInterceptor();
            headerInterceptor.addHeaderValue("Cache-Control", "private, no-store, no-cache, must-revalidate");
            for(int k = 0; k < 3; k++) {
                ClientInterceptor clientInterceptor = new ClientInterceptor("task" + k);
                client.registerInterceptor(clientInterceptor);
                if(k == 2)
                    client.registerInterceptor(headerInterceptor);
                for (String lastname : lastnames) {
                    results.add(client.search()
                            .forResource("Patient")
                            .where(Patient.FAMILY.matches().value(lastname))
                            .returnBundle(Bundle.class)
                            .execute());
                }
                time[k] = clientInterceptor.getTotalTime();
            }
        }catch(Exception e){
            System.out.println(e);
        }
        assertTrue(time[0] > time[1] && time[2] > time[1]);
    }
}
