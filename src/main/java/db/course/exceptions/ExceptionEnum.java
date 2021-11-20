package db.course.exceptions;

public enum ExceptionEnum {
    caseNotStarted ("case is not started yet"),
    lessThanOneCriminal("in case must be found at least 1 criminal"),
    caseFinished("case has already been finished"),
    caseFinishedSecond("case has been finished"),
    foreignKey("нарушает ограничение внешнего ключа"),
    performerCriminal("performer mustn’t be a criminal"),
    casePerformer("there should be not more then 2 performers"),
    caseNotFinished("case has not been finished yet"),
    criminalPunishment("each criminal must have a punishment");

    private final String response;
    ExceptionEnum(String response) {
        this.response = response;
    }
    public String getResponse(){ return response;}
}
