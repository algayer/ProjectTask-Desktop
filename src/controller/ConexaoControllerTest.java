package controller;

import com.example.common.utils.ResponseObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoControllerTest {

    private static final Logger LOGGER = Logger.getLogger(ConexaoControllerTest.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "[Test] Iniciando teste de conexão...");

        ConexaoController controller = new ConexaoController();

        String username = "Algayer";
        String password = "Senha14051979";

        LOGGER.log(Level.INFO, "[Test] Preparando para enviar a requisição de login");
        LOGGER.log(Level.INFO, "[Test] Nome de usuário: {0}", username);
        LOGGER.log(Level.INFO, "[Test] Senha de usuário: {0}", password);

        ResponseObject response = controller.sendLoginRequest(username, password);

        LOGGER.log(Level.INFO, "[Test] Resposta recebida do servidor");
        LOGGER.log(Level.INFO, "[Test] Sucesso: {0}", response.isSuccess());
        LOGGER.log(Level.INFO, "[Test] Mensagem: {0}", response.getMessage());
        if (response.getData() == null) {
            LOGGER.log(Level.INFO, "[Test] Sem dados na resposta");
        } else {
            LOGGER.log(Level.INFO, "[Test] Dados: {0}", response.getData().toString());
        }

        controller.closeConecction();
        LOGGER.log(Level.INFO, "[Test] Conexão perdida.");
    }
}
