package sample.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import sample.gui.actions;

import java.util.StringTokenizer;

public class agent10 extends Agent {
    String name = "agent10";

    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage aclMessage = receive();
                if (aclMessage != null) {
                    if (aclMessage.getSender().getLocalName().equals("sender1")) {
                        name = aclMessage.getContent();
                    } else {
                        StringTokenizer s = new StringTokenizer(aclMessage.getContent(), "|");
                        String team = s.nextToken();
                        String stadium = s.nextToken();
                        System.out.println("i am team " + name + " and i will play team " + team + " at stadium " + stadium);
                    }
                }
            }
        });
    }

    protected void takeDown() {

    }
}
