import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.AdditionalRequestHeadersInterceptor;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class SampleClient {

    public static void main(String[] theArgs) {

        // Create a FHIR client
        FhirContext fhirContext = FhirContext.forR4();
        IGenericClient client = fhirContext.newRestfulGenericClient("http://hapi.fhir.org/baseR4");
        client.registerInterceptor(new LoggingInterceptor(false));

        // Search for Patient resources
        Bundle response = client
                .search()
                .forResource("Patient")
                .where(Patient.FAMILY.matches().value("SMITH"))
                .returnBundle(Bundle.class)
                .execute();

        // print the given name, family name and birth date of Smiths, birth date is printed as null if there is no such
        // data
        response.getEntry().stream().map(pat->
                pat.getResource().getNamedProperty("name").getValues().get(0)
                        .getNamedProperty("given").getValues().get(0).toString()
                        .replace("\",\"", " ")
                        + " "
                        + pat.getResource().getNamedProperty("name").getValues().get(0)
                        .getNamedProperty("family").getValues().get(0).toString()
                        + " "
                        + pat.getResource().getNamedProperty("birthDate").getValues().stream().findAny()
                        .map(date-> date.toString().substring(9, 19))
                        .orElse(null)
        ).sorted().forEach(System.out::println);

        // read all the lastnames from name.txt and fetch data for each of them
        try{
            File f = new File("src/main/resources/names.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String[] lastnames = br.readLine().split(" ");
            ArrayList<Bundle> results = new ArrayList<Bundle>();
            //  add the no cache header
            AdditionalRequestHeadersInterceptor headerInterceptor = new AdditionalRequestHeadersInterceptor();
            headerInterceptor.addHeaderValue("Cache-Control", "private, no-store, no-cache, must-revalidate");
            for(int k = 0; k < 3; k++) {
                ClientInterceptor clientInterceptor = new ClientInterceptor("task" + k);
                client.registerInterceptor(clientInterceptor);
                // register the no-cache header before the 3rd loop
                if(k == 2)
                    client.registerInterceptor(headerInterceptor);
                for (String lastname : lastnames) {
                    results.add(client.search()
                            .forResource("Patient")
                            .where(Patient.FAMILY.matches().value(lastname))
                            .returnBundle(Bundle.class)
                            .execute());
                }
                clientInterceptor.getTotalTime();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

/*
Here is a sample result:
   Loop 1:  Total time cost is: 12.9265155s
            Average time cost is 0.646325775s
   Loop 2:  Total time cost is: 6.7451727s
            Average time cost is 0.33725863500000003s
   Loop 3:  Total time cost is: 13.9204933s
            Average time cost is 0.696024665s
*/
