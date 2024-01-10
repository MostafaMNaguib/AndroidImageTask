package com.example.myapplication

import android.util.Log

class ImageSetter private constructor(width: Double, height: Double,scale: String,grayScale: String)
{
    class Builder{
        private var width: Double = 200.0
        private var height: Double = 200.0
        private var scale: String = "fitXY"
        private var grayScale: String = "Colored"

        fun width(value: Double) = apply {
            width = value
        }
        fun height(value: Double) = apply {
            height = value
        }
        fun scale(value: String) = apply {
            scale = value
        }
        fun grayScale(value: String) = apply {
            grayScale = value
        }

        fun build() = ImageSetter(width,height,scale,grayScale)

    }

    fun area(a:Int , b:Int) :Int{
        return a * b
    }
    fun area(a:Double , b:Double) :Double{
        return a * b
    }

}

open class Calculation(a: Int){
    fun calArea(a:Double, b:Double): Double{
        print("Cal Area")
        return a * b
    }
    open fun calArea(a:Int, b:Int): Int{
        print("Open Cal Area")
        Log.e("TAG00","Open Cal Area ")

        return a*b
    }

}
class Square: Calculation(0){
    override fun calArea(a: Int, b: Int): Int {
        //
        Log.e("TAG","Square ")
//        return 0
        return super.calArea(a, b)
    }
}

class Rectangle: Calculation(0){
    override fun calArea(a: Int, b: Int): Int {
        //
        return super.calArea(a, b)
    }
}

/*
*
* {
	"item1": {
		"type": "text",
		"value": "this is a text 1"
	},
	"item2": {
		"type": "text",
		"value": "this is a QR-Code 1"
	},
	"item3": {
		"type": "QR-Code",
		"value": "this is a QR-Code 2"
	},
	"item4": {
		"type": "Bar-Code",
		"value": "this is a QR-Code 3"
	}
}
has context menu
*
* */

// 1- Setup Project === 0.5 H
// 2- Build Architecture 1H
// 3- Build model 1 H
// 4- Build Ui ( RecyclerView - item ) 2H
// 4- Create inversion fun (Qr-barcode) 1 - 2 H
// 5- api integration
// 6- Local Db 2H
// 7- network checker 1H