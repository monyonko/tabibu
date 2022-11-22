package com.tabibu.entities
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.adminRoutes() {
    routing {

    }

    fun Route.listOrdersRoute() {
        get("/order") {

        }
    }

    fun Route.getOrderRoute() {
        get("/order/{id}") {

        }
    }

    fun Route.totalizeOrderRoute() {
        get("/order/{id}/total") {

        }
    }
}