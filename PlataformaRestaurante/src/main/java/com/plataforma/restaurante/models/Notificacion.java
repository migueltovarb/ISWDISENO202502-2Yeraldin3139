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
    private String destinatarioId; 

    public enum TipoNotificacion {
        PEDIDO_LISTO, ENVIADO, CANCELADO
    }

    public enum EstadoNotificacion {
        PENDIENTE, ENVIADA, FALLIDA
    }

	public TipoNotificacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoNotificacion tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public EstadoNotificacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoNotificacion estado) {
		this.estado = estado;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(String destinatarioId) {
		this.destinatarioId = destinatarioId;
	}
}