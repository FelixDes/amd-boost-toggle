import kotlinx.cinterop.*
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
object BoostService {
    private const val boostFile = "/sys/devices/system/cpu/cpufreq/boost"

    fun enable() {
        write(BoostState.ENABLED)
    }

    fun disable() {
        write(BoostState.DISABLED)
    }

    fun getState(): BoostState {
        requireRead()
        val fd = fopen(boostFile, "r")

        try {
            memScoped {
                val readBufferLength = 4
                val buffer = allocArray<ByteVar>(readBufferLength)
                val res = fgets(buffer, readBufferLength, fd)?.toKString() ?: throw StateAccessException()
                return stateFromLinuxString(res)
            }
        } finally {
            fclose(fd)
        }
    }

    private fun write(state: BoostState) {
        requireWrite()
        val fd = fopen(boostFile, "r+")
        try {
            memScoped {
                val writeRes = fputs(state.toLinuxString(), fd)
                if (writeRes == EOF) throw StateAccessException()
            }
        } finally {
            fclose(fd)
        }
    }

    private fun requireRead() {
        checkAccess(F_OK or R_OK)
    }

    private fun requireWrite() {
        checkAccess(F_OK or W_OK)
    }

    private fun checkAccess(flag: Int) {
        val res = access(boostFile, flag)
        if (res == -1) {
            when (errno) {
                13 -> throw FileNoPermissionException(boostFile)
                2 -> throw FileNotFoundException(boostFile)
                else -> throw FileNoAccessException(boostFile)
            }
        }
    }

    private fun BoostState.toLinuxString(): String {
        return when (this) {
            BoostState.ENABLED -> "1\n"
            BoostState.DISABLED -> "0\n"
        }
    }

    private fun stateFromLinuxString(string: String): BoostState {
        return when (string.trim()) {
            "1" -> BoostState.ENABLED
            "0" -> BoostState.DISABLED
            else -> throw StateParsingException(string)
        }
    }
}