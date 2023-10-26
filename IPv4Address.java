import java.util.regex.Pattern;

/**
 * IPv4Address
 */
public class IPv4Address {

    private static final Pattern IP_PATTERN = Pattern.compile("^(?!127\\.0\\.0\\.1)(([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])$");
    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("192\\.168\\.([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])\\.([0-9]|[1-9][0-9]|1([0-9]{2})|25[0-5])$");
    public static final int LOCAL_IP = 1;
    public static final int GLOBAL_IP = 0;

    private String addr;
    private int addrType;

    public int getAddrType() {
        return addrType;
    }
    public void setAddrType(int addrType) {
        this.addrType = addrType;
    }
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
    public IPv4Address(){
        this.addr=null;
        this.addrType=-1;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}