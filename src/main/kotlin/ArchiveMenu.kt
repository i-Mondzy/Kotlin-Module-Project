import java.util.Scanner

class ArchiveMenu: Logic {
    private val array = mutableListOf<Archive>()
    private val input = Scanner(System.`in`)
    private val generalMenu = GeneralMenu<NoteMenu>()

    override fun create() {
        println("Введите навазние архива:")
        array.add(Archive(input.nextLine(), mutableListOf()))
        if (array.last().name.isNotBlank()) {
            println("")
            return
        } else {
            println("Название архива не может быть пустым\n")
            array.removeLast()
        }
    }

    override fun open(index: Int) {
        generalMenu.show(NoteMenu(array[index].notes))
    }

    override fun showArray(){
        var index = 0
        for (archive in array) {
            index++
            println("$index. ${archive.name}")
        }
    }

    override fun getSize(): Int {
        return array.size
    }
}