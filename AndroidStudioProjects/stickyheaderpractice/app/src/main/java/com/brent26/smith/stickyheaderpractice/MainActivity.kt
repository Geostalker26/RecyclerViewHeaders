package com.brent26.smith.stickyheaderpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.shuhart.stickyheader.StickyHeaderItemDecorator
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val vehicleTypes = arrayOf("Cars", "Bikes", "Air Crafts", "Old Vehicles")

    private var sectionArrayList: ArrayList<Section>? = null

    private val childnames = arrayOf(
        "Range Rover",
        "Lamborghini",
        "Rolls Royce",
        "Ferrari",
        "Harley davidson",
        "Ducati",
        "BMW",
        "Honda",
        "Boeing",
        "Airbus",
        "Royal Air",
        "Space X",
        "Horse",
        "Elephant",
        "Camel",
        "Donkey",
        "Khachhar",
        "Horse 2",
        "Camel 2",
        "Donkey 2",
        "Tesla",
        "Mercedes"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        sectionArrayList = ArrayList<Section>()
        populateList()

        val adapter = SectionAdapter(sectionArrayList!!)
        recyclerView.adapter = adapter
        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(recyclerView)


    }

    private fun populateList() {

        var headerdone = 0
        var childdone = 0

        for (i in 0..25) {

            if (i == 0 || (i == 5) or (i == 10) or (i == 15)) {

                val vehicleModel = HeaderModel(i)
                vehicleModel.setHeader(vehicleTypes[headerdone])
                sectionArrayList!!.add(vehicleModel)
                headerdone += 1
            } else {

                var childModel: ChildModel? = null
                childModel = when (i) {
                    1, 2, 3, 4 -> ChildModel(0)
                    6, 7, 8, 9 -> ChildModel(5)
                    11, 12, 13, 14 -> ChildModel(10)
                    else -> ChildModel(15)
                }

                childModel.setChild(childnames[childdone])
                sectionArrayList!!.add(childModel)
                childdone += 1
            }
        }
    }
}