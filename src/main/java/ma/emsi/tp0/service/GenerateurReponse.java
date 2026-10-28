
package ma.emsi.tp0.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenerateurReponse {

    // Cette methode choisit le traitement selon le role selectionne.
    public String genererReponse(String roleSysteme, String question) {

        if (question == null || question.isBlank()) {
            return "Veuillez saisir une question.";
        }

        if (roleSysteme == null || roleSysteme.isBlank()) {
            return "Veuillez choisir un role.";
        }

        String role = roleSysteme.toLowerCase();

        // Si le role est traducteur, on utilise le dictionnaire.
        if (role.contains("interpreter")) {
            return traduire(question);
        }

        // Le guide touristique donne quelques informations sur les lieux.
        if (role.contains("travel guide")) {
            return guiderTouriste(question);
        }

        // Pour le role Assistant, on analyse le type de message.
        return analyserMessage(question);
    }

    // Cette methode traduit quelques phrases connues dans les deux langues.
    private String traduire(String texte) {

        String phrase = texte.trim().toLowerCase();

        switch (phrase) {
            case "bonjour":
                return "Hello";

            case "salut":
                return "Hi";

            case "bonsoir":
                return "Good evening";

            case "merci":
                return "Thank you";

            case "au revoir":
                return "Goodbye";

            case "bonjour, comment allez-vous ?":
            case "bonjour, comment allez-vous?":
                return "Hello, how are you?";

            case "comment allez-vous ?":
            case "comment allez-vous?":
                return "How are you?";

            case "je vais bien":
                return "I am fine";

            case "je m'appelle yahya":
                return "My name is Yahya";

            case "j'apprends java.":
            case "j'apprends java":
                return "I am learning Java.";

            case "hello":
                return "Bonjour";

            case "hi":
                return "Salut";

            case "good morning":
                return "Bonjour";

            case "good evening":
                return "Bonsoir";

            case "thank you":
                return "Merci";

            case "goodbye":
                return "Au revoir";

            case "hello, how are you?":
                return "Bonjour, comment allez-vous ?";

            case "how are you?":
                return "Comment allez-vous ?";

            case "i am fine":
                return "Je vais bien";

            case "my name is yahya":
                return "Je m'appelle Yahya";

            case "i am learning java.":
            case "i am learning java":
                return "J'apprends Java.";

            default:
                return "Cette phrase n'est pas encore dans le "
                        + "dictionnaire du traducteur : " + texte;
        }
    }

    // Pour ce role, le programme reconnait quelques destinations.
    private String guiderTouriste(String question) {

        String texte = question.toLowerCase();

        if (texte.contains("marrakech")) {
            return "Marrakech est une ville connue pour sa medina, "
                    + "la place Jemaa el-Fna, ses souks et le jardin Majorelle.";
        }

        if (texte.contains("casablanca")) {
            return "A Casablanca, vous pouvez visiter la mosquee Hassan II, "
                    + "la corniche et le centre-ville.";
        }

        if (texte.contains("paris")) {
            return "A Paris, les lieux celebres comprennent la tour Eiffel, "
                    + "le musee du Louvre et la cathedrale Notre-Dame.";
        }

        if (texte.contains("maroc")) {
            return "Le Maroc offre plusieurs destinations, comme Marrakech, "
                    + "Fes, Chefchaouen, Agadir et le desert du Sahara.";
        }

        if (texte.contains("france")) {
            return "En France, vous pouvez visiter Paris, Lyon, Nice, "
                    + "Bordeaux et les regions des Alpes.";
        }

        return "Pour vous conseiller, indiquez une ville ou un pays "
                + "que vous souhaitez visiter.";
    }

    // L'assistant classe le message et propose une piste de reponse.
    private String analyserMessage(String question) {

        String texte = question.trim();
        String minuscule = texte.toLowerCase();

        if (minuscule.startsWith("bonjour")
                || minuscule.startsWith("salut")
                || minuscule.startsWith("bonsoir")) {

            return "Type de message : salutation\n"
                    + "Reponse proposee : Bonjour ! Comment puis-je "
                    + "vous aider ?";
        }

        if (minuscule.endsWith("?")
                || minuscule.startsWith("comment")
                || minuscule.startsWith("pourquoi")
                || minuscule.startsWith("quel")
                || minuscule.startsWith("quelle")
                || minuscule.startsWith("quels")
                || minuscule.startsWith("quelles")
                || minuscule.startsWith("qui")
                || minuscule.startsWith("quand")
                || minuscule.startsWith("ou ")) {

            return "Type de message : question\n"
                    + "Question recue : " + texte + "\n"
                    + "Piste de reponse : identifiez le sujet demande, "
                    + "puis donnez une reponse directe avec une explication "
                    + "ou un exemple.";
        }

        return "Type de message : phrase ou demande\n"
                + "Message recu : " + texte + "\n"
                + "Analyse : identifiez l'idee principale du message "
                + "avant de proposer une reponse adaptee.";
    }
}
