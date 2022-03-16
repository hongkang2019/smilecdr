package techotakus.pythontrainningplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import techotakus.pythontrainningplatform.JavaBean.Token;
import techotakus.pythontrainningplatform.JavaBean.User;
import techotakus.pythontrainningplatform.mapper.TokenMapper;
import techotakus.pythontrainningplatform.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TokenDao {
    @Autowired
    private TokenMapper tokenMapper;

    public int insertToken(String username, String token){
        List<Token> tokens = findTokenbyUsername(username);
        if(!tokens.isEmpty()){
            Token new_token = tokens.get(0);
            new_token.setToken(token);
            return tokenMapper.updateById(new_token);
        }
        Token temp = new Token();
        temp.setUserName(username);
        temp.setToken(token);
        temp.setId(null);
        int result = tokenMapper.insert(temp);
        return result;
    }

    public List<Token> findToken(String token){
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        List<Token> res = tokenMapper.selectByMap(map);
        return res;
    }

    public List<Token> findTokenbyUsername(String username){
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", username);
        List<Token> res = tokenMapper.selectByMap(map);
        return res;
    }
}
