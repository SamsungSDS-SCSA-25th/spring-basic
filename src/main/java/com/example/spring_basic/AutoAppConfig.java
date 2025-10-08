package com.example.spring_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // ComponentScan의 범위 => default: package com.example.spring_basic;
        // 따라서, 프로젝트 최상단에 config를 두는 것을 권장함
        basePackages = "com.example.spring_basic",
        // AppConfig는 제외 (AutoAppConfig와 충돌하기 때문)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 따로 코드 없음
    // @Component, @Autowired 가 각 파일에 흝어져 있음
}
