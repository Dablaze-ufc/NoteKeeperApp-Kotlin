package com.dablaze.notekeeperkotlin

class DataManager {
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents"," Android Programming with Intents")
        courses[course.courseId] = course

        course = CourseInfo(courseId = "android_async", tittle = " Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(tittle = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
    }
}