package parodiya_na_magazine
data class ProductType(val name: String, val brands: List<Brand>)
data class Brand(val name: String, val price: Int)

enum class MainMenu(val num: Int, val nameOperation: String) {
    EXIT(0, "Выйти из программы"),
    FOOTWEAR_OPERATION(1, "Обувь"),
    CLOTHING_OPERATION(2, "Одежда"),
    ACCESSORIES_OPERATION(3, "Аксессуары"),
    FAVORITES(4, "Избранное"),
    PURCHASES(5, "Покупки")
}

val favorites = mutableListOf<String>()
val purchases = mutableListOf<String>()
