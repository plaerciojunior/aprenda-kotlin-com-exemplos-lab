enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableSetOf<Usuario>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    
    val conteudo1 = ConteudoEducacional("Programação 1", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)

    val formacao = Formacao("Desenvolvimento de Software", Nivel.INTERMEDIARIO, mutableListOf(conteudo1, conteudo2))

    val usuario1 = Usuario("Paulo")
    val usuario2 = Usuario("Pedro")
    val usuario3 = Usuario("Maria")
    val usuario4 = Usuario("Carol")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)
    formacao.matricular(usuario4)

    println("Formação: ${formacao.nome}, Nível: ${formacao.nivel}")
    println("Conteúdos:")
    formacao.conteudos.forEach { println("- ${it.nome} (${it.duracao} minutos)") }
    println("Inscritos:")
    formacao.inscritos.forEach { println("- ${it.nome}") }
}
