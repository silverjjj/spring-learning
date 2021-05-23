## H2 데이터베이스

서버 켜기

`C:\Program Files (x86)\H2\bin`위치에 있음

`h2.bat` 명령어를 통해 서버 on



## AOP (Aspect Oriented Programming)

AOP를 이해하기 위해선 언제 사용하는지를 정확하게 파악해야한다.

기능별 시간 측정을 필요로 할때 사용



```java
package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  // bean에 등록하기 위함
@Aspect
public class TimeTraceAop {

    // hello.hellospring : 해당 경로에 있는 모든 기능을 포함한다
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();


        try {
            // 해당 기능으로 return하여 넘어감
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
```



