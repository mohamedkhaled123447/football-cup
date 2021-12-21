package sample;

import jade.core.AgentContainer;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    static public Runtime r = Runtime.instance();
    static public Profile profile = new ProfileImpl();
    static public ContainerController c = r.createMainContainer(profile);
    public static void main(String[] args) {
        try {
            Main main = new Main();
            AgentController gui = main.c.createNewAgent("gui", "jade.tools.rma.rma", null);
            gui.start();
            AgentController controller = main.c.createNewAgent("controller", "sample.agents.controller", null);
            controller.start();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
