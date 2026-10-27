package demo.bankaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankAopApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(
                BankAopApplication.class, args);

	}
	@Bean
	CommandLineRunner run(BankService bankService) {
        return args -> {

            System.out.println("Initial Balance: "
                    + bankService.getBalance());

            bankService.deposit(1000);
            bankService.withdraw(250);

            System.out.println("Current Balance: "
                    + bankService.getBalance());

            try {
                bankService.withdraw(5000);
            } catch (IllegalArgumentException ex) {
                System.out.println("Handled error: "
                        + ex.getMessage());
            }

            System.out.println("Final Balance: "
                    + bankService.getBalance());
        };
    }

}
