package com.demo.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Locale;

/**
 * @author - Jianghj
 * @since - 2019-11-27 13:32
 * 自定义国际化消息解析器，根据请求传递的参数，来返回相应的语言环境
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * @param request
     * @return
     * @author - Jhjing
     * @since - 2019.11.27 027
     * 从请求中获取对应的参数，返回国际化解析器
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale localResolver = null;
        String localeParam = request.getParameter("locale");

        if (!StringUtils.hasText(localeParam)) {
            // 如果请求中没有参数，则从请求头中获取（根据浏览器来选择语言环境）
            Enumeration<Locale> requestLocales = request.getLocales();
            if (requestLocales.hasMoreElements()) {
                localResolver = requestLocales.nextElement();
                return localResolver;
            }
        }

        // 对参数进行分隔，“zh_CN” →{zh,CN}
        String[] params = localeParam.split("_");
        if (params.length == 2) {
            localResolver = new Locale(params[0], params[1]);
        }

        if (localResolver == null) {
            localResolver = Locale.getDefault();
        }
        return localResolver;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
