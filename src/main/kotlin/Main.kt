const val PST_SUM_MONTH_USER = 1_U
const val PST_SUM_UP = 5_U
const val DISCOUNT_MONTH_USER = 100_U

const val PURCHASES_SUM_LOW = 1_001_U
const val PURCHASES_SUM_MID = 10_000_U
const val PURCHASES_SUM_UP = 10_001_U

fun main() {
    print("Введите предыдущую сумму покупок в рублях: ")
    val previousPurchasesSum: UInt = readLine()?.toUInt() ?: return
    print("Введите '1', если клиент осуществляет покупки ежемесячно, и '0' - если нет: ")
    val temp = readLine()?.toUInt() ?: return
    val isPermanentUser = if(temp == 1U) true else false
    val nowPurchasesSum: UInt = if (previousPurchasesSum in PURCHASES_SUM_LOW..PURCHASES_SUM_MID) {
        previousPurchasesSum - DISCOUNT_MONTH_USER
    } else if (previousPurchasesSum >= PURCHASES_SUM_UP) {
        previousPurchasesSum - (previousPurchasesSum * PST_SUM_UP / 100_U)
    } else {
        previousPurchasesSum
    }
    val result = if (isPermanentUser) nowPurchasesSum - (nowPurchasesSum * PST_SUM_MONTH_USER / 100_U) else nowPurchasesSum
    println("Для данного покупателя музыки, сумма со скидкой $result рублей")
}