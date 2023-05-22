package me.dio.credit.request.system.service

/*
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import me.dio.credit.request.system.entity.Address
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Customer
import me.dio.credit.request.system.exception.BusinessException
import me.dio.credit.request.system.repository.CreditRepository
import me.dio.credit.request.system.service.impl.CreditService
import me.dio.credit.request.system.service.impl.CustomerService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month
import java.util.*

@ExtendWith(MockKExtension::class)
class CreditServiceTest {
    @Autowired
    lateinit var testEntityManager: TestEntityManager

    @MockK
    private lateinit var creditRepository: CreditRepository

    @MockK
    private lateinit var customerService: CustomerService

    private lateinit var creditService: CreditService

    private lateinit var customer: Customer
    private lateinit var credit1: Credit
    private lateinit var credit2: Credit

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        creditService = CreditService(creditRepository, customerService)

        customer = testEntityManager.persist(buildCustomer())
        credit1 = testEntityManager.persist(buildCredit(customer = customer))
        credit2 = testEntityManager.persist(buildCredit(customer = customer))
    }

    @Test
    fun save_ValidCredit_ReturnsSavedCredit() {
        // Arrange
        val credit = buildCredit()
        val customer = Customer(id = 1)
        val savedCredit = Credit(id = 1, customer = customer)

        every { customerService.findById(1) } returns customer
        every { creditRepository.save(credit) } returns savedCredit

        // Act
        val result = creditService.save(credit)

        // Assert
        assertEquals(savedCredit, result)
    }

    @Test
    fun save_InvalidCredit_ThrowsBusinessException() {
        // Arrange
        val credit = Credit()
        every { customerService.findById(any()) } returns null

        // Act & Assert
        assertThrows<BusinessException> {
            creditService.save(credit)
        }
    }

    @Test
    fun findByCreditCode_ValidCodeAndCustomer_ReturnsCredit() {
        // Arrange
        val customerId = 1L
        val creditCode = UUID.randomUUID()
        val credit = Credit(id = 1, customer = Customer(id = customerId), creditCode = creditCode)

        every { creditRepository.findByCreditCode(creditCode) } returns credit

        // Act
        val result = creditService.findByCreditCode(customerId, creditCode)

        // Assert
        assertEquals(credit, result)
    }

    @Test
    fun findByCreditCode_InvalidCode_ThrowsBusinessException() {
        // Arrange
        val customerId = 1L
        val creditCode = UUID.randomUUID()

        every { creditRepository.findByCreditCode(creditCode) } returns null

        // Act & Assert
        assertThrows<BusinessException> {
            creditService.findByCreditCode(customerId, creditCode)
        }
    }

    @Test
    fun findByCreditCode_DifferentCustomer_ThrowsIllegalArgumentException() {
        // Arrange
        val customerId = 1L
        val creditCode = UUID.randomUUID()
        val credit = Credit(id = 1, customer = Customer(id = 2), creditCode = creditCode)

        every { creditRepository.findByCreditCode(creditCode) } returns credit

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            creditService.findByCreditCode(customerId, creditCode)
        }
    }

    private fun buildCredit(
            creditValue: BigDecimal = BigDecimal.valueOf(500.0),
            dayFirstInstallment: LocalDate = LocalDate.of(2023, Month.APRIL, 22),
            numberOfInstallments: Int = 5,
            customer: Customer
    ): Credit = Credit(
            creditValue = creditValue,
            dayFirstInstallment = dayFirstInstallment,
            numberOfInstallments = numberOfInstallments,
            customer = customer
    )
    private fun buildCustomer(
            firstName: String = "Cami",
            lastName: String = "Cavalcante",
            cpf: String = "28475934625",
            email: String = "camila@gmail.com",
            password: String = "12345",
            zipCode: String = "12345",
            street: String = "Rua da Cami",
            income: BigDecimal = BigDecimal.valueOf(1000.0),
    ) = Customer(
            firstName = firstName,
            lastName = lastName,
            cpf = cpf,
            email = email,
            password = password,
            address = Address(
                    zipCode = zipCode,
                    street = street,
            ),
            income = income,
    )

}*/
