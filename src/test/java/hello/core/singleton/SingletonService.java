package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //하나 생성

    public static SingletonService getInstance() { //여기서만 객체 호출
        return instance;
    }

    private SingletonService() { //생성자를 private으로 -> new로 객체 생성하는 것을 막음

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void sigletonServiceTest() {
        new SingletonService();
    }
}
