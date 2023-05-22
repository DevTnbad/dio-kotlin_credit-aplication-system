package me.dio.credit.request.system.annotation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [MaxThreeMonthsValidator::class])
annotation class MaxThreeMonths(val message: String = "The date of the first installment must be within 3 months from now.")

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