class FileNoAccessException(file: String) : RuntimeException("Cannot access file: $file")
class FileNoPermissionException(file: String) : RuntimeException("No permission for file: $file")
class FileNotFoundException(file: String) : RuntimeException("File not found: $file")

class StateParsingException(state: String) : RuntimeException("State parsing error: $state")
class StateAccessException : RuntimeException("Can not get state")