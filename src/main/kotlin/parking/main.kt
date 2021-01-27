package parking

import java.util.*

val scanner = Scanner(System.`in`)
fun main(){
    Parking.start()
}

object Parking {
    lateinit var parkingLot: ParkingLot
    fun start(){
        with(scanner) {
            while (true) {
                println(when(val command = next()){
                    "exit" -> return
                    "create" -> {
                        val spots = nextInt()
                        parkingLot = ParkingLot(spots)
                        "Created a parking lot with $spots spots"
                    }else ->
                        if(::parkingLot.isInitialized) with(parkingLot){
                            when(command){
                                "park" -> park(next(),next())
                                "leave" -> leave(nextInt())
                                "status" -> toString()
                                "reg_by_color" -> regByColor(next())
                                "spot_by_color" -> spotByColor(next())
                                "spot_by_regno" -> spotByRegno(next())
                                else -> "No as such methods available"
                            }
                        }
                    else{
                            nextLine(); "Sorry a parking lot has not been created."}
                        })
                }
            }
        }
    }
