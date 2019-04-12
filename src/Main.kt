
import java.awt.SystemColor.text
import javax.swing.UIManager.put
import java.util.TreeMap

fun main(args: Array<String>) {
    val passwordGenerator : PasswordGenerator = PasswordGenerator.PasswordGeneratorBuilder().useLower(true).build()
    var hundredPasswordRandomTogether = ""

    for (i in 0 until 100){
        hundredPasswordRandomTogether += passwordGenerator.generate(6)
    }
    getDistribution(hundredPasswordRandomTogether)

    println()
    var hundredPasswordNOTRandomTogether = ""
    val passwordGeneratorMy : PasswordGeneratorMy = PasswordGeneratorMy.PasswordGeneratorBuilder().useLower(true).build()
    for (i in 0 until 100){
        Thread.sleep(3)
        hundredPasswordNOTRandomTogether += passwordGeneratorMy.generate(6)
    }
    getDistribution(hundredPasswordNOTRandomTogether)
}

fun getDistribution(text: String){
    val userList = TreeMap<Char, Int>()
    var tempCount = 0

    for (i in 0 until text.length) {
        if (userList.containsKey(text[i])) {
            tempCount = userList[text[i]]!! + 1
            userList[text[i]] = tempCount
        } else {
            userList[text[i]] = 1
        }
    }
    println(userList)
}