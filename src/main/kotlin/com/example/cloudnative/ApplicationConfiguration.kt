package com.example.cloudnative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
/**
 * 스프링 부트에 의해 필요 없어진 애노테이션
 * @Configuration
 * @EnableAspectJAutoProxy
 */
class ApplicationConfiguration {
    /**
     * 스프링 부트에 의해 필요 없어진
     * @Bean(destroyMethod = "shutdown")
    fun dataSource(): DataSource = EmbeddedDatabaseBuilder()
    .setType(EmbeddedDatabaseType.H2)
    .setName("customers")
    .build()

     * @Bean
    fun jdbcTemplate(): JdbcTemplate = JdbcTemplate(dataSource())
     */
}

fun main(args: Array<String>) {
    runApplication<ApplicationConfiguration>(*args)
}