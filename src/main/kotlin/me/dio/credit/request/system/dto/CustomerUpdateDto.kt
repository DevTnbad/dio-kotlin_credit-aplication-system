package me.dio.credit.request.system.dto

import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
        val firstName: String,
        val lastName: String,
        val income: BigDecimal,
        val zipcode: String,
        val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName  = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipcode
        return customer
    }
}