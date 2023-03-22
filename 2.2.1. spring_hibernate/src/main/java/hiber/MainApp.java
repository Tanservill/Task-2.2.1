package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car = new Car("Lada",643);
      user1.setUserCar(car);
      userService.add(user1);
      System.out.println(userService.getUser("Lada",643));

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Lama",633);
      user2.setUserCar(car2);
      userService.add(user2);
      System.out.println(userService.getUser("Lava",633));

      context.close();
   }
}
