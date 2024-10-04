public class Cifra {
    // Criptografar o texto
    public String criptografar(String texto, int pulo) {
        String resultado = "";

        // Converte o texto para letras maiúsculas
        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (Character.isLetter(caractere)) { // Verifica se é uma letra
                char base = 'A'; // Trabalha apenas com letras maiúsculas
                // Calcula o novo caractere, mantendo o alfabeto circular
                char novoCaractere = (char) ((caractere - base + pulo) % 26 + base);
                resultado += novoCaractere;
            } else {
                resultado += caractere;}
        }

        return resultado;
    }

    // Descriptografar o texto
    public String descriptografar(String textoCifrado, int pulo) {
        String resultado = "";

        // Converte o texto para letras maiúsculas
        textoCifrado = textoCifrado.toUpperCase();

        for (int i = 0; i < textoCifrado.length(); i++) {
            char caractere = textoCifrado.charAt(i);

            if (Character.isLetter(caractere)) {
                char base = 'A'; // Trabalha apenas com letras maiúsculas
                // Calcula o caractere original, subtraindo o pulo e mantendo o alfabeto circular
                char novoCaractere = (char) ((caractere - base - pulo + 26) % 26 + base);
                resultado += novoCaractere;
            } else {
                resultado += caractere;}
            }
        return resultado;

    }

}

