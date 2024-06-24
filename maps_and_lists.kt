// A simple notepad application
var users = HashMap<Int, String> ()
var notes = HashMap<Int, ArrayList<String>> ()

fun initializeValues(){
    users = hashMapOf(
        Pair(0, "John"),
        Pair(1, "Karol"),
        Pair(2, "Susan")
    )
    
    val johnNotes = arrayListOf(
    	"Clean: the House",
        "Wash: your Clothes"
    )
    
    val karolNotes = arrayListOf(
    	"Visit: Museum",
        "Finish: Project code"
    )
    
    notes = hashMapOf(
    	0 to johnNotes,
        1 to karolNotes,
        2 to ArrayList<String>()
    )
}

fun showUsers(){
    println("\nList of Users\n")
    if(users.isEmpty()){
        println("There're no users to be shown")
    }else{
    	for(user in users){
            println("[${user.key}] => ${user.value}")
        }    
    }
}

fun addUser(userName : String) : Pair<Int, String>{
    val newUser = Pair(users.count(), userName)
    users.put(newUser.first, newUser.second)
    notes.put(newUser.first, ArrayList<String>())
    return newUser
}

fun deleteUser(userId : Int) : Pair<Int, String>{
    val userName = users.remove(userId)
    if(userName == null){
        return Pair(404, "User id '$userId' not found")
    }
    notes.remove(userId)
    return Pair(userId, userName)
}

fun addNote(userId : Int, noteText : String) : ArrayList<String>{
    var userNotes = notes.get(userId)
    println(userNotes ?: "Nulo chefe")
    if(userNotes != null){
        println(userNotes.add(noteText))
    }
    return userNotes ?: arrayListOf("Couldn't find notes for the user id '$userId'")
}

fun removeNote(userId : Int, noteText : String) : String{
    var userNotes = notes.get(userId)
    var deletedNote = "Couldn't find notes for the user id '$userId'"
    if(userNotes != null){
        if(userNotes.remove(noteText)){
            deletedNote = noteText
        }else{
            deletedNote = "Couldn't find the note '$noteText'"
        }
    }
    return deletedNote
}

fun editNote(userId : Int, oldNoteText : String, newNoteText : String) : String{
    var userNotes = notes.get(userId)
    var feedback = "Couldn't find notes for the user id '$userId'"
    if(userNotes != null){
        val noteIndex = userNotes.indexOf(oldNoteText)
        if(noteIndex != -1){
            userNotes[noteIndex] = newNoteText
            feedback = "[$noteIndex] => $newNoteText"
        }else{
            feedback = "Couldn't find the note '$oldNoteText'"
        }
    }
    return feedback
}

fun showNotesPerUser() {
   	for(user in users){
        println("\n${user.value}'s notes!\n")
        
        val userNotes = notes.get(user.key) ?: ArrayList<String>()
        
        if(userNotes.isEmpty()){
            println("*There're no notes to be shown")
        }else{
            for(note in userNotes){
                println("====================")
                println(note)
            }
        }
        
        println("====================")
        
    }
}


fun main() {
    initializeValues()
    println(addNote(2, "Move: To a new City"))
    println(addNote(2, "Buy: My Video Game"))
    println(addNote(2, "Buy: My Video Game"))
    showNotesPerUser()
    println("\n" + editNote(2, "Buy: My Video Game", "Sell: My Old Video Game") + "\n")
    showNotesPerUser()
}