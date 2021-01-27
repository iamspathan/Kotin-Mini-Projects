package parking

data class Car(val regNo:String , val color:String){
    override fun toString() = "$regNo ($color)"
}