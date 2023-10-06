import com.hai.entity.Item;
import com.hai.entity.User;
import com.hai.service.SecKillItemService;
import com.hai.service.UserService;
import com.hai.service.impl.SecKillItemServiceImpl;
import com.hai.util.SecKillURL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-redis.xml"})
public class Test1 {


    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    UserService userServices;

    @Autowired
    SecKillItemService itemService;

    @Test
    public void test1(){
        System.out.println(redisTemplate);
        System.out.println(userServices);
        System.out.println(userServices.getUser(1));

    }

    @Test
    public void test2(){
        User user = new User();
        user.setPhone("19990516729");
        user.setPassword("2023000520hu");
        userServices.register(user);
    }

    @Test
    public void testLogin(){
//        String result = userServices.login("17872872249","000520");
        String result = userServices.login("19990516729","2023000520hu");
        System.out.println(result);
    }

    @Test
    public void testGetItemList(){
        List<Item> itemList = itemService.selectItemList();
        System.out.println(itemList);
    }

    @Test
    public void testDate(){
        Item item = itemService.selectOneItem(1);
        long time1 = item.getStartTime().getTime();
        System.out.println(time1);
        String timeStr = new String("2023-09-30 20:00:00");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = formatter.parse(timeStr);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testGetURL(){
        SecKillURL url = itemService.getURL(1);
        System.out.println(url);
    }

}