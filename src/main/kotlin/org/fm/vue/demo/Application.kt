package org.fm.vue.demo

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.crypto.SecretKey

@SpringBootApplication
open class Application {

    /**
     * 临时生成密钥
     */
    @Bean
    open fun secretKey(): SecretKey {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256)
    }

}

/**
 * 程序入口
 */
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
