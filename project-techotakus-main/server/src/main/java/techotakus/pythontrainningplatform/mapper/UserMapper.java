package techotakus.pythontrainningplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import techotakus.pythontrainningplatform.JavaBean.User;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
