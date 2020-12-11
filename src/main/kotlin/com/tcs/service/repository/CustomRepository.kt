package com.tcs.service.repository

import com.tcs.service.model.DeliveryMomentModel
import com.tcs.service.model.LogisticGroupExclusion

interface CustomRepository {

    fun getById(id: String?): List<DeliveryMomentModel>
    fun findAllsoftdelete() : List<DeliveryMomentModel>
    fun findAllByQueryParams(storeNumber: Long?, StreamNumber: Int?,
                             schemaName: String?,deliveryDateTime:String?,orderDateTime:String?,
                             fillDateTime:String?,
                             startFillTime:String?,deliveryDateFrom:String?, deliveryDateTo:String?,
                             orderDateFrom:String?, orderDateTo:String?, fillDateFrom:String?,
                             fillDateTo:String?, startFillTimeFrom:String?, startFillTimeTo:String?
                             ,logisticGroupNumber:Int?,mainDeliveryFlag: String?): List<DeliveryMomentModel>?

    fun getbyanyparam(storeNumber: Long?, streamNumber: Int?,
                      deliveryDateTime: String?, orderDateTime: String?
                      , fillDateTime: String?): List<DeliveryMomentModel>


}