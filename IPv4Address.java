import java.util.regex.Pattern;

/**
 * Represents an IPv4 address and provides methods to validate different types of IPv4 addresses.
 */
public class IPv4Address {
    /**
     * Regular expression pattern for validating a global IPv4 address.
     */
    private static final Pattern IP_PATTERN = Pattern.compile("^(?!127\\.0\\.0\\.1)(([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])$");
    /**
     * Regular expression pattern for validating a local IPv4 address.
     */
    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("192\\.168\\.([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])\\.([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])$");
    /**
     * Constant representing a local IP address.
     */
    public static final int LOCAL_IP = 1;

    /**
     * Constant representing a global IP address.
     */
    public static final int GLOBAL_IP = 0;
    private String addr;
    private int addrType;

    /**
     * Constructs an IPv4Address object with the given address and address type.
     *
     * @param addr     The IPv4 address as a String.
     * @param addrType The type of the address: LOCAL_IP or GLOBAL_IP.
     * @throws IllegalArgumentException If the provided address is invalid.
     */
    public IPv4Address(String addr,int addrType) {
        if(addrType==0)
        if (!IP_PATTERN.matcher(addr).matches()) {
            throw new IllegalArgumentException("Invalid IPv4 address");
        }
        else if(addrType==1){
            if (!LOCAL_IP_PATTERN.matcher(addr).matches()) {
                throw new IllegalArgumentException("Invalid IPv4 address");
            }
        }
        this.addrType = addrType;
        this.addr = addr;
    }

    /**
     * Default constructor initializing the IPv4Address object with null address and
     * undefined address type.
     */
    public IPv4Address(){
        this.addr=null;
        this.addrType=-1;
    }


    /**
     * Gets the IPv4 address.
     *
     * @return The IPv4 address as a String.
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Gets the type of the IPv4 address.
     *
     * @return The address type: LOCAL_IP or GLOBAL_IP.
     */
    public int getAddrType() {
        return addrType;
    }
}