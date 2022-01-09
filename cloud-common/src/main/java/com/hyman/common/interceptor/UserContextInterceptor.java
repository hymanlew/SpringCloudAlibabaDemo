package com.hyman.common.interceptor;

/**
 * description: UserContextInterceptor <br>
 * date: 2020/7/6 11:31 <br>
 * author: hyman <br>
 */
//@Component
//public class UserContextInterceptor extends HandlerInterceptorAdapter {
//    private Logger logger = LoggerFactory.getLogger(UserContextInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader(TOKEN_HEADER);
//        if (StringUtils.isEmpty(token)) {
//            if (request.getCookies() != null) {
//                for (Cookie cookie : request.getCookies()) {
//                    if (cookie.getName().equals(TOKEN_HEADER)) {
//                        token = cookie.getValue();
//                    }
//                }
//            }
//        }
//        //解析token
//        if(StringUtils.isNotEmpty(token)){
//            Claims claims = JWTHelper.getInfoFromToken(token);
//            BaseContextHandler.setUsername((String)claims.get(CommonConstants.JWT_KEY_USERNAME));
////            BaseContextHandler.setName((String)claims.get(CommonConstants.JWT_KEY_USERNAME));
//            BaseContextHandler.setUserID((int)claims.get(CommonConstants.JWT_KEY_USER_ID));
//        }
//        return super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        BaseContextHandler.remove();
//        super.afterCompletion(request, response, handler, ex);
//    }
//}
