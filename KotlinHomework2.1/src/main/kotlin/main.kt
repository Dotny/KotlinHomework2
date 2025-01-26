fun main(){
    agoToText(1188000)
}

fun agoToText(time: Int){
    when{
        time > 0 && time < 60 -> println("был(а) только что")
        time >= 60 && time < 60 * 60 -> println("был(а) ${time / 60} ${correctMinutes(time / 60)} назад")
        time >= 60 * 60 && time < 24 * 60 * 60 -> println("был(а) ${time / 3600} ${correctHours(time / 3600)} назад")
        time >= 24 * 60 * 60 && time < 2 * 24 * 60 * 60 -> println("был(а) вчера")
        time >= 2 * 24 * 60 * 60 && time <= 3 * 24 * 60 * 60 -> println("был(а) позавчера")
        else -> return print("был(а) давно")
    }
}

fun correctMinutes(time: Int): String{
    when{
        time % 10 == 1 && time != 11 -> return "минуту"
        time % 10 == 2 || time % 10 == 3 || time % 10 == 4 && time != 12 && time != 13 && time != 14 -> return "минуты"
        else -> return "минут"
    }
}

fun correctHours(time: Int): String{
    when{
        time == 1 || time == 21 -> return "час"
        time > 1 && time <= 20 -> return "часов"
        else -> return "часа"
    }
}
