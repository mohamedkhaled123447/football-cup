package sample.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import javafx.application.Application;
import sample.Main;

public class controller extends Agent {
    protected void setup() {
        Application.launch(sample.gui.gui.class);

    }

    protected void takeDown() {



    }
}
