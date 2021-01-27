package parking

class ParkingLot (val size: Int){
    // Map Number:Car Eg: LOT2->Swift
    private val lot = mutableMapOf<Int,Car>()

    fun park(regNo: String, color: String):String {
        val freeSpot = (1..size).firstOrNull{
            it !in lot
        } ?:1

        return if (lot.size == size) "Sorry, the Parking Lot is Full" else {
            lot[freeSpot] = Car(regNo,color)
            "$regNo having $color color car parked in spot $freeSpot"
        }
    }

    // Remove the car from the Lot
    fun leave(spot: Int) = if (lot.containsKey(spot)){
        lot.remove(spot)
        "Spot $spot is free"
    }else{
        "There is no car in the spot $spot"
    }


    fun regByColor(color: String) = lot.values.filter {car->
        car.color.equals(color,true)}.joinToString(",") {
        it.regNo }
        .ifEmpty { "No cars with color $color found in the lot" }


    fun spotByColor(color: String) = lot.filter {
        it.value.color.equals(color, true)}.map {it.key }.joinToString(", ")
        .ifEmpty { "No cars with color $color were found" }

    fun spotByRegno(regN:String) = lot.filter {
        it.value.regNo == regN}.map { it.key }
        .singleOrNull() ?: "No cars with registration number $regN were found"

    override fun toString(): String {
        val state = mutableListOf<String>()
        lot.forEach{
            with(it){
                state.add("SPOT $key -> $value") } }
        return state.joinToString("\n").ifEmpty {
            "Parking lot is empty" } }
    }




