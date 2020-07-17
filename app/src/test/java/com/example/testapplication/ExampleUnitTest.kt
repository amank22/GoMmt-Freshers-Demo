package com.example.testapplication

import android.webkit.JsResult
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {




    @Test
    fun addition_isCorrect() {


        /*var json = JSONObject(null)
       var obj1:EnumClass = EnumClass.Type1()
        var obj2:EnumClass = EnumClass.Type1()

        if(obj1==obj2)
        {
            print("true")
        }else
        {
            print("true")
        }*/


        var a:Int  = 10;
        var b:Int = 10;

        if(a==b)
        { print("true")

        }


          /*  var s:String? = null  // Nullable

             var i = s?.length
                print(s?.length)
                s?.length ?: -1*/

        { i:Int ->print("hello $i")  }





           /* var i = s?.let {
                s.length
                s.length + 8
            } ?: 5*/



        //test1({s:Int -> run { println(s) } })



    }

    fun test1(action:(Int)->Unit,p:JsResult)
    {

    }


}
