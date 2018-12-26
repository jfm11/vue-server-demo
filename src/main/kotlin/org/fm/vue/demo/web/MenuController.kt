package org.fm.vue.demo.web

import org.fm.vue.demo.model.Menu
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("menu")
open class MenuController {

    @GetMapping("fetch",
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun fetch(): List<Menu> {
        val home = Menu("/", "首页", null)
        val mockClient = Menu("/mock-client", "模拟客户端", null)
        val myWorkspace = Menu("", "我的工作台", listOf(mockClient))
        return listOf(home, myWorkspace)
    }

}