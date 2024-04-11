package com.sortingapp_activities.androidsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sortingapp.androidsample.BubbleSort
import com.sortingapp.androidsample.QuickSort
import com.sortingapp_activities.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun  getNumbers(): IntArray {
        var numbers = binding.numbers.text.toString()
        numbers = numbers.replace(" ", ",")
        numbers = numbers.replace(",,", ",")
        val stringBuilder = StringBuilder(numbers)
        if (numbers[0] == ',') {
            numbers = stringBuilder.deleteAt(0).toString()
        }
        if (numbers[numbers.length-1] == ',') {
            numbers = stringBuilder.deleteAt(numbers.length-1).toString()
        }
        return numbers.split(",").map { it.toInt() }.toIntArray()
    }

    fun buttonAction(view: View) {
        if (binding.numbers.text.toString() != "") {
            if (binding.bubbleSortRadioBtn.isChecked) {
                val bubbleSort = BubbleSort(getNumbers())
                bubbleSort.bubbleSort()
                val result = Intent(this,Result::class.java)
                result.putExtra("array",bubbleSort.getArray())
                result.putExtra("methodName","Bubble Sort")
                startActivity(result)

            } else if (binding.quickSortRadioBtn.isChecked) {
                val quickSort = QuickSort(getNumbers())
                quickSort.sort()
                val result = Intent(this,Result::class.java)
                result.putExtra("array",quickSort.getArray())
                result.putExtra("methodName","Quick Sort")
                startActivity(result)
            }
        } else {
            val message = "Type your numbers first"
            binding.errorMessage.text = message
            binding.errorMessage.visibility = View.VISIBLE
        }
    }

//    private fun bubbleSortAction(view: View): IntArray {
//        val bubbleSort = BubbleSort(getNumbers())
//        bubbleSort.bubbleSort()
//        return bubbleSort.getArray()
//    }
//
//    private fun quickSortAction(view: View): IntArray {
//        val quickSort = QuickSort(getNumbers())
//        quickSort.sort()
//        return quickSort.getArray()
//    }
//

}