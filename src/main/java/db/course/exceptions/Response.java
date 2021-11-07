package db.course.exceptions;


public class Response {
    private final String caseNotStarted = "case is not started yet";
    private final String lessThanOneCriminal = "in case must be found at least 1 criminal";
    private final String caseFinished = "case has already been finished";

    private String message;

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    //TODO
    public void setMessage(String message) {
        if (message.contains(caseNotStarted)){
            this.message = caseNotStarted;
        }
        else if (message.contains(lessThanOneCriminal)){
            this.message = lessThanOneCriminal;
        }
        else if (message.contains(caseFinished)){
            this.message = caseFinished;
        }
        else this.message = message;
    }
}