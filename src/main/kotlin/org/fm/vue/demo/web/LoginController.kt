package org.fm.vue.demo.web

import io.jsonwebtoken.Jwts
import org.fm.vue.demo.model.Token
import org.fm.vue.demo.model.User
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.crypto.SecretKey

@RestController
open class LoginController(private val secretKey: SecretKey) {


    @PostMapping("/login",
            consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun login(user: User): Token {
        return if (user.username == "admin" && user.password == "admin") {
            val t = Jwts.builder()
                    .setSubject(user.username)
                    .signWith(secretKey)
                    .compact()
            Token(t, "")
        } else {
            Token("", "用户名密码错误")
        }
    }

}