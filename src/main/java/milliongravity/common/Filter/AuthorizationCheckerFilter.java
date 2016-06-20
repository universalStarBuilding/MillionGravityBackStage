package milliongravity.common.Filter;

import milliongravity.common.persistence.annotation.TokenCheck;
import org.glassfish.jersey.server.model.AnnotatedMethod;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public class AuthorizationCheckerFilter implements DynamicFeature
{
    private static  List<String> tokenCkList;
    //单利模式 线程安全保证唯一性
    public synchronized  static List<String> gettokenCkListInstance() {
        if (tokenCkList == null) {
            tokenCkList =  new ArrayList<String>();
        }
        return tokenCkList;
    }
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        AnnotatedMethod am = new AnnotatedMethod(resourceInfo.getResourceMethod());

        if(am.isAnnotationPresent(TokenCheck.class))
        {
            System.out.println("############访问的方法是:"+am.getMethod());
            Path methodPath = (Path)resourceInfo.getResourceMethod().getAnnotation(Path.class);
            Path classPath = (Path)resourceInfo.getResourceClass().getAnnotation(Path.class);
            String pathText=classPath.value()+"/"+methodPath.value();
            pathText=pathText.indexOf("//")==-1?pathText:pathText.replaceAll("//","/");
            System.out.println("###################访问的url是："+pathText);
            tokenCkList= gettokenCkListInstance();
            tokenCkList.add(pathText);
            context.register(new AuthorizationRequestFilter(tokenCkList));
        }

    }
}
