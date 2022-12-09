package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Petr", "Petrov", "petrov.mail.ru");
      User user2 = new User("Maria", "Ivanova", "ivanova.mail.ru");
      User user3 = new User("Ivan", "Fedorov", "fedorov.mail.ru");
      User user4 = new User("Anna", "Vasina", "vasina.mail.ru");

      Car car1 = new Car("BMW", 666);
      Car car2 = new Car("Volvo", 90);
      Car car3 = new Car("Lada", 2107);
      Car car4 = new Car("Infinity", 50);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println(userService.getUserCar("BMW", 666).toString());
      System.out.println(userService.getUserCar("Infinity", 50).toString());
      System.out.println(userService.getUserCar(car3.getModel(), car3.getSeries()));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
