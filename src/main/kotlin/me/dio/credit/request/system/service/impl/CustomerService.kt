package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.entity.Customer
import me.dio.credit.request.system.repository.CustomerRepository
import me.dio.credit.request.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
        private  val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer =
            this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
            this.customerRepository.findById(id).orElseThrow {
                throw RuntimeException("id $id not found")
            }


    override fun delete(id: Long): Unit = this.customerRepository.deleteById(id)

}
