package otpmaeven.otpM;


    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

    @Component
    public class interceptor extends WebMvcConfigurerAdapter {
        @Autowired
        ComponentInterceptor productServiceInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(productServiceInterceptor).excludePathPatterns("/phone","/check");;
        }
    }


