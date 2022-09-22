package com.maxtattoo.utils.logger;

//import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Component
@ConditionalOnProperty(name = "LOG_LEVEL", havingValue="INFO")
public class LogRequestResponseAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //private final TargetLengthBasedClassNameAbbreviator abbreviator = new TargetLengthBasedClassNameAbbreviator(60);

    @PostConstruct
    void init(){
        logger.info("LogRequestResponse Activated");
    }

    @Pointcut
    void withLoggableRequestResponse() {
        //pointcut
    }

    @Around("withLoggableRequestResponse()")
    public Object withLoggable(ProceedingJoinPoint pjp) throws Throwable {
        return this.proceed(pjp, Type.DEFAULT);
    }

    @Pointcut("within(com.maxtattoo.controller..*)")
    void inControllerLayer(){
        //pointcut
    }

    @Around("inControllerLayer()")
    public Object inControllerLayer(ProceedingJoinPoint pjp) throws Throwable {
        return  this.proceed(pjp, Type.CONTROLLER);
    }

    @Pointcut("within(com.maxtattoo.command..*)")
    void inCommandLayer(){
        //pointcut
    }

    @Around("inCommandLayer()")
    public Object inCommandLayer(ProceedingJoinPoint pjp) throws Throwable {
        return this.proceed(pjp, Type.COMMAND);
    }

    @Pointcut("within(com.maxtattoo.service..*) || within(com.maxtattoo.factory..*)")
    void inServiceLayer(){
        //pointcut
    }

    @Around("inServiceLayer()")
    public Object inServiceLayer(ProceedingJoinPoint pjp) throws Throwable {
        return this.proceed(pjp, Type.SERVICE);
    }

    private Object proceed(ProceedingJoinPoint pjp, Type type) throws Throwable {
        long startTime = System.currentTimeMillis();
        Signature signature = pjp.getSignature();
        final String signatureName = signature.getName();
        //String s1 = signature.getDeclaringType().getName() + "." +signatureName;
        //String caller = abbreviator.abbreviate(s1);

        Object[] args = pjp.getArgs();
        final String s = this.getStringFromType(type);
        final String caller = "caller";
        try {
            logger.info("Start {} {} [{}] with request: {}.", s, signatureName, caller, args);
            Object retVal = pjp.proceed();

            boolean isByteArray = retVal instanceof byte[];
            logger.info("Stop {} {} [{}] in {} ms with response: {}.", s, signatureName, caller, System.currentTimeMillis()-startTime, !isByteArray ? retVal: "byte[] skipped");

            return retVal;
        }catch(Exception throwable){
            logger.error("Stop {} {} [{}] in {} ms with error.", s, signatureName, caller, System.currentTimeMillis()-startTime);
            throw throwable;
        }
    }

    private enum Type{
        DEFAULT,
        CONTROLLER,
        COMMAND,
        SERVICE,
    }

    private String getStringFromType(Type type){
        final String s;
        switch(type){
            case CONTROLLER:
                s = "controller";
                break;
            case COMMAND:
                s = "command";
                break;
            case SERVICE:
                s= "service";
                break;
            default:
                s ="";
                break;
        }
        return s;
    }
}
