package sample.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import javafx.application.Application;
import sample.gui.actions;

import java.util.Random;

public class sender extends Agent {
    protected void setup() {
        for (int i = 0; i < actions.n_teams; i += 2) {
            int x = new Random().nextInt(10 - 0 + 1) + 0;
            ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
            aclMessage.addReceiver(new AID("agent" + actions.map.get(actions.name[i]), AID.ISLOCALNAME));
            aclMessage.setContent(actions.name[i + 1] + "|" + actions.stadium[x]);
            send(aclMessage);
            ACLMessage aclMessage1 = new ACLMessage(ACLMessage.INFORM);
            aclMessage1.addReceiver(new AID("agent" + actions.map.get(actions.name[i + 1]), AID.ISLOCALNAME));
            aclMessage1.setContent(actions.name[i] + "|" + actions.stadium[x]);
            send(aclMessage1);
        }
        doDelete();
    }

    protected void takeDown() {
    }
}
