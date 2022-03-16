package techotakus.pythontrainningplatform.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import techotakus.pythontrainningplatform.service.RunPython;

@Component
public class RunPythonResolver implements GraphQLQueryResolver {
    @Autowired
    @Qualifier("runPythonImp")
    private RunPython runPython;
    public String RunPythonCode(String code){
        return runPython.Run(code);
    }
}
