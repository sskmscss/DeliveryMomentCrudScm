package com.tcs.service.model

import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Document(collection = "delivery-moment\u200b")
data class DeliveryMomentModel(
        @Id
        var id: String?,
        @NotNull
        var storeNumber: Long,
        var streamNumber: Int?,
        var deliveryStreamName: String?,
        var schemaName: String?,
        var deliveryDateTime: String?,
        var orderDateTime: String?,
        var initialPromotionFlag: String?,
        var orderStatus : String?,
        var totalInitialOrderQuantity: Long?,
        var totalOrderQuantity: Long?,
        @NotNull
        @Min(value=1,message="should be greater than 1")
        @Max(value=99999,message ="should be less than 99999")
        var boxSize: Long,
        var fillDateTime: String?,
        var mainDeliveryFlag: String?,
        var storeAdviseFlag: String?,
        var deliverySchemaType: Int?,
        var delivererNumber: Long?,
        var startFillTime: String?,
        var storeOrder: MutableList<StoreOrder>?,
        var logisticGroupExclusion: List<LogisticGroupExclusion>?,
        var createdBy : String?,
        var creationDateTime: String?,
        var updatedBy : String?,
        var updateDateTime : String?,
        var isdeleted:Boolean? = false
)