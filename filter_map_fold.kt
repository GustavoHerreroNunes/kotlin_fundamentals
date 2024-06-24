var userNotes : ArrayList<String> = arrayListOf(
	"Study: Math",
    "Study: Chemistry",
    "Sell: Old Bike",
    "Visit: My Sister",
    "Visit: The Museum",
    "Buy: A New Notebook",
    "Sell: My Old Notebook"
)

enum class MOSCOW(var priority: Int){
    must(4),
    should(3),
    could(2),
    would(1),
}

fun getTaskType(task : String) : String{
    return task.split(":")[0]
}

fun getAllTaskTypes(tasks : ArrayList<String>) : HashSet<String>{
    val taskTypes : HashSet<String> = tasks.fold( HashSet<String>() ){
        acc, it ->
        	acc.add(it.split(":")[0])
            (acc)
    }
    return taskTypes
}

fun prioritizeTasks(tasks : ArrayList<String>) : List<Pair<String, MOSCOW>> {
    val prioritizedTasks = tasks.map({
        var priorityLevel : MOSCOW

        when(getTaskType(it)){
            "Study" -> priorityLevel = MOSCOW.must
            "Sell", "Visit" -> priorityLevel = MOSCOW.should
            "Buy" -> priorityLevel = MOSCOW.could
            else -> priorityLevel = MOSCOW.would
        }

        Pair(it, priorityLevel)
    })
    
    return prioritizedTasks
}

fun filterTasksByPriority(
    prioritizedTasks : List<Pair<String, MOSCOW>>,
    priorityFilter : MOSCOW)
: List<Pair<String, MOSCOW>>{
    val filteredTasks = prioritizedTasks.filter{
        it.second == priorityFilter
    }
    
    return filteredTasks
}

fun main() {
	val filteredTask = filterTasksByPriority(
    	prioritizeTasks(userNotes),
        MOSCOW.would
    )
    if(!filteredTask.isEmpty()){
	    filteredTask.forEach{ println(it) }    
    }else{
        println("---Empty List---")
    }
}