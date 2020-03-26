package r2.adam.ndk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private val myMath = MyMath()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeCpp.text = myMath.stringFromJNI()
        timeJava.text = myMath.stringFromJNI()

        start.setOnClickListener {
            it.isClickable = false
            val i = iteration.text.toString().replace(" ", "", false).toLong()
            testIteration(i)
        }
    }

    private fun testIteration(iteration: Long) {


        val nativeTime = measureTimeMillis {
            myMath.primeNumbersNative(iteration)
        }

        val javaTime = measureTimeMillis {
            myMath.primeNumberJava(iteration)
        }

        timeJava.text = "Java : $javaTime"
        timeCpp.text = "Native : $nativeTime"
        start.isClickable = true
    }
}
