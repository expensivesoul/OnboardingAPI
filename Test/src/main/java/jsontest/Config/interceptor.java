package jsontest.Config;


    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
    import org.springframework.web.servlet.HandlerInterceptor;
    import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class interceptor extends WebMvcConfigurerAdapter {
    @Autowired
    MyInterceptor myInterceptor;
    //@Autowired
   // AdminInterceptor adminInterceptor;
    //dminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).excludePathPatterns("/final/phone","/final/check","/**");
      //  registry.addInterceptor(adminInterceptor).excludePathPatterns("/admin/register","/admin/authenticate").addPathPatterns("/admin/*");
    }
}


