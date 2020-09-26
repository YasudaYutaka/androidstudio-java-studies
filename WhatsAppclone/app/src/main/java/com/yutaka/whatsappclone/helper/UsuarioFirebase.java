package com.yutaka.whatsappclone.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.yutaka.whatsappclone.config.ConfiguracaoFirebase;

public class UsuarioFirebase {

    public static String getIdentificadorUsuario() {
        FirebaseAuth usuario = ConfiguracaoFirebase.getFirebaseAuth();
        String email = usuario.getCurrentUser().getEmail();
        String identificadorUsuario = Base64Custom.codificarBase64(email);

        return identificadorUsuario;
    }

}
