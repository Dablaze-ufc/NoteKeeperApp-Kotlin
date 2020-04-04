package com.dablaze.notekeeperkotlin

import java.io.Serializable

data class CourseInfo(val courseId: String,
                      val tittle: String) {
    override fun toString(): String {
        return tittle
    }
}

data class NoteInfo(var course: CourseInfo? = null,
                    var tittle: String? = null,
                    var text:String? = null) : Serializable
