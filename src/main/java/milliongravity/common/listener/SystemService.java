package milliongravity.common.listener;

import milliongravity.common.config.Global;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by guozheng on 2016/5/5.
 */
@Service
@Transactional(readOnly = true)
public class SystemService  implements InitializingBean {
    /**
     * 获取Key加载信息
     */
    public static boolean printKeyLoadMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用 "+ Global.getConfig("productName")+"  "+Global.getConfig("version")+"  - Powered By guozheng  \r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        return true;
    }

    public void afterPropertiesSet() throws Exception {

    }
}