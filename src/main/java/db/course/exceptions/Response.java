package db.course.exceptions;

import java.util.Set;

public class Response {
    private final String caseNotStarted = "case is not started yet";
    private final String lessThanOneCriminal = "in case must be found at least 1 criminal";

    private String message;

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.contains(caseNotStarted)){
            this.message = caseNotStarted;
        }
        else if (message.contains(lessThanOneCriminal)){
            this.message = lessThanOneCriminal;
        }
        else this.message = "message is not available";
    }
}