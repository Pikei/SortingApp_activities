package com.sortingapp_activities.androidsample

import android.content.Intent
import android.graphics.Paint.Align
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sortingapp_activities.androidsample.databinding.ActivityResultBinding

class Result() : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var arr: IntArray
    private lateinit var method: String
    private var printExample = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        arr = extras.getIntArray("array")!!
        method = extras.getString("methodName")!!
        val methodTitle = binding.method
        methodTitle.text = method
        var resultMessage = ""
        for (i in arr.indices) {
            resultMessage += if (i == arr.size-1) {
                arr[i].toString()
            } else {
                arr[i].toString() + ", "
            }
        }
        binding.sortedNumbers.text = resultMessage
    }

    fun explain(view: View) {

        when(method) {
            "Bubble Sort" -> explainBubbleSort()
            "Quick Sort" -> explainQuickSort()
        }
    }

    private fun explainBubbleSort() {
        val explanation = """
            Bubble sort, is a simple sorting algorithm that 
            repeatedly steps through the input list element by element, 
            comparing the current element with the one after it, 
            swapping their values if needed. These passes through the list 
            are repeated until no swaps have to be performed during a pass, 
            meaning that the list has become fully sorted. 
            The algorithm, which is a comparison sort, is named 
            for the way the larger elements "bubble" up to the top of the list.
            Press button "Explain" again to see an example.
        """
        val example = """
            Example:
            given array of unsorted numbers: 
                [6,2,4,5,3,1]
                
            1. Compare two numbers and swap them if needed:
                [6,2,4,5,3,1]
                 ^ ^
            2. Repeat comparing and swapping largest element 
            until it is at the end of array. Move border one element to the left
                [2,4,5,3,1|6]
                           ^
            3. Repeat steps to next largest number:
                [2,4,3,1|5,6]
                         ^
            4. Repeat steps 1-3 until array is sorted.

            """
        if (!printExample){
            binding.explanation.text = explanation
            binding.explanation.textAlignment = View.TEXT_ALIGNMENT_CENTER
            binding.explanation.visibility = View.VISIBLE
            printExample = true
        } else {
            binding.explanation.text = example
            binding.explanation.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
            binding.explanation.visibility = View.VISIBLE
            printExample = false
        }
    }

    private fun explainQuickSort() {
        val explanation = """
            Quicksort works by selecting a 'pivot' element 
            from the array and partitioning the other elements 
            into two sub-arrays, according to whether they are 
            lesser than or greater than the pivot. 
            The sub-arrays are then sorted recursively.
            Press button "Explain" again to see an example.
        """
        val example = """
            Example:
            given array of unsorted numbers: 
                [6,2,4,5,3,1]
                
            1. Select pivot and switch its position to end of array:
                [6,2,1,5,3,4]
                           ^
            2. Find first number from left that is greater than pivot 
            and first number from right that is lesser than pivot, and swap them:
                [3,2,1,5,6,4]
                 ^       ^
            3. Repeat until index from left is greater than or even 
            to index from right, then swap element of index from left with pivot:
                [3,2,1,4,6,5]
                       ^   ^
            4. Now everything to left is lesser than pivot, 
            and everything to right is greater than pivot.
            Repeat steps to sub-arrays:
                [3,2,1][6,5]
                
            5. Repeat steps 1-4 until array is sorted.
            """
        if (!printExample){
            binding.explanation.text = explanation
            binding.explanation.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
            binding.explanation.visibility = View.VISIBLE
            printExample = true
        } else {
            binding.explanation.text = example
            binding.explanation.textAlignment = View.TEXT_ALIGNMENT_CENTER
            binding.explanation.visibility = View.VISIBLE
            printExample = false
        }


    }

    fun goBack(view: View) {
        val main = Intent(this,MainActivity::class.java)
        startActivity(main)
    }
}