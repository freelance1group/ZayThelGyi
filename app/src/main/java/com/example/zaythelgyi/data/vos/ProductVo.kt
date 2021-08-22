package com.example.zaythelgyi.data.vos

import java.io.Serializable

class ProductVo(
    val start_product_name : String,
    val product_name : String,
    val product_quantity : String,
    val product_price : String
): Serializable {
}