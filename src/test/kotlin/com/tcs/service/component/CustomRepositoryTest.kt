package com.tcs.service.component

import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.model.DeliveryMomentModel
import com.tcs.service.model.Model
import com.tcs.service.repository.CustomRepositoryImpl
import com.tcs.service.repository.Repository
import com.tcs.service.service.Service
import com.tcs.service.utility.getModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class CustomRepositoryTest {
    @Autowired
    lateinit var service: Service

    @MockBean
    lateinit var mongoTemplate: MongoTemplate

    @MockBean
    lateinit var criteria: Criteria

    @MockBean
    lateinit var customRepository: CustomRepositoryImpl




    @BeforeEach
    fun setup() {
        whenever(mongoTemplate.find(Query(Criteria()), DeliveryMomentModel::class.java)).thenAnswer {
            Optional.of(getModel().data)
        }

    }

    @Test
    fun `findAllsoftdelete`() {
        assert(customRepository.findAllsoftdelete() is List<DeliveryMomentModel>)
    }

    @Test
    fun `should return model object`() {
        assert(customRepository.findAllByQueryParams(storeNumber = 12, StreamNumber = 1234,
                schemaName = "",deliveryDateTime = "",orderDateTime = "",
                fillDateTime = "", startFillTime = "",deliveryDateFrom = "",deliveryDateTo = "",orderDateFrom = "",orderDateTo = "",
                fillDateFrom = "",fillDateTo = "",startFillTimeFrom = "",startFillTimeTo = "",logisticGroupNumber = 1,mainDeliveryFlag = "") is List<DeliveryMomentModel>)
    }

    @Test
    fun `getbyanyparam`() {
        assert(customRepository.getbyanyparam(storeNumber = 1, streamNumber = 1234,
                deliveryDateTime = "",orderDateTime = "", fillDateTime = "") is List<DeliveryMomentModel>)
    }
}