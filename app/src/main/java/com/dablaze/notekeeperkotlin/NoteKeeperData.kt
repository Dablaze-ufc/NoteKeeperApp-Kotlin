package com.dablaze.notekeeperkotlin

data class CourseInfo(val courseId: String,
                      val tittle: String) {
    override fun toString(): String {
        return tittle
    }
}

data class NoteInfo(var course: CourseInfo,
                    var tittle: String,

                    var text:String)
