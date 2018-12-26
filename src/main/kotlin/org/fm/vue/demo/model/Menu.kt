package org.fm.vue.demo.model

data class Menu(val index: String,
                val name: String,
                val children: List<Menu>?)