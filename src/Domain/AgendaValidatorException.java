package Domain;

public class AgendaValidatorException extends  RuntimeException{


    AgendaValidatorException(String message) {

        super("Invoice Validator Exception ||| " + message);
    }

}
