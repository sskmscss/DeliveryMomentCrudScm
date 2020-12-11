package com.tcs.service.component

import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.model.DeliveryMomentModel
import com.tcs.service.model.Model
import com.tcs.service.repository.Repository
import com.tcs.service.service.Service
import com.tcs.service.utility.getModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.io.File
import java.util.*


@SpringBootTest()
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class ServiceTest: BaseTest() {

    @Autowired
    lateinit var service: Service

    @MockBean
    lateinit var repository: Repository

    @MockBean
    lateinit var model: DeliveryMomentModel



    @BeforeEach
    fun setup() {
        whenever(repository.findById(dataId.toInt())).thenAnswer {
            Optional.of(getModel().data)
        }
        whenever(repository.findAllsoftdelete()).thenAnswer {
            Optional.of(getModel().data)
        }
        whenever(repository.findAllByQueryParams(storeNumber, streamNumber,
                schemaName,deliveryDateTime,orderDateTime,
                fillDateTime, startFillTime,deliveryDateFrom,deliveryDateTo,orderDateFrom,orderDateTo,
                fillDateFrom,fillDateTo,startFillTimeFrom,startFillTimeTo,logisticGroupNumber,mainDeliveryFlag)).thenAnswer {
            Optional.of(getModel().data)
        }
        whenever(repository.save(model)).thenAnswer {
            Optional.of(getModel().data)
        }
        whenever(repository.getbyanyparam(storeNumber, streamNumber,
                deliveryDateTime,orderDateTime, fillDateTime)).thenAnswer {
            Optional.of(getModel().data)
        }

    }


    @Test
    fun `should return model object`() {
        assert(service.getById(dataId) is Model)
    }

    @Test
    fun `should get All`() {
        assert(service.get() is MutableList<DeliveryMomentModel>)
    }

    @Test
    fun `should save model object`() {
        assert(service.save(model) is Unit)
    }

    @Test
    fun `should delete model object`() {
        assert(service.delete(dataId) is Unit)
    }

    @Test
    fun `should get Query Param`() {
        assert(service.getByQueryParamanymatch(storeNumber, streamNumber,
                deliveryDateTime,orderDateTime, fillDateTime) is List<DeliveryMomentModel>)
    }

    @Test
    fun `should get specifically by Query Param`() {
        assert(service.getByQueryParam(storeNumber, streamNumber,
                schemaName,deliveryDateTime,orderDateTime, fillDateTime, startFillTime, deliveryDateFrom,deliveryDateTo,orderDateFrom,orderDateTo,
                fillDateFrom,fillDateTo,startFillTimeFrom,startFillTimeTo ,logisticGroupNumber, mainDeliveryFlag) is List<DeliveryMomentModel>)
    }




}