package android.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {

    private static final Logger LOG = LogManager.getLogger(Message.class);
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    private String receiver;
    private String subject;
    private String text;

    private Message () {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public Message(String receiver, String subject, String text) throws Exception {
        this();
        if (validate(receiver)) {
            this.receiver = receiver;
            this.subject = subject;
            this.text = text;
        }
    }

    public Message(String receiver) throws Exception {
        this();
        if (validate(receiver)) {
            this.receiver = receiver;
        }
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) throws Exception {
        if (validate(receiver))
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean validate(final String hex) throws Exception {
        matcher = pattern.matcher(hex);
        if (matcher.matches()) {
            return true;
        } else {
            LOG.warn("Not valid receiver Email address");
            throw new Exception("Not valid receiver Email address");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(receiver, message.receiver) &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiver, subject, text);
    }
}
