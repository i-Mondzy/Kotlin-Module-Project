import java.util.Scanner
import kotlin.system.exitProcess

class GeneralMenu<T : Logic> {
    private val input = Scanner(System.`in`)

    fun show(screen: T) {
        while (true) {
            when(screen) {
                is ArchiveMenu -> {
                    println("Список архивов:")
                    println("0. Создать архив")
                    screen.showArray()
                    println("${screen.getSize() + 1}. Выход")
                }
                is NoteMenu -> {
                    println("Список заметок:")
                    println("0. Создать заметку:")
                    screen.showArray()
                    println("${screen.getSize() + 1}. Назад")
                }
            }

            val choice = choice()

            when(choice) {
                0 -> screen.create()
                in 1..screen.getSize() -> {
                    screen.open(choice - 1)
                }
                screen.getSize() + 1 -> {
                    if (screen is NoteMenu) {
                        return
                    } else {
                        exitProcess(0)
                    }
                }
                in (screen.getSize() + 1)..choice -> println("Неверный ввод. Попробуйте снова\n")
            }
        }
    }

    fun choice(): Int {
        while (true) {
            println("\nВведите команду:")
            val inputUser = input.nextLine()
            val int = inputUser.toIntOrNull()
            if (int != null) {
                println("")
                return int
            } else if (true) {
                println("\nНеверный ввод. Попробуйте снова\n")
                break
            }
        }
        return -1
    }
}