package jsontest.Config;

import jsontest.service.JwtTokenUtil;
import jsontest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component

    public class MyInterceptor implements HandlerInterceptor {

      @Autowired
      JwtTokenUtil jwttokenUtil;
      @Autowired
      Userservice userservice;
      //Daoservice daoservice;
      //Usercheckdatarepo check;
    @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception
    {
            String token = null;
            Enumeration<String> headerNames = request.getHeaderNames();
            System.out.println(headerNames);
            while(headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();

                System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
                if(headerName.equals("token")){
                    token=request.getHeader(headerName);
                   // System.out.println("Subject to ye hai"+subject);

                    String subject=jwttokenUtil.getUsernameFromToken(token);
                    System.out.println("Subject to ye hai"+subject);

                    int i= userservice.usercheckcount(subject);
                    int j=userservice.countusername(subject);
                    //int j=userservice.
                    System.out.println("Value of IIIIIIIi"+i);
                    if(i>0||j>0)
                    {
                        return true;
                    }

                }
            }

            return false;
        }
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response,
                               Object handler, ModelAndView modelAndView) throws Exception {

            System.out.println("Post Handle method is Calling");
        }
        @Override
        public void afterCompletion
                (HttpServletRequest request, HttpServletResponse response, Object
                        handler, Exception exception) throws Exception {

            System.out.println("Request and Response is completed");
        }
    }

