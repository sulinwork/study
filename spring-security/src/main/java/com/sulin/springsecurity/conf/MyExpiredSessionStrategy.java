package com.sulin.springsecurity.conf;

import com.sulin.springsecurity.utils.Api;
import com.sulin.springsecurity.utils.ResJsonUtil;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author sulin
 */
public class MyExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        final Api message = Api.builder().code(400).message("你的账号在其他的地方登录，被迫下线").build();
        ResJsonUtil.write(event.getResponse(), message);
    }
}
