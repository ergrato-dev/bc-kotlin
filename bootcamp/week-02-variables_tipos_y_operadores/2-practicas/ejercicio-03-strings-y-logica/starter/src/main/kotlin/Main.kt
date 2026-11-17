// Ejercicio 03 — Strings y lógica.
// Para resolver un paso: borra su línea TODO y quita `//> ` del principio de sus líneas.

fun main() {
    // PASO 1: plantillas con expresiones.
    TODO("Paso 1")
    //> val name = "ada lovelace"
    //> println("Nombre: ${name.uppercase()}")
    //> println("Letras: ${name.length}")

    // PASO 2: una línea separadora del ancho del título.
    TODO("Paso 2")
    //> val title = "Inventario"
    //> println(title)
    //> println("=".repeat(title.length))

    // PASO 3: columnas alineadas.
    TODO("Paso 3")
    //> println("Producto".padEnd(12) + "Unidades".padStart(10))
    //> println("Café".padEnd(12) + "3".padStart(10))
    //> println("Pan".padEnd(12) + "12".padStart(10))

    // PASO 4: centavos mostrados con dos decimales.
    TODO("Paso 4")
    //> val totalCents = 4505L
    //> println("Total: ${totalCents / 100}.${(totalCents % 100).toString().padStart(2, '0')}")

    // PASO 5: comparaciones y operadores lógicos.
    TODO("Paso 5")
    //> val stock = 2
    //> val requested = 3
    //> val isBlocked = false
    //> val coversRequest = stock >= requested
    //> val canSell = stock > 0 && coversRequest && !isBlocked
    //> println("Cubre el pedido: $coversRequest")
    //> println("Se puede vender: $canSell")
    //> println("Mismo nombre: ${"ADA".lowercase() == "ada"}")
}
