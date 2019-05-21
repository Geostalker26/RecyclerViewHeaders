package com.brent26.smith.stickyheaderpractice

class ChildModel(private val section: Int) : Section {

    private lateinit var child: String
    fun setChild(child: String) {
        this.child = child
    }

    override fun isHeader(): Boolean {
        return false
    }

    override fun getName(): String {
        return child
    }

    override fun sectionPosition(): Int {
        return section
    }
}
