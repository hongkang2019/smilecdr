package techotakus.pythontrainningplatform.JavaBean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("token")
public class Token implements java.io.Serializable{
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "token")
    private String token;
}
