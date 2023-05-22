package me.dio.credit.request.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        @field:NotNull val creditValue: BigDecimal,

        @field:Future(message = "A data tem que ser futura")
        val dayFirstOfInstallment: LocalDate,

        @field:Positive @field:Max(value  = 48) val numberOfInstallments: Int,

        @field:NotNull val customerId: Long
) {
        fun toEntity(): Credit = Credit(
                creditValue = this.creditValue,
                dayFirstInstallment = this.dayFirstOfInstallment,
                numberOfInstallments = this.numberOfInstallments,
                customer = Customer(id = this.customerId)
        )
}
