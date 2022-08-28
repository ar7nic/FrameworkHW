package google.cloud.model;

import java.util.Objects;

public class EmailService {

    private String freeMailService;
    private String emailAddress;



    public String getFreeMailService() {
        return freeMailService;
    }

    public void setFreeMailService(String freeMailService) {
        this.freeMailService = freeMailService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Freemail{" +
                "MailService='" + freeMailService + '\'' +
                ", EMail='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFreeMailService(), getEmailAddress());
    }

    public EmailService(String freeMailService, String emailAddress) {
        this.freeMailService = freeMailService;
        this.emailAddress = emailAddress;
    }

    public EmailService(String freeMailService) {
        this.freeMailService = freeMailService;
        this.emailAddress = null;
    }

}
