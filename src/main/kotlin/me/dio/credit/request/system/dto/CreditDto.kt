package me.dio.credit.request.system.dto

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [MaxThreeMonthsValidator::class])
annotation class MaxThreeMonths(
        val message: String = "A data para o primeiro pagamento deve ser de no máximo 3 meses.",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)

class MaxThreeMonthsValidator : ConstraintValidator<MaxThreeMonths, LocalDate> {
        override fun isValid(value: LocalDate?, context: ConstraintValidatorContext): Boolean {
                if (value == null) {
                        return true
                }
                val currentDate = LocalDate.now()
                val maxDate = currentDate.plusMonths(3)
                return value.isBefore(maxDate) || value.isEqual(maxDate)
        }
}

data class CreditDto(
        @field:NotNull val creditValue: BigDecimal,

        @field:Future(message = "A data tem que ser futura")
        @field:MaxThreeMonths
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
