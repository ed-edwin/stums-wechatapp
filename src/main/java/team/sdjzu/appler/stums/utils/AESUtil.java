package team.sdjzu.appler.stums.utils;

import cn.dev33.satoken.secure.SaSecureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * AES加密解密工具
 */

@Component
public class AESUtil {
    /**
     * 获取秘钥，在application.properties中aes.key中更改
     */
    private static String key;
    @Value("${aes.key}")
    public void setKey(String key){
        AESUtil.key = key;
    }

    /**
     * 加密
     * @param text 明文
     * @return 密文
     */
    public String AESEncryption(String text){
        return SaSecureUtil.aesEncrypt(key, text);
    }

    /**
     * 解密
     * @param ciphertext 密文
     * @return 明文
     */
    public String AESDecryption(String ciphertext){
        return  SaSecureUtil.aesDecrypt(key, ciphertext);
    }

}
