package me.dio.credit.request.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
        @field:NotEmpty(message = "O campo deve ser preenchido.") val firstName: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val lastName: String,
        @field:NotNull val income: BigDecimal,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val zipCode: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName  = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
