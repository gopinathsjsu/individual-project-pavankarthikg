public interface CheckHandler {
    public void setNextStep(CheckHandler nextHandler);
    public void check(); 
}
