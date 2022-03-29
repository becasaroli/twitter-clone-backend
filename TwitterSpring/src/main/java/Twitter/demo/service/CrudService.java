package Twitter.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import Twitter.demo.Repository.PagesRepository;
import Twitter.demo.Repository.UsersRepository;
import Twitter.demo.orm.Pages;
import Twitter.demo.orm.Users;

@Service
public class CrudService {
    
    private Boolean system = true;
    private final UsersRepository uRepository;
    private final PagesRepository pRepository;
		
	public CrudService(UsersRepository uRepository, PagesRepository pRepository){
		this.uRepository = uRepository;
        this.pRepository = pRepository;
        
	}

    public void initial(Scanner scanner) throws ParseException{
        while(system == true){
            System.out.println();
            System.out.println("Which action you want to execute?");
            System.out.println("0 - Exit");
            System.out.println("1 - Create account");
            System.out.println("2 - Update");
            System.out.println("3 - View users");
            System.out.println("4 - Delete user");

            int action = scanner.nextInt();
            switch (action){
            case 1:
                save(scanner);
                break;
            case 2:
                updateUsername(scanner);
                break;
            case 3:
                view();
                break;
            case 4:
                delete(scanner);
                break;
            default:
                system = false;
                break;
            }
        }
        save(scanner);

    }
    private void save(Scanner scanner) throws ParseException{
        
        //Collecting data to new User
        System.out.println("------Register Screen------");
        System.out.println("Username:");
        String username = scanner.next();
        System.out.println("Full Name:");
        String name = scanner.next();
        System.out.println("E-mail:");
        String email = scanner.next();
        System.out.println("Birthday date: dd/mm/yyyy");
        String dateReceived = scanner.next();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dateFormatada = formato.parse(dateReceived);
        
        //User creation
        Users user = new Users(username, email, name, dateFormatada);

        //Twitter address created and linked to user account
        Pages page = new Pages(username);
        
        //User and page saved in Postgres
        uRepository.save(user);
        pRepository.save(page);
        System.out.println("New user registered!");

    }
    private void updateUsername(Scanner scanner){
        System.out.println("Insira ID do usuário");
        int id = scanner.nextInt();
        System.out.println("Novo username");
        String username = scanner.next();
        
        Users user = new Users();
        user.setId(id);
        user.setUsername(username);
        uRepository.save(user);
    }
    private void view(){
        Iterable<Users> users = uRepository.findAll();
        users.forEach(user -> System.out.println(user));
    }
    private void delete(Scanner scanner){
        System.out.println("Select user ID");
        int id = scanner.nextInt();
        uRepository.deleteById(id);
        pRepository.deleteById(id);
        System.out.println("User deleted!");
    }
}
