package com.kotlincoroutines.home.model

data class HomeResponse(
    val title: String,
    val topics: ArrayList<Topic>,
)

data class Topic(
    val topic: String,
    val icon: String,
    val topicId: Int,
    val subTopics: ArrayList<SubTopic>
)

data class SubTopic(
    val subTopic: String,
    val subTopicId: Int
)

val response = HomeResponse(
    title = "Kotlin Coroutines Masterclass",
    topics = arrayListOf(
        Topic(
            topic = "Coroutine Basics",
            icon = "🚀",
            topicId = 0,
            subTopics = arrayListOf(
                SubTopic("What is a Coroutine?", 0),
                SubTopic("Launching Your first Coroutines", 1),
                SubTopic("Suspending Functions", 2),
                SubTopic("Coroutine Scopes", 3),
                SubTopic("Jobs & Deferred", 4),
                SubTopic("Coroutines in Compose", 5),
                SubTopic("Homework Assignment - Coroutine Basics", 6),
                SubTopic("Homework Assignment Hints - Coroutine Basics", 7),
            )
        ),
        Topic(
            topic = "Coroutine Contexts",
            icon = "🎯",
            topicId = 1,
            subTopics = arrayListOf(
                SubTopic("What is a Coroutine Context", 0),
                SubTopic("withContext", 1),
                SubTopic("IO & Default Dispatchers", 2),
                SubTopic("Main & Main Immediate Dispatchers", 3),
                SubTopic("Unconfined Dispatcher", 4),
                SubTopic("Home Assignment - Coroutine Contexts", 5),
                SubTopic("Home Assignment Hints - Coroutine Contexts", 6)
            )
        ),
        Topic(
            topic = "Coroutine Cancellation",
            icon = "⏹️",
            topicId = 2,
            subTopics = arrayListOf(
                SubTopic("Why Cancellation Seems Simple, But Is Hard", 0),
                SubTopic("The Consequences of Cancellation", 1),
                SubTopic("Cancellation Trap #1: try/catch", 2),
                SubTopic("Cancellation Trap #2: Transaction-like Behavior", 3),
                SubTopic("Cancellation Trap #3: try/finally", 4),
                SubTopic("ensureActive() vs yield()", 5),
                SubTopic("Home Assignment - Coroutine Cancellation", 6),
                SubTopic("Home Assignment Hints - Coroutine Cancellation", 7)
            )
        ),
        Topic(
            topic = "Coroutine Error Handling",
            icon = "🛡️",
            topicId = 3,
            subTopics = arrayListOf(
                SubTopic("How Coroutines Treat Exceptions", 0),
                SubTopic("Catching Errors with CoroutineExceptionHandler", 1),
                SubTopic("SupervisorJob", 2),
                SubTopic("coroutineScope & supervisorScope", 3),
                SubTopic("Home Assignment - Coroutine Error Handling", 4),
                SubTopic("Home Assignment Hints - Coroutine Error Handling", 5)
            )
        ),
        Topic(
            topic = "Combining What You've Learnt So Far",
            icon = "🔗",
            topicId = 4,
            subTopics = arrayListOf(
                SubTopic("Converting a Callback to a Suspend Function", 0),
                SubTopic("Home Assignment - Combining What You've Learnt So Far", 1),
                SubTopic("Home Assignment Hints - Combining What You've Learnt So Far", 2)
            )
        ),
        Topic(
            topic = "Coroutine Synchronization",
            icon = "🔃",
            topicId = 5,
            subTopics = arrayListOf(
                SubTopic("When Do You Have to Think of Synchronization", 0),
                SubTopic("synchronized and Mutex", 1),
                SubTopic("Concurrent Lists and HashMaps", 2),
                SubTopic("Single Thread Dispatcher", 3),
                SubTopic("Home Assignment - Coroutine Synchronization", 4),
                SubTopic("Home Assignment Hints - Coroutine Synchronization", 5)
            )
        ),
        Topic(
            topic = "Flow Fundamentals",
            icon = "🌊",
            topicId = 6,
            subTopics = arrayListOf(
                SubTopic("What is a Flow", 0),
                SubTopic("The Structure of Every Launched Flow", 1),
                SubTopic("SharedFlow", 2),
                SubTopic("StateFlow", 3),
                SubTopic("Making a Cold Flow hot with stateIn()", 4),
                SubTopic("Making a cold Flow hot with shareIn()", 5),
                SubTopic("Callback Flow", 6),
                SubTopic("Home Assignment - Flow Fundamentals", 7),
                SubTopic("Home Assignment Hints - Flow Fundamentals", 8)
            )
        ),
        Topic(
            topic = "Flows In Practice",
            icon = "⚡",
            topicId = 7,
            subTopics = arrayListOf(
                SubTopic("Building a Timer Flow", 0),
                SubTopic("Transforming Tracked Locations with zip() and combine()", 1),
                SubTopic("Combining UI States", 2),
                SubTopic("Listening to a WebSocket Stream In a Flow", 3),
                SubTopic("Handling Flow Errors & Retrying Failed Flows", 4),
                SubTopic("flatMapConcat / flatMapMerge / flatMapLatest", 5),
                SubTopic("Handling Backpressure", 6),
                SubTopic("Home Assignment - Flow In Practice", 7),
                SubTopic("Home Assignment Hints - Flow In Practice", 8)
            )
        ),
        Topic(
            topic = "Testing Coroutines & Flows",
            icon = "🧪",
            topicId = 8,
            subTopics = arrayListOf(
                SubTopic("Testing Suspending Functions", 0),
                SubTopic("Testing Code That Launches Coroutines", 1),
                SubTopic("Testing Flows", 2),
                SubTopic("Home Assignment - Testing Coroutines & Flows", 3),
                SubTopic("Home Assignment Hints - Testing Coroutines & Flows", 4)
            )
        ),
        Topic(
            topic = "Final Quiz & Certificate",
            icon = "🏆",
            topicId = 9,
            subTopics = arrayListOf(
                SubTopic("How You Get Your Certificate", 0),
                SubTopic("Final Quiz", 1),
                SubTopic("Certificate", 2)
            )
        )
    )
)