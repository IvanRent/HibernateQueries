package org.modelo.report.dos;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Repor {
	

		private int id;
		private String tipo;
		private String folio;
		private String comentario;
		
		@Id
		@Column(nullable=false)
		@GeneratedValue
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getFolio() {
			return folio;
		}
		public void setFolio(String folio) {
			this.folio = folio;
		}
		public String getComentario() {
			return comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		


}
