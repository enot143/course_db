package db.course.exceptions;


public class Response {

    private String message;

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        boolean f = false;
        for (ExceptionEnum value : ExceptionEnum.values()) {
            if (message.contains(value.getResponse())){
                this.message = value.getResponse();
                f = true;
            }
        }
        if (!f) this.message = message;
    }
}