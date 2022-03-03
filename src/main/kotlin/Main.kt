fun main() {
    val previousPurchasesSum = 12_400
    val isPermanentUser = true
    val nowPurchasesSum: Int = if (previousPurchasesSum in 1_001..10_000) {
        previousPurchasesSum - 100
    } else if (previousPurchasesSum >= 10_001) {
        previousPurchasesSum - (previousPurchasesSum * 5 / 100)
    } else {
        previousPurchasesSum
    }
    val result = if (isPermanentUser) nowPurchasesSum - (nowPurchasesSum * 1 / 100) else nowPurchasesSum
    println("Постоянный покупатель музыки, сумма со скидкой $result рублей")
}