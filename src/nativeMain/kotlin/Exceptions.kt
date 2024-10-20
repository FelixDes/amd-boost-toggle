abstract class UserException(msg: String) : RuntimeException(msg)

class FileNoPermissionException(file: String) : UserException(
    "${RED}No permission${RESET} for file: $file.\n${GREEN_BOLD_BRIGHT}Tip${RESET}: try to use this command with ${GREEN_BOLD_BRIGHT}sudo${RESET}"
)
class FileNotFoundException(file: String) : UserException("File not found: $file")
class FileNoAccessException(file: String) : UserException("Cannot access file: $file")


class StateParsingException(state: String) : UserException("State parsing error: $state")
object StateAccessException : UserException("Can not get state")