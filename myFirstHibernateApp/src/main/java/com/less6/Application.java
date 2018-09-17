package com.less6;

import com.less6.config.AppConfig;
import com.less6.config.HibernateConfig;
import com.less6.models.User;
import com.less6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class Application {

    @Autowired
    UserService userService;

    public static void main(String args[]) throws SQLException {
//создаем контекст для взаимодействия , т.к. main не может общаться с методами run

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Application app = ctx.getBean(Application.class);
        app.run();
    }

    public void run() {

        User user1 = new User("Marina");
        userService.save(user1);
  }
}
