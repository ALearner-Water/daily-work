public class AgeOutofboundExcption extends RuntimeException{
    //继承runtimeexception是运行时异常,继承exception是编译时异常

    public AgeOutofboundExcption(String message) {
        super(message);
    }

    public AgeOutofboundExcption() {
    }
}
