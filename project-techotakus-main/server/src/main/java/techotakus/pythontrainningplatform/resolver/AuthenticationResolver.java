package techotakus.pythontrainningplatform.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import techotakus.pythontrainningplatform.service.Authentication;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationResolver implements GraphQLQueryResolver {
    @Autowired
    @Qualifier("authenticationImp")
    private Authentication authentication;
    public Integer Signup(String user_name, String user_password){
        return authentication.Signup(user_name, user_password);
    }
    public String Signin(String user_name, String user_password){
        return authentication.Signin(user_name, user_password);
    }
}
