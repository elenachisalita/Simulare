package UI;

import Domain.Agenda;
import Service.AgendaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public TableView tableViewAgendas;
    public TableColumn tableColumnId;
    public TableColumn tableColumnDescription;
    public TableColumn tableColumnDay;
    public TableColumn tableColumnDuration;
    public TableColumn tableColumnHour;
    public TextField txtAgendaDayForMax;
    public Label max;

    public AgendaService service;


    private ObservableList<Agenda> agendas = FXCollections.observableArrayList();


    public void setServices(AgendaService service) {
        this.service = service;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            agendas.addAll(service.getAll());
            tableViewAgendas.setItems(agendas);
        });
    }


    public void btnAgendaAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("agendaAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add event");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            AgendaAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            agendas.clear();
            agendas.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Movie update.", e);
        }

    }

    public void btnAgendasMaxClick(ActionEvent actionEvent) {
        String a = txtAgendaDayForMax.getText();

        try {
            if (a.length() == 0) {
                throw new RuntimeException("Give the day correctly");
            }
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        int maxOfAll = 0;
        List<Agenda> all = service.getAll();
        for (Agenda i : all) {
            if (i.getDay().equals(a)) {
                if(i.getDuration() > maxOfAll)
                     maxOfAll = i.getDuration();

            }
        }
        max.setText(maxOfAll + "");
    }
}