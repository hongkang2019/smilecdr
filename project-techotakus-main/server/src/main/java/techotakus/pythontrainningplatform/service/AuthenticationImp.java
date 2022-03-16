package techotakus.pythontrainningplatform.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techotakus.pythontrainningplatform.JavaBean.User;
import techotakus.pythontrainningplatform.dao.TokenDao;
import techotakus.pythontrainningplatform.dao.UserDao;
import techotakus.pythontrainningplatform.utils.Crypter;

import java.util.Date;
import java.util.List;

@Service("authenticationImp")
public class AuthenticationImp implements Authentication{
    @Autowired
    UserDao userDao;
    @Autowired
    TokenDao tokenDao;
    @Autowired
    Crypter crypter;
    public Integer Signup(String user_name, String user_password){
        String password = crypter.Encrypt(user_password);
        return userDao.insertUser(user_name, password);
    }
    public String Signin(String user_name, String user_password){
        List<User> users= userDao.selectUserbyName(user_name);
        if(!users.isEmpty()) {
            if (crypter.Decrypt(users.get(0).getUserPassword()).equals(user_password)) {
                String token = crypter.Encrypt(JWT.create().withAudience(user_name).withIssuedAt(new Date())
                        .sign(Algorithm.HMAC256(user_password)));
                tokenDao.insertToken(user_name, token);
                return token;
            }
        }
        return null;
    }
}
