package com.example.cloudnative

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.stereotype.Component

@Component
class OrderModelAssembler : RepresentationModelAssembler<Order, EntityModel<Order>> {
    override fun toModel(order: Order): EntityModel<Order> {
        val orderModel = EntityModel.of(
            order,
            linkTo<OrderController> {
                one(order.id)
            }.withSelfRel(),
            linkTo<OrderController> {
                all()
            }.withRel("orders")
        )

        if (order.status == Status.IN_PROGRESS) {
            orderModel.add(
                linkTo<OrderController> {
                    cancel(order.id)
                }.withRel("cancel")
            )

            orderModel.add(
                linkTo<OrderController> {
                    complete(order.id)
                }.withRel("cancel")
            )
        }

        return orderModel
    }
}
