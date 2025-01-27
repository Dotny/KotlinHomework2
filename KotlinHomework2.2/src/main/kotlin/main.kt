fun main(){
    commission("Mastercard", 60000, 100000)
}

fun commission(cardType: String, amountTransferPerMonth: Int, amountTransfer: Int) {
    when{
        amountTransfer > 150000 -> println("превышен лимит переводов за день")
        amountTransferPerMonth + amountTransfer > 600_000 -> println("Превышен лимит переводов за месяц")
        else -> println("Коммисия составляет: ${cardToCommisions(cardType, amountTransferPerMonth, amountTransfer)}")
    }
}

fun cardToCommisions(cardType: String, amountTransferPerMonth: Int = 0, amountTransfer: Int): Int{
    when(cardType){
        "Mastercard" -> when{
                            amountTransferPerMonth > 75000 -> return (amountTransfer * 0.006 + 20).toInt()
                            amountTransferPerMonth + amountTransfer > 75000 -> return ((amountTransferPerMonth + amountTransfer - 75000) * 0.006 + 20).toInt()
                            else -> return 0
                    }
        "Visa" -> if (amountTransfer * 0.0075 > 35) return (amountTransfer * 0.0075).toInt() else return 35
        else -> return 0
    }
}