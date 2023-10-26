import java.util.Scanner;

/**
 * This is the main class of the application.
 * It instantiates an IPv4Address object, a class that manages IPv4 addresses, including local addresses.
 */
public class MainApp {
    /**
     * The entry point of the application.
     * It prompts the user to enter an IPv4 address and its type (local or global),
     * validates the input, and displays the validated IP address along with its
     * type.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Instantiate an IPv4Address object
        IPv4Address addr=new IPv4Address();

        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        int addrType=-1;
        // Prompt the user for address type until a valid input (0 for IPv4, 1 for IPv6)
        // is provided
        while(addrType<0||addrType>1){
            try {
                System.out.println("Enter 0 for IPv4 address or 1 for IPv6 address");
                addrType = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid selection");
            }
        }
        // Prompt the user for an IPv4 address until a valid address is provided
        while(addr.getAddr()==null){
            String ip = sc.nextLine();
            try{
                // Attempt to create an IPv4Address object with the user-provided address and
                // type
                addr = new IPv4Address(ip,addrType);
            }catch (IllegalArgumentException e){
                System.out.println("Invalid IPv4 address");
            }
        }
        // Display the validated IP address and its type (local or global)
        System.out.println("Valid IP Address of type " + (addr.getAddrType() == 0 ? "Global" : "Local"));
        System.out.println(addr.getAddr());

        // Close the Scanner object to prevent resource leaks
        sc.close();
    }
}