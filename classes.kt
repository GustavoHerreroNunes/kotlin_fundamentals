var usersList = ArrayList<User>()
var tasksList = ArrayList<Task>()


enum class KanbanStatus(var progress: String){
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

enum class MOSCOW(var level : Int){
    must(4),
    should(3),
    could(2),
    would(1),
}


class User(
	val id : Int,
    var name : String,
    var tasks : ArrayList<Task> = ArrayList<Task>()
){
    
    override fun toString() = "{ id: ${this.id}, name: ${this.name}, " + 
                            "haveTasks: ${!this.tasks.isEmpty()} }"

}

class Task(
    var title : String, 
    var priority : MOSCOW? = null, 
    var status : KanbanStatus = KanbanStatus.toDo,
    val author : User
){
    
    override fun toString() = "{ title: $title, priority: $priority, " + 
                    "stauts: $status, author: ${author.name}#${author.id} }"
    
	val type : String
    	get() = this.title.split(":")[0]
    
	fun prioritizeByType(){
        when(this.type){
            "Study" -> this.priority = MOSCOW.must
            "Sell", "Visit" -> this.priority = MOSCOW.should
            "Buy" -> this.priority = MOSCOW.could
            else -> this.priority = MOSCOW.would
        }
    }
    
}

class ManageTasks{
    
    fun add(task : Task){
        tasksList.add(task)
        task.author.tasks.add(task)
    }
    
    fun delete(task : Task) : Boolean{
        if(tasksList.remove(task))
        	return true
        return false
    }
}

class ManageUsers{
    
    fun add(user : User){
        usersList.add(user)
    }
    
    fun delete(user : User) : Boolean{
        var hadSuccess = true
        val taskManager = ManageTasks()
        
        for(userTask in user.tasks){
            hadSuccess = hadSuccess && taskManager.delete(userTask)
        }
        if(hadSuccess){
            hadSuccess = usersList.remove(user)
        }
        
        return hadSuccess
    }
}

fun main() {
    var user1 = User(0, "Emmet")
    var task1 = Task("Visit: Clara", MOSCOW.must, author = user1)
    
    val userManager = ManageUsers()
    userManager.add(user1)
    println(usersList)
    
    user1.name = "Emmet Brown"
    
    println(usersList)
    
}