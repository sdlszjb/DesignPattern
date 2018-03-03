package kisslinux.flyweight.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:44
 */
public class FlyweightSignInfo {

    private String id;
    private String location;
    private String subject;
    private String postAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}
