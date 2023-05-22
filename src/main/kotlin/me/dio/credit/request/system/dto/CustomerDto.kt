package me.dio.credit.request.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Address
import me.dio.credit.request.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
        @field:NotEmpty(message = "O campo deve ser preenchido.") val firstName: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val lastName: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.")
        @field:CPF(message = "Esse CPF não é válido.") val cpf: String,
        @field:NotNull val income: BigDecimal,
        @field:NotEmpty(message = "O campo deve ser preenchido.")
        @field:Email(message = "Não foi digitado um email válido.") val email: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val password: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val zipcode: String,
        @field:NotEmpty(message = "O campo deve ser preenchido.") val street: String,
) {

    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                    zipCode = this.zipcode,
                    street = this.street
            )

    )
}


