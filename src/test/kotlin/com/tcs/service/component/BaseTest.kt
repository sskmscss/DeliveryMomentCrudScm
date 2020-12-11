package com.tcs.service.component

import com.tcs.service.model.DeliveryMomentModel
import com.tcs.service.model.LogisticGroupExclusion
import com.tcs.service.model.StoreOrder
import org.springframework.beans.factory.annotation.Value

open class BaseTest {

    @Value("\${service.test-data.id}")
    public val dataId: String = "0"
    public val storeNumber: Long?=0
    public val streamNumber: Int? =0

    public val schemaName: String? =""
    public val deliveryDateTime: String?="2020-11-24"
    public val orderDateTime: String? ="2020-11-20"

    public val fillDateTime: String?="2020-11-24"
    public val mainDeliveryFlag: String?="J"

    public val startFillTime: String?="2020-11-24"

    public val deliveryDateFrom:String? = "abc"
    public val deliveryDateTo:String? = "xyz"
    public val orderDateFrom:String? = "abc"
    public val orderDateTo:String? = "xyz"
    public val fillDateFrom:String? = "abc"
    public val fillDateTo:String? = "xyz"
    public val startFillTimeFrom:String? = "abc"
    public val startFillTimeTo:String? = "xyz"
    public val logisticGroupNumber:Int? = 0
    public val Baseurl: String = ""
    public val params: MutableMap<String, String> = mutableMapOf()
    public val deliveryStreamName: String? = ""
    public val initialPromotionFlag: String? = ""
    public val orderStatus : String? = ""
    public val totalInitialOrderQuantity: Long? = 0
    public val totalOrderQuantity: Long? = 0
    public val boxSize: Long = 0
    public val storeAdviseFlag: String? = ""
    public val deliverySchemaType: Int? = 0
    public val delivererNumber: Long? = 0
    public val storeOrder: MutableList<StoreOrder>? = mutableListOf()
    public val logisticGroupExclusion: List<LogisticGroupExclusion>? = listOf()
    public val createdBy : String? = ""
    public val creationDateTime: String? = ""
    public val updatedBy : String? = ""
    public val updateDateTime : String? = ""
    public val isdeleted:Boolean? = false
    public val responseCode: String = ""
    public val responseDescription: String = ""
    public val response: Any? = Any()
    public val orderNumber: Long? = 0
    public val warehouseNumber: Int = 0
}