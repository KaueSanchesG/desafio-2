package org.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        int opc;
        do {
            opc = Func.menu(clientes);
        } while (opc < 3);
    }
}