package br.com.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Grupo;

@SuppressWarnings("serial")
public class converterGrupo implements Converter,Serializable {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {

		if (str == null || str.equals("Selecione um grupo")) {
			return null;
		}

		return EntityManagerUtil.getEntityManager().find(Grupo.class,
				Integer.parseInt(str));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj == null) {
			return null;
		}
		Grupo grupo = (Grupo) obj;
		return grupo.getId().toString();

	}

}
