import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import Service.AgendaService;

import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller =  fxmlLoader.getController();

        AgendaValidator validator = new AgendaValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        AgendaService service = new AgendaService(repository);

        service.insert("1","dadad","monday",50,"5");
        service.insert("2","dadad","thursday",67,"9");
        service.insert("3","dadad","friday",56,"8");


        controller.setServices(service);


        primaryStage.setTitle("Agenda manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}