package sample.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import sample.gui.actions;

import java.util.Random;
public class sender1 extends Agent {
    protected void setup() {
        for (int i = 1; i <= 16; i++) {
            ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
            aclMessage.addReceiver(new AID("agent" + i, AID.ISLOCALNAME));
            aclMessage.setContent(actions.t_name[i - 1]);
            send(aclMessage);
        }
        doDelete();
    }
    protected void takeDown() {
    }
}
