import kotlin.system.exitProcess

const val HELP_MESSAGE = """amd-boost-toggle [<options>]

    Toggles turbo boost on AMD processors

Options:
  -e, --enable
  -d, --disable
  -o, --out      return state
  -h, --help     Show this message and exit"""


fun main(args: Array<String>) {
    val mappings = mapOf(
        "--out" to "-o",
        "--help" to "-h",
        "--enable" to "-e",
        "--disable" to "-d",
    )
    val exclusives: Set<String> = setOf("-e", "-d")

    val preparedArgs: Set<String> = args
        .map { mappings.getOrElse(it) { it } }
        .toSet()

    val unknownArgs = preparedArgs.subtract(mappings.values.toSet())
    val res = when {
        preparedArgs.contains("-h") or preparedArgs.isEmpty() -> HELP_MESSAGE to 1

        unknownArgs.isNotEmpty() -> "Unknown arguments: $unknownArgs\nTry '--help' for more information" to 1

        preparedArgs.containsAll(exclusives) -> "Exclusive arguments" to 1

        else -> {
            var willPrint = false

            try {
                preparedArgs.forEach {
                    when (it) {
                        "-o", "--out" -> willPrint = true
                        "-e", "--enable" -> BoostService.enable()
                        "-d", "--disable" -> BoostService.disable()
                    }
                }

                if (willPrint)
                    BoostService.getState() to 0
                else "" to 0
            } catch (e: UserException) {
                e.message to 1
            }
        }
    }
    println(res.first)
    exitProcess(res.second)
}