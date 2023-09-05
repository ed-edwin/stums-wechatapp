package team.sdjzu.appler.stums.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 密码设置（从application.properties）
 */
@Component
public class passwordUtil {
    private static int minLength;
    @Value("${password.length.min}")
    public void setMinLength(int minLength){
        passwordUtil.minLength = minLength;
    }
    private static int maxLength;
    @Value("${password.length.max}")
    public void setMaxLength(int maxLength){
        passwordUtil.maxLength = maxLength;
    }

    /**
     * 密码长度限制
     * @param password 密码
     */
    public boolean isPasswordLengthValid(String password) {
        int length = password.length();
        return length >= minLength && length <= maxLength;
    }

    /**
     * 密码长度限制
     * @param password 密码
     */
    public boolean isPasswordValid(String password) {
        // 使用正则表达式检查密码是否只包含字母、数字和一些特定的符号
        // 此示例只允许字母、数字、下划线和连字符（-）
        String regex = "^[a-zA-Z0-9_-]+$";
        return password.matches(regex);
    }


}
