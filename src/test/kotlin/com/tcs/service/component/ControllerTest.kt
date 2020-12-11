package com.tcs.service.component


import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.constant.URLPath
import com.tcs.service.constant.URLPath.BASE_URI
import com.tcs.service.constant.URLPath.DEL_RESPONSE_JSON_PATH
import com.tcs.service.constant.URLPath.ENTITY_RESPONSE_JSON_PATH
import com.tcs.service.constant.URLPath.GET_ALL_URI
import com.tcs.service.constant.URLPath.GET_BY_ID_URI
import com.tcs.service.constant.URLPath.GET_RESPONSE_JSON_PATH
import com.tcs.service.constant.URLPath.POST_PUT_DELETE_URI
import com.tcs.service.constant.URLPath.POST_RESPONSE_JSON_PATH
import com.tcs.service.constant.URLPath.PUT_RESPONSE_JSON_PATH
import com.tcs.service.constant.URLPath.SAMPLE_RESPONSE_JSON_PATH
import com.tcs.service.model.DeliveryMomentModel
import com.tcs.service.service.Service
import com.tcs.service.utility.getModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.*
import java.io.File

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class ControllerTest: BaseTest() {


    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: Service

    @MockBean
    lateinit var model: DeliveryMomentModel



    /**
     * Preparing Mock Stub For service class
     **/
    @BeforeEach
    fun setup() {
        whenever(service.getById(id = dataId)).thenAnswer { getModel() }

        whenever(service.getByQueryParam(storeNumber, streamNumber,
                schemaName,deliveryDateTime,orderDateTime, fillDateTime, startFillTime, deliveryDateFrom,deliveryDateTo,orderDateFrom,orderDateTo,
                fillDateFrom,fillDateTo,startFillTimeFrom,startFillTimeTo ,logisticGroupNumber, mainDeliveryFlag)).thenAnswer { getModel() }

        whenever( service.getByQueryParamanymatch(storeNumber, streamNumber,
                deliveryDateTime,orderDateTime, fillDateTime)).thenAnswer { getModel() }

        whenever(service.save(model) ).thenAnswer { getModel() }

        whenever(service.delete(id = dataId) ).thenAnswer { getModel() }


    }


//    whenever(service.getById(id = dataId)).thenAnswer { getModel() }
//    whenever(service.getById(id = dataId)).thenAnswer { getModel() }



    /**
     * Test Method  for Controller Get Endpoint
     * Service call is mocked
     **/
    @Test
    fun `should respond data using id`() {
        var expected = File(SAMPLE_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get(BASE_URI + GET_BY_ID_URI, dataId)
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false)
    }

    @Test
    fun `should respond with parameters`(){
        var expected = File(GET_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get(BASE_URI + URLPath.GET_ALL_URI, storeNumber, streamNumber,
                        schemaName,deliveryDateTime, orderDateTime,
                        fillDateTime, startFillTime, deliveryDateFrom,
                        deliveryDateTo, orderDateFrom, orderDateTo,
                        fillDateFrom, fillDateTo,
                        startFillTimeFrom, startFillTimeTo,logisticGroupNumber, mainDeliveryFlag)
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false )
    }

    @Test
    fun `should respond with post msg`(){
        var expected = File(POST_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.post(BASE_URI + POST_PUT_DELETE_URI, File(ENTITY_RESPONSE_JSON_PATH))
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false )
    }

    @Test
    fun `should get unique`(){
        var expected = File(GET_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get(BASE_URI + GET_ALL_URI, File(ENTITY_RESPONSE_JSON_PATH))
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false )
    }

    @Test
    fun `should respond with put message`(){
        var expected = File(PUT_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.post(BASE_URI + POST_PUT_DELETE_URI, File(ENTITY_RESPONSE_JSON_PATH))
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false )
    }

    @Test
    fun `should respond with del message`(){
        var expected = File(DEL_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.delete(BASE_URI + GET_BY_ID_URI, File(ENTITY_RESPONSE_JSON_PATH))
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false )
    }

}