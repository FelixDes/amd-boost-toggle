import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.groups.mutuallyExclusiveOptions
import com.github.ajalt.clikt.parameters.options.convert
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option

class TurboBoostToggle : CliktCommand() {
    private val stateTransition: BoostState? by mutuallyExclusiveOptions(
        option("--enable", "-e").flag().convert { BoostState.ENABLED },
        option("--disable", "-d").flag().convert { BoostState.DISABLED },
    )
    private val shouldPrint by option("--out", "-o", help = "return state").flag()

    override fun help(context: Context): String {
        return "Toggles turbo boost on AMD processors"
    }

    override fun run() {
        try {
            when (stateTransition) {
                BoostState.ENABLED -> BoostService.enable()
                BoostState.DISABLED -> BoostService.disable()
                null -> {}
            }

            if (shouldPrint) {
                echo(BoostService.getState())
            }
        } catch (e: RuntimeException) {
            echo(e.message)
        }
    }
}

fun main(args: Array<String>) = TurboBoostToggle().main(args)