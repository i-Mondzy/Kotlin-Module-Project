import java.util.Scanner

class NoteMenu(private val array: MutableList<Note>): Logic {
    private val input = Scanner(System.`in`)
    private val generalMenu = GeneralMenu<ArchiveMenu>()

    override fun create() {
        println("Введите навазние заметки:")
        array.add(Note(input.nextLine(), ""))
        if (array.last().name.isBlank()) {
            println("Название заметки не может быть пустым\n")
            array.removeLast()
            return
        }

        println("\nНапишите что-либо в заметке:")
        val input = input.nextLine()
        if (input.isNotBlank()) {
            println("")
            array.last().content = input
        } else {
            println("Текст заметки не может быть пустым\n")
            array.removeLast()
        }
    }

    override fun open(index: Int) {
        while (true) {
            println("0. Вернуться назад")
            println(array[index].content)

            val choice = generalMenu.choice()

            when(choice) {
                0 -> return
                in 1..choice -> println("Неверный ввод. Попробуйте снова")
            }
        }
    }

    override fun showArray(){
        var index = 0
        for (note in array) {
            index++
            println("$index. ${note.name}")
        }
    }

    override fun getSize(): Int {
        return array.size
    }
}