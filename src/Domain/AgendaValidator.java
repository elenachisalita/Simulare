package Domain;

public class AgendaValidator {

    /**
     * validates agenda
     * @param agenda to validate
     * @throws AgendaValidatorException if there are validation errors
     */
    public void validate(Agenda agenda){
        String errors="";


        if(!errors.isEmpty()){
            throw new AgendaValidatorException(errors);
        }
    }
}
