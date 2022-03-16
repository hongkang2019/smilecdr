package techotakus.pythontrainningplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import techotakus.pythontrainningplatform.JavaBean.User;
import techotakus.pythontrainningplatform.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public int insertUser(String username, String password){
        List<User> users = selectUserbyName(username);
        if(users.isEmpty()){
            User user = new User();
            user.setId(null);
            user.setUserName(username);
            user.setUserPassword(password);
            int result = userMapper.insert(user);
            return result;
        }
        return 0;
    }

    public List<User> selectUserbyName(String username){
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", username);
        List<User> users = userMapper.selectByMap(map);
        return users;
    }
}
