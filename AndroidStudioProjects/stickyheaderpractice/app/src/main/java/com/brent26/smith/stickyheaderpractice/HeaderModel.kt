package com.brent26.smith.stickyheaderpractice

class HeaderModel(private val section: Int) : Section {

    private lateinit var header: String

    fun setHeader(header: String) {
        this.header = header
    }

    override fun isHeader(): Boolean {
        return true
    }

    override fun getName(): String {
        return header
    }

    override fun sectionPosition(): Int {
        return section
    }
}
