enum class KanbanStatus(var status: String){
    toDo("To Do"){
        override fun moveToNext() = doing
        override fun moveToPrevious() = toDo
    },
    doing("Doing"){
        override fun moveToNext() = done
        override fun moveToPrevious() = toDo
    },
    done("Done"){
        override fun moveToNext() = done
        override fun moveToPrevious() = doing
    };
    
    abstract fun moveToNext() : KanbanStatus
    abstract fun moveToPrevious() : KanbanStatus
}

enum class MOSCOW(var priority: Int){
    must(4),
    should(3),
    could(2),
    would(1),
}

fun suggestAction(taskPriority : MOSCOW){
    println("${taskPriority.priority}\n")
    
    when(taskPriority){
        MOSCOW.must ->
        	println("This task is very important! Start by doing it.")
        MOSCOW.should -> 
        	println("This task is important, but should be done at a second moment.")
        MOSCOW.could -> 
        	println("This task could improve the overall project,\n" + 
                    "but is not essential and should be done in the future")
        MOSCOW.would ->
        	println("This task would have a positive impact in the project,\n" +
                    "but it's not required right now and should be done only if\n" +
                    "more important tasks are done")
    }
}

fun moveTaskForward(currentStatus : KanbanStatus) : KanbanStatus{
    println("Current Status: ${currentStatus.status}\n")
    
    when(currentStatus){
        KanbanStatus.toDo, KanbanStatus.doing -> 
        	println("Moving the task to the next column")
            
        KanbanStatus.done ->
        	println("Task is already done, you can't move it forward")
    }
    return currentStatus.moveToNext()
}

fun moveTaskBackward(currentStatus : KanbanStatus) : KanbanStatus{
    println("Current Status: ${currentStatus.status}\n")
    
    when(currentStatus){
        KanbanStatus.doing, KanbanStatus.done -> 
        	println("Moving the task to the previous column")
            
        KanbanStatus.toDo ->
        	println("Task wasn't start yet, you can't move it backward")
    }
    return currentStatus.moveToPrevious()
}

fun main() {
    val priority = MOSCOW.would
    suggestAction(priority)
  
    var kanban = KanbanStatus.done
    
    for(i in 0..2){
        kanban = moveTaskBackward(kanban)
        println(kanban)
    }
    
}