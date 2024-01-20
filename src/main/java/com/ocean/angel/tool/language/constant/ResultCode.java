package com.ocean.angel.tool.language.constant;

import com.ocean.angel.tool.language.config.message.MessageSourceConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.EnumSet;
import java.util.Locale;

public enum ResultCode {

    SUCCESS(200, "SUCCESS"),
    SERVICE_INTERNAL_ERROR(500, "SERVICE_INTERNAL_ERROR"),
    PARAM_ERROR(400, "PARAM_ERROR"),
    CALL_API_FAIl(11011, "CALL_API_FAIl")
    ;

    // 响应码
    private final int code;

    // 提示信息
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Component
    public static class EnumValuesInjectionService {

        @Resource(name = MessageSourceConfiguration.MESSAGE_SOURCE)
        private MessageSource messageSource;

        @PostConstruct
        public void postConstruct() {
            for (ResultCode m : EnumSet.allOf(ResultCode.class)) {
                m.setMessageSource(messageSource);
            }
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return getMsg(null);
    }

    public String getMsg(Object... args) {
        Locale local = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msg, args, msg, local);
    }
}
