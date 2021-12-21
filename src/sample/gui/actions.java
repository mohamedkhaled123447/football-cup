package sample.gui;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.agents.controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class actions {
    @FXML
    TextField t1;
    @FXML
    TextField t2;
    @FXML
    TextField t3;
    @FXML
    TextField t4;
    @FXML
    TextField t5;
    @FXML
    TextField t6;
    @FXML
    TextField t7;
    @FXML
    TextField t8;
    @FXML
    TextField t9;
    @FXML
    TextField t10;
    @FXML
    TextField t11;
    @FXML
    TextField t12;
    @FXML
    TextField t13;
    @FXML
    TextField t14;
    @FXML
    TextField t15;
    @FXML
    TextField t16;
    @FXML
    TextField t17;
    @FXML
    TextField t18;
    @FXML
    TextField t19;
    @FXML
    TextField t20;
    @FXML
    TextField t21;
    @FXML
    TextField t22;
    @FXML
    TextField t23;
    @FXML
    TextField t24;
    @FXML
    TextField t25;
    @FXML
    TextField t26;
    @FXML
    TextField t27;
    @FXML
    TextField t28;
    @FXML
    TextField t29;
    @FXML
    TextField t30;
    @FXML
    TextField t31;
    @FXML
    Button add;
    @FXML
    Button play;
    @FXML
    Button next;
    @FXML
    Label winer;
    static public TextField[] t = new TextField[50];
    static public String t_name[] = new String[50];
    static public int num = 5, n_teams = 16, num1 = 16;
    static public boolean vis[] = new boolean[50];
    static public int arr[] = new int[n_teams];
    static public String name[] = new String[50];
    static public Map<String, Integer> map = new HashMap<String, Integer>();
    static public String stadium[] = {"Arrowhead Bowl", "Beaver Stadium", "Canvas Field",
            "Dawn Ground", "Ember Bowl", "Horoscope Park", "Ivory Park", "Kyle Field", "Marvel Ground", "Michigan Stadium",
            "Ballpark Stadium", "The Ex Stadium"
    };

    public void copy(ActionEvent e) throws StaleProxyException {
        //copy textfields in array
        int ind = 1;
        String s = "sample.agents.agent";
        for (int i = 0; i < 16; i++) {
            AgentController a = Main.c.createNewAgent("agent" + ind, s + ind, null);
            a.start();
            ind++;
        }
        t[0] = t1;
        t[1] = t2;
        t[2] = t3;
        t[3] = t4;
        t[4] = t5;
        t[5] = t6;
        t[6] = t7;
        t[7] = t8;
        t[8] = t9;
        t[9] = t10;
        t[10] = t11;
        t[11] = t12;
        t[12] = t13;
        t[13] = t14;
        t[14] = t15;
        t[15] = t16;
        t[16] = t17;
        t[17] = t18;
        t[18] = t19;
        t[19] = t20;
        t[20] = t21;
        t[21] = t22;
        t[22] = t23;
        t[23] = t24;
        t[24] = t25;
        t[25] = t26;
        t[26] = t27;
        t[27] = t28;
        t[28] = t29;
        t[29] = t30;
        t[30] = t31;
        for (int i = 0; i < 16; i++)
            t_name[i] = t[i].getText();

        AgentController agent = Main.c.createNewAgent("sender1", "sample.agents.sender1", null);
        agent.start();
        for (int i = 1; i <= 16; i++) {
            map.put(t[i - 1].getText(), i);
        }
        for (int i = 0; i < n_teams; i++) {
            arr[i] = num % 16;
            name[i] = t[arr[i]].getText();
            num += 5;
        }
        for (int i = 0; i < 16; i++) {
            t[i].setText(name[i]);
        }
        add.setVisible(false);
    }


    public void play(ActionEvent e) throws ControllerException {
        AgentController a = Main.c.createNewAgent("sender", "sample.agents.sender", null);
        a.start();
    }

    public void next(ActionEvent e) throws ControllerException {
        int ind = 0;
        String winer[] = new String[20];
        for (int i = 0; i < n_teams; i += 2) {
            int x = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
            if (x == 0) {
                t[num1].setText(name[i]);
                winer[ind++] = name[i];
                Main.c.getAgent("agent" + map.get(name[i + 1])).kill();
            } else {
                t[num1].setText(name[i + 1]);
                winer[ind++] = name[i + 1];
                Main.c.getAgent("agent" + map.get(name[i])).kill();
            }
            num1++;
        }
        n_teams /= 2;
        for (int i = 0; i < n_teams; i++)
            name[i] = winer[i];
        if (n_teams == 1) {
            play.setVisible(false);
            next.setVisible(false);
        }
        System.out.println("--------------------\n");
    }
}
