package techotakus.pythontrainningplatform.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crypter {
    @Autowired
    StringEncryptor encryptor;
    public String Encrypt(String str){
        return encryptor.encrypt(str);
    }

    public String Decrypt(String str){
        return encryptor.decrypt(str);
    }
}
