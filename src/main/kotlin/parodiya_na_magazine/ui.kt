package parodiya_na_magazine
fun showProductTypes(type: String) {
    val productTypes = when (type) {
        "footwear" -> listOf(
            ProductType("Кроссовки", listOf(Brand("Nike", 7000), Brand("Adidas", 6500))),
            ProductType("Ботинки", listOf(Brand("Timberland", 8000), Brand("Dr. Martens", 7500)))
        )
        "clothing" -> listOf(
            ProductType("Футболки", listOf(Brand("H&M", 1500), Brand("Zara", 2000))),
            ProductType("Джинсы", listOf(Brand("Levi's", 3000), Brand("Gap", 2500)))
        )
        "accessories" -> listOf(
            ProductType("Ремни", listOf(Brand("Gucci", 5000), Brand("Calvin Klein", 4000))),
            ProductType("Сумки", listOf(Brand("Chanel", 20000), Brand("Prada", 18000)))
        )
        else -> emptyList()
    }

    println("Выберите раздел")
    productTypes.forEachIndexed { index, product ->
        println("${index + 1}: ${product.name}")
    }

    val typeChoice = readLine()?.toIntOrNull()
    if (typeChoice != null && typeChoice in 1..productTypes.size) {
        showBrands(productTypes[typeChoice - 1])
    } else {
        println("Неверный выбор.")
    }
}
fun showBrands(productType: ProductType) {
    println("Выберите бренд ")
    productType.brands.forEachIndexed { index, brand ->
        println("${index + 1}: ${brand.name} - ${brand.price} руб.")
    }

    val brandChoice = readLine()?.toIntOrNull()
    if (brandChoice != null && brandChoice in 1..productType.brands.size) {
        val selectedBrand = productType.brands[brandChoice - 1]
        manageFavoritesAndPurchases(selectedBrand)
    } else {
        println("Неверный выбор.")
    }
}
fun showFavorites() {
    if (favorites.isEmpty()) {
        println("Избранное пусто.")
    } else {
        println("Избранное:")
        favorites.forEach { item ->
            println("  - $item (можно купить!)")
        }

        println("Что вы хотите сделать?")
        println("(1) Купить все товары из избранного")
        println("(2) Выбрать конкретный товар для покупки")
        println("(3) Вернуться в главное меню")

        val action = readLine()?.toIntOrNull()
        when(action) {
            1 -> buyAllFavorites()
            2 -> purchaseFromFavorites()
            3 -> return
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}
fun showPurchases() {
    if (purchases.isEmpty()) {
        println("Покупки пусты.")
    } else {
        println("Покупки:")
        purchases.forEach { item ->
            println("  - $item")
        }
    }
}