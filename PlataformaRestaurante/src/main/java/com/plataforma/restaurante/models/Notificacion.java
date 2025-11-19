package com.plataforma.restaurante.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificaciones")
public class Notificacion {
    @Id
    private String id;
    private TipoNotificacion tipo;
    private String mensaje;
    private Date fechaEnvio;
    private EstadoNotificacion estado;
    private String canal;
    private String destinatarioId; // referencia a Usuario/Cliente

    public enum TipoNotificacion {
        PEDIDO_LISTO, ENVIADO, CANCELADO
    }

    public enum EstadoNotificacion {
        PENDIENTE, ENVIADA, FALLIDA
    }
}