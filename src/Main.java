import Inteface.IntefaceGrafica;
import core.CoreLogic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

        public static void main(String[] args) {

            CoreLogic core = new CoreLogic();
            core.behavior();

            new IntefaceGrafica().run(core);
        }
}