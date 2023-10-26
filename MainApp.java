import java.util.Scanner;

/**
 * MainApp
 */
public class MainApp {
    public static void main(String[] args) {
        IPv4Address addr=new IPv4Address();

        Scanner sc = new Scanner(System.in);
        int addrType=-1;
        while(addrType<0||addrType>1){
            try {
                System.out.println("Enter 0 for IPv4 address or 1 for IPv6 address");
                addrType = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid selection");
            }
        }
        while(addr.getAddr()==null){
            String ip = sc.nextLine();
            try{
                addr = new IPv4Address(ip,addrType);
            }catch (IllegalArgumentException e){
                System.out.println("Invalid IPv4 address");
            }
        }
        System.out.println("Valid IP Address of type"+(addr.getAddrType()==0 ? "Global" : "Local"));
        System.out.println(addr.getAddr());
        sc.close();
    }
}