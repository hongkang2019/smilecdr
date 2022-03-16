import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IHttpRequest;
import ca.uhn.fhir.rest.client.api.IHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;

@Component
public class ClientInterceptor implements IClientInterceptor {
    public String task;
    StopWatch requestStopWatch = new StopWatch("timer");
    public ClientInterceptor(String task){
        this.task = task;
    }
    @Override
    public void interceptRequest(IHttpRequest iHttpRequest) {
        requestStopWatch.start(task);
    }

    @Override
    public void interceptResponse(IHttpResponse iHttpResponse) throws IOException {
        requestStopWatch.stop();
    }

    public double getTotalTime(){
        System.out.println("Total time cost is: " + requestStopWatch.getTotalTimeSeconds() + "s");
        System.out.println("Average time cost is: " + requestStopWatch.getTotalTimeSeconds()/20.0 + "s");
        return requestStopWatch.getTotalTimeSeconds()/20.0;
        //System.out.println(requestStopWatch.prettyPrint());
    }
}
