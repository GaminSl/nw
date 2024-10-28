package parodiya_na_magazine

fun main() {
    var exit = false
    while (!exit) {
        println("Главное меню:")
        MainMenu.values().forEach { menu ->
            println("${menu.num}: ${menu.nameOperation}")
        }

        val choice = readLine()?.toIntOrNull()

        when (choice) {
            MainMenu.FOOTWEAR_OPERATION.num -> showProductTypes("footwear")
            MainMenu.CLOTHING_OPERATION.num -> showProductTypes("clothing")
            MainMenu.ACCESSORIES_OPERATION.num -> showProductTypes("accessories")
            MainMenu.FAVORITES.num -> showFavorites()
            MainMenu.PURCHASES.num -> showPurchases()
            MainMenu.EXIT.num -> exit = true
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}