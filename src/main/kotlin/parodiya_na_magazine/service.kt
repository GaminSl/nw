package parodiya_na_magazine

fun manageFavoritesAndPurchases(brand: Brand) {
    println("Вы выбрали ${brand.name} за ${brand.price} руб.")
    println("Хотите добавить в избранное? (y/n)")
    if (readLine() == "y") {
        addToFavorites(brand.name)
    }

    println("Хотите купить? (y/n)")
    if (readLine() == "y") {
        purchase(brand.name)
    }
}

fun addToFavorites(item: String) {
    favorites.add(item)
    println("$item добавлено в избранное.")
}

fun purchase(item: String) {
    purchases.add(item)
    favorites.remove(item)
    println("$item куплено.")
}

fun buyAllFavorites() {
    for (item in favorites) {
        purchase(item)
    }
    favorites.clear()
    println("Все товары из избранного были успешно куплены!")
}

fun purchaseFromFavorites() {
    println("Выберите товар для покупки:")
    favorites.forEachIndexed { index, item ->
        println("${index + 1}: $item")
    }

    val purchaseChoice = readLine()?.toIntOrNull()
    if (purchaseChoice != null && purchaseChoice in 1..favorites.size) {
        purchase(favorites[purchaseChoice - 1])
    } else {
        println("Неверный выбор.")
    }
}

